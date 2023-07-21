//import java.util.Scanner;

public class functions {
    /*public static int printhelloworld(){
        System.out.println("hello world");
        System.out.println("hello world");
        System.out.println("hello world");
        return 3;
    }
    public static int sum(int num1 , int num2) // formal parameters
    {
        int sum  = num1 + num2;
        return sum;
    }
    public static void swap(int x , int y) {
        int temp = x;
        x = y;
        y = temp ;
        System.out.println(x);
        System.out.println(y);
    } */
   // public static int multipication(int c,int d){
    // int product = c * d;
   //  return product;
   // }

   //factorial
  /*  public static int factorial(int n) {
    int f = 1;
    for(int i =1; i<=n; i++){
        f = f * i; 
        }return f;
    } */

    //binomailcoff
    public static int biomail(int n, int r){
        int f = 1;
        int fa = 1;
        int d = 1;
        int v = n - r;
        for(int i=1;i<=n;i++){
            f = f * i;} 
            for (int j = 1;j<=r;j++){
            fa = fa * j;}
            for(int k = 1;k<=v;k++ ){
            d = k * d;}
            int bf = f/(fa*d);
            return bf;
    }



    public static void main(String[] args) 
    { /* 
        Scanner sc = new Scanner(System.in);
        int a  = sc.nextInt();
        int b  = sc.nextInt();
        sc.close();
        int sum = sum(a, b);// actual parameters
        System.out.println("sum is "+ sum);


        //swap
        int x = 12;
        int y = 11;
        swap(x, y); */

        //multipication
      /*   System.out.println("enter the numbers for multiplication");
       
       Scanner mul = new Scanner(System.in);
       int ab = mul.nextInt();
       int bc = mul.nextInt();
       int prod = multipication(ab,bc);
        System.out.println(prod);  */

 // call by value a value is stored in a loop will be vanised when we come out of that loop

 //factorial 
  // int a = 7;
   // System.out.println(factorial(a));

//binomialcoff
int n = 5 ;
int r = 2;
System.out.println(biomail(n, r));




}



    







     

    





    
   




    }

    


