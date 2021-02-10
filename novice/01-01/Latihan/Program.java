public class Program {
    public static void main(String[] args) {
        System.out.println("Perkalian sederhana menggunaakn loop bersarang");
            
    for (int j=1; j<= 10; j++){
        for(int i=1; i<=10; i++){
            System.out.printf("%d ", i*j );
        }
        System.out.println();
    }
}}
