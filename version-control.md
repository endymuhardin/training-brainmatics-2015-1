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

* Perintah 

```
git init <nama folder>
```

* Contoh

```
git init training-brainmatics-2015-1
```

### Menyimpan file ke dalam repository ###

* Perintah : 

    ```
    git add .
    git commit -m “keterangan perubahan”
    ```

### Membuat SSH Keypair ###

* Perintah

```
ssh-keygen
```

* Catatan:

	* Untuk Windows, gunakan Git Bash
	* Nama file jangan diganti, tetap ikuti default (`id_rsa`)

* Hasilnya ada di:

	* Linux : `/home/namauser/.ssh`
	* Windows : `c:\Users\namauser\.ssh`
	* Mac : `/Users/namauser/.ssh`

* Daftarkan di Github
	
	* Buka file `id_rsa.pub` dengan text editor
	* Select All, copy isinya, paste di github
	* Github : Icon User > Settings > SSH Keys

![Github Public Key Settings](https://github.com/endymuhardin/training-brainmatics-2015-1/raw/master/img/add-ssh-key-github.png)

![Github Add New Key](https://github.com/endymuhardin/training-brainmatics-2015-1/raw/master/img/copy-paste-public-key.png)


### Mendaftarkan Remote Repository ###

* Perintah

```
git remote add <nama alias> <url remote repo>
```

* Contoh

```
git remote add github git@github.com:endymuhardin/training-brainmatics-2015-1.git
```

### Upload Repository Local ke Remote ###

* Perintah

```
git push <nama remote> <nama branch>
```


* Contoh

```
git push github master
```

### Mengambil Repository Orang Lain ###

* Perintah

```
git clone <url repo> [folder tujuan]
```

* Contoh

```
git clone git@github.com:endymuhardin/training-brainmatics-2015-1.git
```

* Catatan

	* Jangan dilakukan dalam folder repository yang lain !!!

### Update Repository dari Remote ###

* Perintah

```
git pull
```

* Catatan

	* Folder local harus dalam kondisi bersih (tidak ada perubahan atau semua perubahan sudah dicommit/distash)
	* Membersihkan folder local : 
		* hapus file/folder yang belum dicommit : bila perubahan tidak penting
		* commit : bila pekerjaan/perubahan sudah selesai
		* stash : bila perubahan penting, tapi belum selesai

### Menghapus perubahan di local ###

* Perintah

```
git reset --hard
git clean -d -f
```

* Catatan : Perintah di atas akan menghapus semua perubahan yang belum dicommit, dan menghapus semua file yang dibuat dan belum dicommit

### Stash ###

* Penjelasan : meminggirkan pekerjaan/perubahan kita ke lokasi temporary sehingga kondisi folder menjadi clean dan bisa melakukan pull

* Cara kerja:

	1. `git stash` : meminggirkan pekerjaan yang belum selesai, sehingga folder menjadi bersih
	2. `git pull` : mengambil perubahan terbaru dari server
	3. `git stash pop` : mengembalikan pekerjaan yang belum selesai tadi ke folder