# Aplikasi Web Java #

## Aplikasi Web Tradisional ##

* Servlet
* Filter
* Listener

Referensi :

* [Tutorial dasar-dasar aplikasi web java](http://software.endy.muhardin.com/java/dasar-dasar-aplikasi-web-java/)
* [Membuat Aplikasi Web CRUD dengan Java](https://www.youtube.com/watch?v=CVeaOkHrZ70)


## Framework Web Java ##

Arsitektur Aplikasi Web

* Server Side : tampilan dibuat/digenerate di server. Server akan mengeluarkan HTML + CSS -> tampilan + data.
* Client Side : server hanya mengeluarkan data (XML, JSON, dsb). Untuk menampilkan (tabel, grafik, peta, dsb) diurus di sisi client (menggunakan JavaScript framework)

Jenis-jenis framework web :

* Component Based : berpikir dalam komponen + event. Mirip seperti aplikasi desktop.
* Request/Action Based : berpikir HTTP request/response. Mirip seperti aplikasi web pada umumnya (PHP, Perl, HTML, dsb)

Contoh framework Action Based :

* Spring MVC (bagian dari Spring Framework)
* Struts 1 (tidak dikembangkan lagi)
* Webwork -> Struts 2 (tidak ada hubungan dengan Struts 1)

Contoh framework Component Based :

* Java Server Faces (JSF)

    * Primefaces
    * RichFaces

* ZK
* GWT
* Vaadin


Rekomendasi : Client Side Architecture

* Fleksibel untuk aplikasi client : support tampilan web (browser) dan mobile (baik native maupun web)
* Perkembangan JavaScript sangat pesat, lebih cepat daripada teknologi server side
* Fleksibel di sisi programming language. Di sisi server bisa dibuat dengan bahasa apa saja, yang penting struktur data yang dikeluarkan konsisten.

JavaScript Framework :

* ExtJS
* Dojo Toolkit
* EmberJS
* AngularJS

