public class DrawTriangle{

     public static void main(String []args){
        int size = 4;
        int row = 0;
        int col = 0;
        while (row <= 4){
            while (col <= row){
                System.out.print("*");
                col +=1;
            }
            System.out.println(" ");
            col = 0;
            row += 1;
        }
     }
}