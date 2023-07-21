public class patterns2 {

    public static void hollow_rectangle(int totrows, int totcol){
        for (int i = 1;i<=totrows;i++){
            for(int j =1;j<=totcol;j++){
                if(i==1 || i==totrows || j==1 || j==totcol){System.out.print("*");}
                else System.out.print(" ");
            }System.out.println();
        }
    }
    public static void inverted_half_pyramid(int n){
        for(int i = 1;i<=n;i++){
            for(int j =1;j<=n-i;j++){
                System.out.print(" ");
            }for(int j =1;j<=i;j++){
                System.out.print("*");
            }System.out.println();
        }
    }

    public static void inverted_pyrramid_with_numbers(int n){
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= n-i+1;j++){
                System.out.print(j);
            }System.out.println();
        }
    }

    public static void floyds_triangle(int number){
        int counter = 1;
        for(int i = 1;i<=number;i++){
            for(int j = 1;j<=i;j++){
                
                System.out.print(counter);
                counter++;
            }System.out.println();
        }
    }

    public static void zero_one_triangle(int n){
        for(int i =1;i<=n;i++){
            for(int j =1;j<=i;j++){
                if((i+j)%2==0){System.out.print("1");}
                else System.out.print("0");
            }System.out.println();

        }
    }
    public static void butterfly(int n){
        //first half
        for(int i = 1;i<=n;i++){
            //stars
            for(int j =1;j<=i;j++){
                System.out.print("*");
            }
            //spaces
            for(int j =1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            //stars
            for(int j =1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //2nd half
        for(int i =n;i>=1;i--){
            //stars
            for(int j =1;j<=i;j++){
                System.out.print("*");
            }
            //spaces
            for(int j =1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            //stars
            for(int j =1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void solid_rhombus(int n){
        for(int i  =1;i<=n;i++){
            //space
            for(int j =1;j<=n-i;j++){
                System.out.print(" ");
            }
            //star
            for(int j =1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();  
        }
    }

    public static void hollow_rhombus(int n){
        for(int i = 1;i<=n;i++){
            //spaces
            for(int j = 1;j<=n-i;j++){
                System.out.print(" ");
            }
            //stars
            for(int j =1;j<=n;j++){
                if(i ==1 || j ==1 || i==n || j==n){
                    System.out.print("*"); }  
                    else System.out.print(" ");
            }System.out.println();
        }
    }

    public static void diamond(int n){
       //1st half 
        for(int i =1;i<=n;i++){
            
            //spaces
            for(int j = 1;j <= n-i;j++){
                System.out.print(" ");
            }
            //stars
            for(int j =1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
         
                System.out.println();
        }
        //2nd half
        for(int i = n;i>=1;i--){
                     //spaces
       for(int j = 1;j <= n-i;j++){
        System.out.print(" ");
       }
      //stars
      for(int j =1;j<=(2*i)-1;j++){
      System.out.print("*");
     }System.out.println();
   } 
     

        }
    


    public static void main(String[] args) {
     
    // hollow_rectangle(5, 4);
    // inverted_half_pyramid(7);
    //  inverted_pyrramid_with_numbers(5);
    //floyds_triangle(3);
    // zero_one_triangle(4);
    //butterfly(7);
    // solid_rhombus(5);
     //  hollow_rhombus(5);
     diamond(8);




    }
    
}
