import java.util.Scanner;

public class sumandproduct {
    public static void main(String[] args) {
        // sum & product of numbers taken input from user
        Scanner in = new Scanner(System.in);
        int  x= in.nextInt();
        int  y= in.nextInt();
        in.close();
        int u = x + y;
        int v = x * y;
        System.out.println(u);
        System.out.println(v);

        
    }
    
}
