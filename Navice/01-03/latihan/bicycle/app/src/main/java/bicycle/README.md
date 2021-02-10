
#OBJECT-ORIENTED PROGRAMMING

Apa itu OOP? OOP (Object Oriented Programming) atau dalam bahasa indonesianya pemrograman berbasis objek. Java merupakan salah satu bahasa pemrograman yang berorientasi objek. Yaitu, model pemrograman yang data dan fungsi nya dalam bahasa pemrograman ini dibungkus dalam sebuah objek. Setiap objek dapat menerima pesan,memproses data. Program-program yang telah ada merupakan gabungan dari komponen-komponen kecil (objek-objek). 

Dalam OOP, terdapat konsep atau prinsip diantaranya:

##ENKAPSULASI

Enkapsulasi atau pengkapsulan adalah konsep tentang pengikatan untuk mengatur struktur kelas dengan cara menyembunyikan alur kerja dari kelas tersebut
struktur kelas yang dimaksud adalah **propertyhi** dan **method**. Dengan enkapsulasi, kita bisa membuat pembatasan akses kepada property dan method. Sehingga, hanya property dan method tertentu saja yang bisa diakses dari luar kelas.

###ENKAPSULASI OBJEK: Public, Protected, Private

Untuk membatasi hak akses, OOP menyediakan 3 kata kunci, yakni Public,  Protected, dan Private. 
Hak akses : Public
Ketika method dan property dinyatakan sebagai public, seluruh kode program di luar class bisa mengaksesnya, termasuk class turunan.
Hak akses : Protected
Ketika method dan property dinyatakan sebagai protected, berarti property atau method tersebut tidak bisa diakses oleh luar kelas, bisa diakses kelas itu sendiri dan turunannya
Hak akses : Private
Ketika method dan property dinyatakan sebagai private, maka 
hanya kelas itu sendiri yang bisa mengakses.

####ABSTRACTION
Abstraction adalah proses untuk menyembunyikan detail implementasi dari user sehingga hanya sisi fungsionalitas saja yang ditampilkan, atau dengan kata lain user akan menerima informasi mengenai apa yang dapat dilakukan oleh suatu objek namun user tidak akan mengetahui bagaimana objek itu melakukannya.

#####INHERITANCE
Inheritance adalah konsep OOP dimana sebuah class dapat menurunkan property dan method yang dimilikinya kepada class lain. Konsep inheritance dipakai untuk memanfaatkan fitur code reuse, yakni menghindari terjadinya duplikasi kode program.

#######POLIMORFISME
Prinsip terakhir dalam OOP adalah polymorphism. Pada dasarnya polymorphism adalah kemampuan suatu pesan atau data untuk diproses lebih dari satu bentuk. 
Salah satu ciri utama dari OOP adalah adanya polymorphism. Tanpa hal ini, suatu pemrograman tidak bisa dikatakan sebagai OOP.
Polymorphism sendiri adalah konsep di mana suatu objek yang berbeda-beda dapat diakses melalui interface yang sama.
Sebagai contoh, kamu memiliki fungsi untuk menghitung luas suatu benda, sementara benda tersebut berbentuk segitiga, lingkaran, dan persegi.
