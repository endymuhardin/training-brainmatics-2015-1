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