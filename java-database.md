# Akses Database dengan Java #

## Evolusi Teknik Akses Database Java ##

* JDBC
* SQL Mapper
* Resource Management
* ORM
* JPA
* Spring Data

### JDBC ###

* Java DataBase Connectivity
* Open/Close Connection
* Jalankan SQL Query (native : spesifik sesuai merek dan versi database)
* Mengurus Database Transaction
* Konversi sendiri dari ResultSet menjadi struktur Object

### SQL Mapper ###

* Mengeluarkan SQL dari kode program Java, pindah ke file text
* Contoh produk : iBatis, sekarang namanya [MyBatis](https://mybatis.github.io/)
* Contoh pemakaian iBatis bisa dilihat [di aplikasi playBilling](http://sourceforge.net/p/playbilling/code/HEAD/tree/trunk/src/com/artivisi/billing/dao/ibatis/Member-hsqldb.xml)

### Resource Management ###

* Database Connection diurus oleh library
* Database Connection Pooling: waktu aplikasi start, langsung buat beberapa connection. Begitu ada yang butuh koneksi, pinjam dari pool. Setelah selesai, kembalikan ke pool (tidak diclose)
* Transaction Management. Cukup deklarasi method mana yang mau dijalankan dalam transaction.
* Transaction Propagation. Transaction bisa menyeberang lintas method. Ada beberapa konfigurasi propagation:

    * REQUIRED (default) : butuh transaction, kalau belum ada, start baru. Kalau sudah ada, ikut nebeng.
    * REQUIRES_NEW : butuh transaction sendiri. Kalau belum ada, start baru. Kalau sudah ada (`t1`), suspend `t1`, start `t2`. Setelah selesai, commit `t2`, resume `t1`. Biasa digunakan untuk audit trail/log.
    * MANDATORY
    * NEVER
    * SUPPORTED
    * NOT_SUPPORTED

* Referensi lengkap tentang transaction management bisa dibaca di [buku InfoQ](http://www.infoq.com/minibooks/JTDS)

### ORM ###

* Object Relational Mapping
* Contoh produk: Hibernate, Toplink, JDO, dsb
* Programmer mendefinisikan mapping dari class ke tabel database
* Native SQL akan dibuatkan oleh ORM
* Untuk melakukan query, kita pakai bahasa QL yang disediakan oleh ORM, misalnya HQL.
* Generasi pertama : XML Mapping
* Generasi berikutnya : Annotation Mapping (`@Entity`, `@Column`, dsb)

### JPA ###

* Standarisasi dari semua ORM
* ORM yang ada, hanya dianggap library implementasi
* Programmer coding menggunakan class dan QL dari JPA. Contoh

    * Hibernate: HQL. JPA: JPQL.
    * Hibernate: `Session`. JPA: `EntityManager`

### Spring Data ###

* Mengabstraksi semua model database (relational, key-value, document, graph, [dan sebagainya](https://en.wikipedia.org/wiki/NoSQL) )
* Query Method : `findByUsernameStartsWithAndEmailLikeOrderByFullnameAsc`
* CRUD, Paging, Sorting, sudah disediakan (tidak perlu bikin sendiri)
* [Tutorial Spring Data JPA](http://www.petrikainulainen.net/spring-data-jpa-tutorial/)


## Akses Database dengan Spring Data JPA ##

### Setup Project ###

* `pom.xml` : tambahkan parent project ke spring boot

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.2.5.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

* `pom.xml` : tambahkan dependensi Spring Data JPA

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

* `pom.xml` : tambahkan dependensi database (misal : MySQL)

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

* `pom.xml` tambahkan Spring Boot Maven Plugin

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

* `src/main/resources/application.properties` : Konfigurasi koneksi database

```
spring.datasource.url=jdbc:mysql://localhost:3307/pelatihan
spring.datasource.username=pelatihanuser
spring.datasource.password=pelatihanpasswd

spring.jpa.generate-ddl=true
```

* Entity class dengan annotation `@Entity`. Contoh:

```java
@Entity
public class Peserta {
    @Id
    private String id;
    
    @Column(nullable = false)
    private String nama;
    
    @Column(nullable = false, unique = true)
    private String email;
}
```

* Siapkan user dan password untuk koneksi database

```
grant all on pelatihan.* to pelatihanuser@localhost identified by ‘pelatihanpasswd’;
```

* Buat database

```
create database pelatihan;
```

* Jalankan projectnya

```
mvn clean package
```

### Test Kode Program Akses Database ###


* Siapkan sample data dalam file SQL

```sql
delete from peserta;

insert into peserta (id, nama, email, tanggal_lahir) 
values ('aa1', 'Peserta Test 001', 'peserta.test.001@gmail.com', '2011-01-01');

insert into peserta (id, nama, email, tanggal_lahir) 
values ('aa2', 'Peserta Test 002', 'peserta.test.002@gmail.com', '2011-01-02');

insert into peserta (id, nama, email, tanggal_lahir) 
values ('aa3', 'Peserta Test 003', 'peserta.test.003@gmail.com', '2011-01-03');
```

* Panggil file SQL dari dalam JUnit

```java
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AplikasiPelatihanApplication.class)
@Sql(
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = "/data/peserta.sql"
)
public class PesertaDaoTest {

}
```

* Lakukan pengetesan dalam method `@Test`

    * Contoh test insert

```java
@Test
public void testInsert() throws SQLException {
        Peserta p = new Peserta();
        p.setNama("Peserta 001");
        p.setEmail("peserta001@gmail.com");
        p.setTanggalLahir(new Date());
        
        pd.save(p);
        
        String sql = "select count(*) as jumlah "
                + "from peserta "
                + "where email = 'peserta001@gmail.com'";
        
        try (Connection c = ds.getConnection()) {
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assert.assertTrue(rs.next());
            
            Long jumlahRow = rs.getLong("jumlah");
            Assert.assertEquals(1L, jumlahRow.longValue());
        }
}
```

    * Contoh test select by id

```java
    @Test
    public void testCariById(){
        Peserta p = pd.findOne("aa1");
        Assert.assertNotNull(p);
        Assert.assertEquals("Peserta Test 001", p.getNama());
        Assert.assertEquals("peserta.test.001@gmail.com", p.getEmail());
        
        Peserta px = pd.findOne("xx");
        Assert.assertNull(px);
    }
```

    * Contoh test select count

```java
    @Test
    public void testHitung(){
        Long jumlah = pd.count();
        Assert.assertEquals(3L, jumlah.longValue());
    }
```

* Bersihkan sisa test insert dengan method `@After`

```java
    @After
    public void hapusData() throws Exception {
        String sql = "delete from peserta where email = 'peserta001@gmail.com'";
        try (Connection c = ds.getConnection()) {
            c.createStatement().executeUpdate(sql);
        }
    }
```