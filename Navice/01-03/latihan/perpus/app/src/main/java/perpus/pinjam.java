package perpus;

    public class pinjam{
        public Buku bukuTerpinjam;
        public mahasiswa peminjam;

       public void meminjam (mahasiswa m, Buku b){
           peminjam = m;
           bukuTerpinjam = b;
        }
        void lihatPeminjaman(){
            System.out.println("Data peminjaman :");
            System.out.println("NIM :"+peminjam.getNim());
            System.out.println("Nama :" +peminjam.getName());
            System.out.println("Judul Buku :" + bukuTerpinjam.getJudul());
            System.out.println("Pengarang :" +bukuTerpinjam.getPengarang());
            System.out.println("Tahun terbit :" + bukuTerpinjam.getTahun());
        }
    }