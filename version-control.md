# Version Control #

* Aplikasi untuk menyimpan file/folder
* Bisa diakses banyak orang sekaligus

* Menyimpan riwayat (history) perubahan
  * File apa yang berubah
  * Apa isi perubahannya (lama vs baru)
  * Kapan terjadi perubahan
  * Siapa yang mengubah
  * Keterangan kenapa berubah

* Conflict Management
  * menolak kalau versi lokal tidak up to date
  * merge (penggabungan) bila lokasi perubahan berbeda
  * menimbulkan conflict marker bila lokasi perubahan sama

* Rollback ke versi sebelumnya
* Tag versi-versi yang penting
  * rilis

* Branch : parallel development
  * maintenance branch : bug fix untuk versi terdahulu
  * feature branch : develop feature tanpa mengganggu orang lain


## Aplikasi Version Control System ##

### Jenis VCS ###

Ada dua jenis aplikasi VCS:

* Centralized : database cuma ada satu di server pusat

	* untuk melihat perubahan, harus connect ke server
	* until submit perubahan, harus connect ke server
	* ijin akses bisa diatur per folder

* Distributed : database ada di masing-masing orang

	* melihat history bisa dilakukan di local
	* submit perubahan di local dull, baru sync dungeon server
	* tidak bisa ijin akses per folder, karena seluruh database ada di local

### Berbagai Aplikasi VCS ###

* Centralized

	* CVS
	* [Subversion](https://subversion.apache.org/)
	* Microsoft Source Safe

* Distributed

	* [Git](http://git-scm.com/)
	* [Mercurial](https://mercurial.selenic.com/)
	* [Bazaar](https://bazaar.canonical.com/)


### Provider VCS ###

* [Github](https://github.com/)
* [Bitbucket](https://bitbucket.org/)
* Google Code (almarhum)
* [Sourceforge](http://sourceforge.net/)

### Aplikasi Server Git ###

* [Gitolite](http://gitolite.com/gitolite/index.html)
* [Gitblit](http://www.gitblit.com/)
* [Gitlab](https://about.gitlab.com/)

### Aplikasi Client Git ###

* [Command line](http://git-scm.com/downloads)
* [TortoiseGit](https://code.google.com/p/tortoisegit/)
* Plugin IDE (Netbeans, Eclipse)

## Pemakaian Git ##

### Konfigurasi Awal ###

* Set username : `git config --global user.name “Endy Muhardin”`
* Set email : `git config --global user.email “endy.muhardin@gmail.com”`

### Membuat Database / Repository ###

* Perintah : `git init <nama folder>`

### Menyimpan file ke dalam repository ###

* Perintah : 

    ```
    git add .
    git commit -m “keterangan perubahan”
    ```