<h1>GRADLE</h1>

<h4>Apa yang akan dibuat?</h4>
Generate java aplikasi dengan mengikuti konvesi gradle

<h4>Apa yang dibutuhkan?</h4>
- Text editor IDE
- JDK versi 8 atau lebih (https://adoptopenjdk.net/)
- Gradle distribution (https://gradle.org/install/)

<h4>Membuat folder projek</h4>
Gradle membawa task bawaan, yang disebut **init** , yang menginisialisasi projek Gradle baru dalam folder kosong. 
Lankah pertama untuk membuat folder dan projek baru dan ganti direktori
$mkdir demo
$cd demo

<h4>Run task init</h4>
Dari dalam direktori projek baru, run **init** task menggunakan command di terminal: **gradle init**. Ketika diminta, pilih **2:application**  tipe projek dan **3:java* sebagai implementasi bahasa. Selanjutnya, pilih DSL **1: Groovy** atau **2:Kotlin**

$ gradle init

Select type of project to generate:
  1: basic
  2: application
  3: library
  4: Gradle plugin
Enter selection (default: basic) [1..4] 2

Select implementation language:
  1: C++
  2: Groovy
  3: Java
  4: Kotlin
  5: Scala
  6: Swift
Enter selection (default: Java) [1..6] 3

Select build script DSL:
  1: Groovy
  2: Kotlin
Enter selection (default: Groovy) [1..2] 1

Select test framework:
  1: JUnit 4
  2: TestNG
  3: Spock
  4: JUnit Jupiter
Enter selection (default: JUnit 4) [1..4]

Project name (default: demo):
Source package (default: demo):


BUILD SUCCESSFUL
2 actionable tasks: 2 executed

<h4>Review file projek</h4>

<h6>settings.gradle</h6>
rootProject.name ='demo'
include('app')

rootProject.name : memberi nama ke build, yang menggantikan perilaku default penamaan build setelah direktorinya berada. Sebaiknya setel nama tetap karna folder dapat berubah jika projek dibagikan.
include("app") : mendefinisikan bahwa build terdiri dari satu subproyek yang disebut aplikasi yang yang berisi kode aktual dan logika build.
<h6>app/build.gradle</h6>
plugins {
    id 'application' 1
}

repositories {
    jcenter() 2
}

dependencies {
    testImplementation 'junit:junit:4.13' 3

    implementation 'com.google.guava:guava:29.0-jre' 4
}

application {
    mainClass = 'demo.App' 5
}
1. terapkan plugin aplikasi untuk menambahkan dukungan untuk membangun aplikasi CLI di Java
2. Gunakan JCenter untuk menyelesaikan dependensi
3. Gunakan kerangka kerja pengujian JUnit.
Ketergantungan ini digunakan oleh aplikasi.
4. Tentukan kelas utama untuk aplikasi tersebut.

<h4>Run aplikasi</h4>
Anda dapat menjalankan aplikasi langsung dari baris perintah. **run** memberi tahu Gradle untuk mengeksekusi metode utama di kelas yang ditetapkan ke properti mainClass.

<h4>Bundle aplikasi</h4>

Plugin aplikasi juga memaketkan aplikasi, dengan semua dependensinya, untuk Anda. Arsip juga akan berisi skrip untuk memulai aplikasi dengan satu perintah.

$ ./gradlew build

<h4>Publish Build scan</h4>
$ ./gradlew build --scan

<h4>Kesimpulan</h4>

Itu dia! Anda sekarang telah berhasil mengonfigurasi dan membuat proyek aplikasi Java dengan Gradle. Anda telah mempelajari cara:

Inisialisasi proyek yang menghasilkan aplikasi Java

Jalankan build dan lihat laporan pengujian

Jalankan aplikasi Java menggunakan tugas jalankan dari plugin aplikasi

Gabungkan aplikasi dalam arsip