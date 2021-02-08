import java.util.Scanner;

public class ExponenCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        System.out.println("Kalkulator Pangkat");
        System.out.println("===================");
        System.out.println("Masukkan basis :");
        int a= Integer.parseInt(scanner.nextLine());
        System.out.println("Masukkan pangkat: ");
        int n = Integer.parseInt(scanner.nextLine());

        int result  =a;
        for (int i = 0; i< (n-1); i++){
            result= result*a;

        }
        System.out.println("Result : "+ result);
        System.out.println("Terima Kasih");


    }
    
}
