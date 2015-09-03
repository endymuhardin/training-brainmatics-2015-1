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

## Spring MVC ##

* `@Controller` : dipasang di class. Supaya class dideteksi sebagai controller, dan diinisialisasi oleh Spring. Sehingga kalau ada property yang `@Autowired`, akan diisi oleh Spring. Misalnya `private @Autowired PesertaDao pd;`

* `@RequestMapping` : dipasang di method. Untuk melakukan mapping antara URL dengan method yang akan menanganinya.

* `@RequestParam` : dipasang di method argument. Untuk mengambil data/variabel dari query parameter. Misalnya `/peserta?nama=endy`

* `@PathVariable` : dipasang di method argument. Untuk mengambil data/variabel dari URL. Misalnya untuk URL `/sesi/JF-001/2015`, dengan `@RequestMapping(“/sesi/{kode}/{tahun}”)`, bisa diambil dengan `@PathVariable(“kode”) String kode` dan `@PathVariable(“tahun”) String tahun`

* `@ResponseStatus` : menyatakan HTTP Status Code yang dihasilkan oleh method. Misalnya 200, 201, 404, dsb. Daftar status code yang bisa dikembalikan bisa dilihat [di sini](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes).

* `@ResponseBody` : menyatakan bahwa apapun hasil yang dikembalikan oleh method, langsung dikirim ke requester. Hasil ini akan dikonversi sesuai format yang diminta requester melalui header `Accept`. Misalnya bila requester mengirim header `Accept: application/json`, maka data akan dikirim dalam format JSON. Untuk pilihan tipe data yang bisa dikirim, selengkapnya bisa dibaca [di sini](https://www.iana.org/assignments/media-types/media-types.xhtml).

* `@RestController` : mirip dengan `@Controller`, dengan tambahan: semua method otomatis diberikan `@ResponseBody`

### Menghasilkan Dynamic Page ###


Template Engine : untuk memasang variabel dalam halaman HTML. Bisa juga untuk menghasilkan file text, xml, xls, pdf, dsb yang ada templatenya dan ingin digabungkan dengan data.

Berbagai template engine di Java

* JSP : Java Server Pages. Perhatian !!! JSP berbeda dengan JSF.
* Velocity
* Freemarker
* Thymeleaf
* Jasper Report (Apache POI, iText)


