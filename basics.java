import java.util.Scanner;

public class basics {
    public static void main(String[] args) {
        // (1) sum of two numbers 
        int a = 12;
        int b = 3;
        int sum = a + b;
        System.out.println(sum);

        //(2) commenters 
        /* these are used to write any thing in code 
        which we dont want to compile 
         */

         //(3) input 
         Scanner sc = new Scanner(System.in);
         String input = sc.nextLine();
         sc.close();
         System.out.println(input);


        
                
    }
    
}
