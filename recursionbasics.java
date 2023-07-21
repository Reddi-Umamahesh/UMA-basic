//package DSA;

public class recursionbasics {
    public static void main(String[] args){
     //   int a =6;
     //   int b[] = {1,5,3,4,5}; 
     //   String c = "apnnacollege";
      //  printdec_n_asc(a);
      //  System.out.println(fac(a));
     //  System.out.print(sumofnnumbers(5));
     //  System.out.print(nthfib(7));
     //  System.out.println(arraysortedornot(b, 0));
   //  System.out.print(firstoccurance(b,0,5));
   //  System.out.print(lastoccurance(b,0,5));
   //  System.out.print(optpower(2,4));
     System.out.print(tiling(3));
  //   removedup(c, 0, new StringBuilder(""), new boolean[26]);
   //  System.out.println(pairing(2));
   //  printbinary(3, 0, "");

    }



    public static void printdec_n_asc(int n){ 
        if(n==1){
          System.out.println(n);
        return;
        }
        System.out.println(n);
        printdec_n_asc(n-1);
    }

    public static int fac(int n){
        if(n==0){
            return 1;
        }
        return n*fac(n-1);
    }

    public static int sumofnnumbers(int n){
        if(n==0){
            return 0;
        }
        int sum = n+sumofnnumbers(n-1);
        return sum;
    }

    public static int nthfib(int n){
        if(n==0){
     return 0;
        }
        if(n==1){
            return 1;
        }

        int nm1 = nthfib(n-1);
        int nm2 = nthfib(n-2);
        return nm1+nm2;


    }

    public static boolean arraysortedornot(int a[],int i){
        if(i==a.length-1){
            return true;
        }
        if(a[i]>a[i+1]){
            return false;
        }
     return  arraysortedornot(a, i+1);

    }

    public static int firstoccurance(int a[],int i,int key){
   
        if(a[i]==key){
            return i;
        }
        if(i==a.length-1){
            return -1;
        }     

    return  firstoccurance(a,i+1,key);

    }

    public static int lastoccurance(int a[],int i,int key){
         if(i==a.length){
            return -1;
         }
         int isfound = lastoccurance(a, i+1, key);
         if(isfound==-1 && a[i]==key){
        return i;
         }

       return isfound;

    }

    public static int power(int n,int m){
     if(m==0){
        return 1;
     }
     return n*power(n,m-1); 
    }

    public static int optpower(int n,int m){
        if( m==0){
         return 1;
        }
         int halfpow = optpower(n,m/2);
         int halfpowsq = halfpow*halfpow;
          if(m%2==1){
            return n*halfpowsq;
          }
          return halfpowsq;
    }

    public static int tiling(int n){  //floor size 2*n

        if(n==0 || n==1){
            return 1;
        }
        //vertical choice
        int nm1 = tiling(n-1);
        //horizontal chocie
        int nm2 = tiling(n-2);

        return nm1+nm2;
    
    }

    public static void removedup(String a,int index,StringBuilder newstr,boolean map[]){
     
        if(index==a.length()){
            System.out.print(newstr);
            return;
        }
        char curr = a.charAt(index);
        if(map[curr-'a']==true){
            removedup(a, index+1, newstr, map);
        }
        else{
            map[curr-'a']=true;
            removedup(a, index+1, newstr.append(curr), map);
        }

    }

    public static int pairing(int n){
        if(n==0||n==1){
            return n;
        }
        
        int single = pairing(n-1);
        int totalpair = (n-1)*single;
        return totalpair+single;
    }

    public static void printbinary(int n,int lastplace,String str){
        //base case 
        if(n==0){
            System.out.println(str);
            return ;
        }
      //work
        printbinary(n-1, 0, str+'0');

        if(lastplace ==0){
            printbinary(n-1, 1, str+'1');
        }

    }
   
      
   

    }


    
    

