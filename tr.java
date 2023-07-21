public class tr {
    public static void hollow_rectangle(int rows,int cols){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0||i==rows-1||j==0||j==cols-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void inverted_half_pyramid(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==n-i-1){
                    int temp = j;
                    while(temp<=n-1){
                    System.out.print("*");
                    temp++;
                    }
                }else{
                    System.out.print(" ");
                }
            }System.err.println();
        }
    }
    public static void inverted_pyrramid_with_numbers(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(j+1);
            }System.out.println();
        }
    }
    public static void floyds_triangle(int n){
        int k=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(k);
                k++;
            }System.out.println();
        }
    }
    public static void zero_one_triangle(int n){
        int x=1;
        int y=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(x);
                int temp = x;
                x = y;
                y = temp;
            }if(i%2==0){
                x=0;
                y=1;
            }else{
                x=1;
                y=0;
            }
            System.out.println();
        }
    }
    public static void butterfly(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n+n;j++){
                if(j<=i || j>=n+n-i-1){
                    System.err.print("*");
                }else{
                    System.out.print(" ");
                }
            }System.out.println();
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n+n;j++){
                if(j<=i || j>=n+n-i-1){
                    System.err.print("*");
                }else{
                    System.out.print(" ");
                }
            }System.out.println();
        }
    }
    public static void solid_rhombus(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==n-i-1){
                    int temp =0;
                    while(temp<n){
                        System.out.print("*");
                        temp++;
                    }
                    break;
                }else{
                System.out.print(" ");
                }
            }System.out.println();
        }
    }
    public static void hollow_rhombus(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==n-i-1){
                    int temp =0;
                    while(temp<n && (i==0 ||i==n-1||j==n-i-1)){
                        if(i==0 ||i==n-1||temp==0||temp==n-1){
                        System.out.print("*");
                        }else{
                            System.out.print(" ");
                        }
                        temp++;
                    }
                    break;
                }else{
                System.out.print(" ");
                }
            }System.out.println();
        }
    }
    public static void diamond(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>0;i--){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void number_pyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static void palindromeic_pattern(int n){
        int k = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            k = i;
            for(int j=1;j<=(2*i)-1;j++){
                if(k>=1){
                System.out.print(k);
                k--;
                }else{
                    k = 2;
                    System.out.print(k);
                    k++;
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
       
       //hollow_rectangle(5,5);
       //inverted_half_pyramid(4);
       //inverted_pyrramid_with_numbers(5);
       //floyds_triangle(4); 
       //zero_one_triangle(5);
       //butterfly(4);
       //solid_rhombus(5);
       //hollow_rhombus(4);
       //diamond(4);
       //number_pyramid(4);
       palindromeic_pattern(4);
    }
    
}
