# Build Tools #

Kegiatan build :

* Dependency Management
* Compile
* Package
* Run
* Test

Berbagai build tools di Java

* Ant + Ivy
* Maven
* Gradle

Kenapa menggunakan Maven

* Dependency Management
* Ada aturan baku tentang struktur folder
* Portability : project bisa dibuka di komputer lain dan IDE lain
* Mainstream, sudah disupport di berbagai cloud provider

## Menggunakan Maven ##

Secara umum, berikut adalah kegiatan sehari-hari dalam menggunakan Maven:

* membuat project baru (dengan cara membuat file `pom.xml` dan struktur folder standar)
* menambahkan dependency library (bila perlu)
* compile
* run

### Template file pom.xml ###

Berikut adalah `pom.xml` yang paling sederhana.

```xml
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.muhardin.belajar.java</groupId>
  <artifactId>belajar-maven</artifactId>
  <version>1.0.0-SNAPSHOT</version>
  <packaging>jar</packaging>
 
  <name>Aplikasi Belajar Maven</name>  
</project>
```

Jangan lupa ganti isi field berikut:

* groupId
* artifactId
* version
* name

### Menambahkan dependency ###

Untuk menggunakan library, kita tambahkan blok `dependency` sehingga `pom.xml` nampak seperti ini

```xml
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.muhardin.belajar.java</groupId>
  <artifactId>belajar-maven</artifactId>
  <version>1.0.0-SNAPSHOT</version>
  <packaging>jar</packaging>
 
  <name>Aplikasi Belajar Maven</name>
 
 <dependencies>
   
   <dependency>
    <groupId>joda-time</groupId>
    <artifactId>joda-time</artifactId>
    <version>2.8.2</version>
  </dependency>

 </dependencies>
  
</project>
```

### Compile Project ###

Perintah untuk compile adalah sebagai berikut

```
mvn package
```

Untuk menghapus hasil compile, berikut perintahnya

```
mvn clean
```

Biasanya, kita bersihkan dulu sebelum dicompile sehingga perintahnya seperti ini

```
mvn clean package
```

### Menjalankan Aplikasi ###

Misalnya kita punya class `Halo` yang ada dalam package `com.muhardin.endy.belajar.java`. Berikut perintah untuk menjalankannya dengan Maven

```
mvn clean package exec:java -Dexec.mainClass=com.muhardin.endy.belajar.java.Halo
```
