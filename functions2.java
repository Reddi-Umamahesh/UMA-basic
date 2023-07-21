public class functions2 {
    //function overloading using paramters
  /*  public static int sum(int a, int b){
        return a+b; }
     public static int sum(int a , int b, int c){
        return a + b + c;
    } 

    //function overloading using data types 
    public static float sum(float a, float b){
        return a+b;
    } */
    //wheather the number is prime or not
    public static boolean check(int n){
        for(int i =2; i<=Math.sqrt(n-1); i++){
            if(n % i == 0){
                return false;
            }
        }return true;
    } 

    //binary >>>>> decimal
/*   public static void bin_int(int binN){
        int mynum = binN;
     int pow = 0;
     int dec = 0;
     while(binN>0){
    int ld = binN % 10;
    dec = dec + (ld * (int)Math.pow(2, pow));
    pow++;
    binN = binN /10;
     } System.out.println("decimal of  "+ mynum+ " = "+dec );   
    }  */

    // decimal >>>>> binary
    public static void dec_bin(int dec){
        int mynumb = dec;
        int bin = 0;
        int pow = 0;
        while(dec>0){
        int ld = dec % 2;
        bin = bin + (ld * (int)Math.pow(10,pow)); 
        pow++;
        dec = dec/2;
        } System.out.println("binary form of "+mynumb+"="+bin);
    }
    
    public static void main(String[] args) {
      //  System.out.println(sum(2,3));
        //System.out.println(sum(2.3f,3.7f));
   //     System.out.println(check(7));
 //  bin_int(101);
    dec_bin(5);




       
    }

    
}
