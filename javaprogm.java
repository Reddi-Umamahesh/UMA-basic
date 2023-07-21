import java.util.Scanner;

public class javaprogm {
    public static void main(String[] args) {
       // System.out.print("hello world\n");
       //System.out.print("hello world");
       // int a = 12;
       // int b = 3;
      //int sum = a + b;
       // System.out.println(sum );
       Scanner input = new Scanner(System.in);
       int a = input.nextInt();
       int b = input.nextInt();
       input.close();
       int sum = a + b;
       System.out.println(sum);
    }

    
}
