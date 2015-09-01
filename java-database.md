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
