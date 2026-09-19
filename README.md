# UTS PBO - Sistem Manajemen Data Menu Restoran

## Identitas Mahasiswa

**Nama:** Muhammad Arzad  
**NIM:** 2509116014     
**Mata Kuliah:** Pemrograman Berorientasi Objek  
**Tugas:** Ujian Tengah Semester (UTS)  
**Program Studi:** Sistem Informasi

## Studi Kasus

### Sistem Manajemen Data Menu Restoran

**Sistem Manajemen Data Menu Restoran** merupakan program berbasis *Command Line Interface* (CLI) yang dikembangkan menggunakan bahasa pemrograman Java. Program ini digunakan untuk mengelola data menu pada sebuah restoran secara sederhana, terstruktur, dan mudah digunakan.

Studi kasus ini dipilih karena pengelolaan data menu merupakan salah satu bagian penting dalam operasional sebuah restoran. Setiap restoran memiliki berbagai menu yang perlu dikelola dengan baik, baik dari segi nama menu, kategori, maupun harga. Oleh karena itu, diperlukan sebuah sistem yang dapat membantu proses pengelolaan data menu secara lebih terstruktur.

Dalam program ini, restoran memiliki beberapa komponen data utama, yaitu **kategori** dan **menu**. Data kategori digunakan untuk mengelompokkan menu yang tersedia, sedangkan data menu menyimpan informasi mengenai menu yang dimiliki restoran. Setiap menu memiliki informasi berupa ID menu, nama menu, kategori, dan harga.

Program menyediakan beberapa fitur utama untuk mengelola data restoran, yaitu:

- **Tambah Kategori** untuk menambahkan data kategori baru.
- **Tampilkan Kategori** untuk menampilkan seluruh kategori yang tersedia.
- **Tambah Menu** untuk menambahkan data menu baru.
- **Tampilkan Menu** untuk menampilkan seluruh data menu yang tersimpan.
- **Update Menu** untuk mengubah informasi dari menu yang telah tersedia.
- **Hapus Menu** untuk menghapus data menu berdasarkan ID menu.

Selain pengelolaan menu secara umum, program juga memiliki pembagian jenis menu menjadi **Menu Makanan** dan **Menu Minuman**. Pembagian tersebut diterapkan melalui hubungan *inheritance* antara class `Menu` sebagai *superclass* dengan class `MenuMakanan` dan `MenuMinuman` sebagai *subclass*.

Program juga menyediakan **data awal (*dummy data*)** sehingga ketika aplikasi pertama kali dijalankan, pengguna dapat langsung melihat data yang telah tersedia tanpa harus memasukkan seluruh data dari awal.

### Tujuan Program

Pembuatan program ini bertujuan untuk menerapkan konsep **Pemrograman Berorientasi Objek (PBO)** dalam sebuah studi kasus pengelolaan data menu restoran.

Konsep PBO yang diterapkan dalam program meliputi:

- *Class* dan *Object*
- *Encapsulation*
- *Inheritance*
- *Polymorphism*
- *Constructor*
- *Access Modifier*
- Penggunaan `ArrayList` untuk menyimpan kumpulan data

Dengan penerapan konsep tersebut, program dapat mengorganisasi data dan fungsi ke dalam beberapa *class* yang memiliki tanggung jawab masing-masing. Hal ini membuat struktur program menjadi lebih teratur, mudah dipahami, serta lebih mudah dikembangkan apabila terdapat kebutuhan untuk menambahkan fitur atau jenis menu baru.

## Hierarki Class

Program **Sistem Manajemen Data Menu Restoran** memiliki beberapa class yang saling berhubungan untuk mengelola data restoran, kategori, dan menu.

Class `Menu` berperan sebagai *superclass* yang menjadi dasar dari jenis-jenis menu pada program. Class ini menyimpan data umum yang dimiliki oleh setiap menu, yaitu `idMenu`, `namaMenu`, `kategori`, dan `harga`.

Class `MenuMakanan` merupakan *subclass* dari `Menu`. Class ini mewarisi atribut dan method yang dimiliki oleh `Menu` serta digunakan untuk merepresentasikan menu yang berjenis makanan.

Class `MenuMinuman` juga merupakan *subclass* dari `Menu`. Class ini mewarisi atribut dan method dari `Menu` dan digunakan untuk merepresentasikan menu yang berjenis minuman.

Class `Kategori` digunakan untuk merepresentasikan kategori menu yang tersedia pada restoran. Class ini memiliki data berupa `idKategori`, `namaKategori`, dan `deskripsi`.

Class `Restoran` berperan sebagai class yang mengelola data restoran. Class ini memiliki informasi restoran serta menyimpan kumpulan objek `Menu` dan `Kategori` menggunakan `ArrayList`.

Secara hierarki, hubungan class pada program dapat dijelaskan sebagai berikut:

- `Menu` merupakan *superclass*.
- `MenuMakanan` merupakan *subclass* yang mewarisi `Menu`.
- `MenuMinuman` merupakan *subclass* yang mewarisi `Menu`.
- `Kategori` merupakan class yang digunakan untuk mengelola informasi kategori menu.
- `Restoran` merupakan class yang mengelola kumpulan data `Menu` dan `Kategori`.

Dengan hierarki tersebut, class `MenuMakanan` dan `MenuMinuman` dapat menggunakan kembali atribut dan method yang telah tersedia pada class `Menu`. Penerapan ini membuat struktur program lebih terorganisir dan mengurangi kebutuhan untuk menuliskan kembali bagian kode yang memiliki fungsi yang sama.

## Penerapan Inheritance

Konsep *inheritance* pada program **Sistem Manajemen Data Menu Restoran** diterapkan dengan menggunakan class `Menu` sebagai *superclass* serta class `MenuMakanan` dan `MenuMinuman` sebagai *subclass*.

### Superclass `Menu`

Class `Menu` digunakan sebagai class induk yang menyimpan atribut dan method yang bersifat umum untuk seluruh jenis menu. Beberapa informasi yang terdapat pada class `Menu` yaitu:

- `idMenu`
- `namaMenu`
- `kategori`
- `harga`

Atribut dan method yang bersifat umum tersebut kemudian dapat diwariskan kepada class turunannya.

### Subclass `MenuMakanan`

Inheritance diterapkan pada class `MenuMakanan` melalui penggunaan keyword `extends`, yaitu:

public class MenuMakanan extends Menu

<img width="481" height="55" alt="Screenshot 2026-09-19 235647" src="https://github.com/user-attachments/assets/57f5de77-7bee-4c58-a896-901b3a0a2896" />

## Screenshot Running Program

Berikut merupakan dokumentasi tampilan program **Sistem Manajemen Data Menu Restoran** saat dijalankan melalui *Command Line Interface* (CLI).

### 1. Tampilan Menu Utama

Screenshot pertama menunjukkan tampilan awal program ketika dijalankan. Pada bagian ini, menu utama menampilkan pilihan fitur yang dapat digunakan untuk mengelola data restoran.

<img width="362" height="192" alt="image" src="https://github.com/user-attachments/assets/f393a2c4-ed9a-42bd-9595-e8b7021364c7" />

### 2. Tampilan Data Kategori dan Menu

Screenshot selanjutnya menunjukkan data yang tersedia di dalam program setelah pengguna memilih fitur untuk menampilkan kategori dan menu.

<img width="394" height="383" alt="image" src="https://github.com/user-attachments/assets/271a5f84-0c73-48a8-ba69-6449f5bf1037" />

<img width="405" height="472" alt="image" src="https://github.com/user-attachments/assets/3a0a5181-ba75-4072-9bef-42e7de2111f8" />

### 3. Proses Pengelolaan Data Menu

Screenshot selanjutnya menunjukkan proses pengelolaan data menu melalui fitur yang tersedia pada program.

<img width="359" height="553" alt="image" src="https://github.com/user-attachments/assets/1d47a7af-95af-442d-8714-3307e3ee2fbd" />

<img width="370" height="574" alt="image" src="https://github.com/user-attachments/assets/b5479482-c358-4789-b698-3b53d909c6b2" />

### 4. Proses Update dan Hapus Data Menu

Screenshot terakhir menunjukkan fitur **Update Menu** dan **Hapus Menu** yang digunakan untuk mengubah dan menghapus data menu.

<img width="351" height="322" alt="image" src="https://github.com/user-attachments/assets/24178264-ade0-41c2-a5a6-adc60426a33b" />

<img width="406" height="578" alt="image" src="https://github.com/user-attachments/assets/0769e807-76ed-4342-9361-33d58a641462" />

<img width="357" height="553" alt="image" src="https://github.com/user-attachments/assets/8403f42b-475c-47f0-8191-8757fc1af827" />


