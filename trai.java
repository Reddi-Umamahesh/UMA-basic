import java.util.*;
public class trai {

    
    public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int t=in.nextInt();
            int a,b,n;
           
            for(int i=0;i<t;i++){
                 b = in.nextInt();
                 a = in.nextInt();
                 n = in.nextInt();
     if(a>=0 && a<=50 && b>=0 && b<=50&&n>=1&&n<=15){
               for(int j =0;j<=t;j++){
                    Double temp = a +(b* (Math.pow(2,j)));
                System.out.print(temp+" ");
               } }
            } 
            in.close();
    }
    
}
