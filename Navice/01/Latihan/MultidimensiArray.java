public class MultidimensiArray {
    public static void main(String[] args) {
        
    int[][] cinema = {
     { 0, 0, 0, 0, 1 },
     { 0, 0, 0, 1, 1 },
    { 0, 0, 1, 1, 1 },
    { 0, 0, 0, 1, 1 },
    { 0, 0, 0, 0, 1 }
    };
    cinema[1][0]=1;

    System.out.println(cinema[2][2]);

}
}
