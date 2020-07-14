public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int sumn = 0;
        while (x < 10) {
            System.out.print(sumn + " ");
            x += 1;
            sumn += x;
        }
    }
}