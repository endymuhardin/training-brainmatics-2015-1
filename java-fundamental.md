# Java Fundamental #

* Source Code Java
* Compile
* Run
* Classpath
* Package

## Source Code Java ##

* File text biasa, bisa dibuka dan diedit dengan text editor apapun
* Contoh file source code

```java
public class Halo {
    public static void main(String[] aa){
        System.out.println("Halo Dunia");
    }
}

class Pelatihan {

}
```

* Satu file bisa berisi banyak class, tapi cuma boleh ada satu public class
* Nama public class harus sama dengan nama file, misalnya `public class Halo` harus disimpan dalam file bernama `Halo.java`

## Compile ##

* Compile mengubah source code menjadi binary
* Perintah compile : `javac`
* Contoh

```
javac *.java
```

* Compile akan menghasilkan file `*.class`, satu file per class walaupun dalam source file digabung jadi satu.

* Hasil compile bisa diarahkan ke folder tertentu, misalnya folder `bin`

```
javac *.java -d bin/
```

## Menjalankan Aplikasi Java ##

* Class yang bisa dijalankan adalah class yang memiliki method `public static void main(String xx)`
* Aplikasi Java dijalankan dengan menggunakan perintah `java` dengan argumen nama class yang memiliki method main.
* Contoh

```
java Halo
```

* Pada saat perintah `java` dijalankan, Java Runtime Environment (JRE) akan mencari class di lokasi tertentu, yang disebut dengan istilah `CLASSPATH`

* Lokasi `CLASSPATH` default:

    * folder tempat kita berada
    * class `rt.jar` dalam lokasi instalasi JRE
    * semua file jar dalam `[JRE]/lib/ext`

## Setting CLASSPATH ##

1. Menggunakan opsi `-cp` pada pemanggilan `java`. Contoh : `java -cp Halo`
2. Membuat environment variable dengan nama `CLASSPATH`. Ada 3 cara :

    1. Langsung diset sebelum memanggil. Contoh : `CLASSPATH=bin java Halo`
    2. Menggunakan perintah `set` (Windows) atau `export` (Linux/Mac). Contoh : `set CLASSPATH=bin`
    3. Setting di Environment Variable untuk user maupun keseluruhan system (**tidak dianjurkan**). 