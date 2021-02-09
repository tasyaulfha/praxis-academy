import java.util.Scanner;

public class Kalkulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Selamat datang di Kalkulator");
        System.out.println("Masukkan angka pertama");
        double a=Double.parseDouble(scanner.nextLine());
        System.out.println("Masukkan angka kedua");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println("Pilih operasi : (1-4)");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");

        int option = Integer.parseInt(scanner.nextLine());
        double result = 0;
        switch(option){
            case 1:
                result = a+b;
            break;
            case 2:
                result = a-b;
            break;
            case 3:
                result = a*b;
            break;
            case 4:
                result = a/b;
            break;
        }
        if ((option>0)&&(option<5)){
            System.out.println("result :"+ result);
        }
        else
        {
            System.out.println("Opsi salah");
        }
        System.out.println("Terima Kasih!");
        }


    
}
