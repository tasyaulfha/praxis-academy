public class MultiArrayInput {
    public static void main(String[] args) {
        //deklarasi
        int[][]cinema = new int[5][5];
        cinema[2][2]=1;
        for (int i = 0; i < 4; i++) { //empat baris
            cinema[i][3]=1;
        }
        for (int i = 0; i < 5; i++) { //baris terakhir
            cinema[i][4]=1;
            
        }
        for(int j = 0; j<cinema[0].length;j++){
            for (int i = 0; i < cinema.length; i++) {
                System.out.print(cinema[i][j]);
                
            }
            System.out.println();
        }

    }
    
}
