//import java.util.*;


public class tss {
    public static int multipication(int c,int d){
     int product = c * d;
     return product;
    } 
  public static void selection(int arr[]){
    for(int i =0;i<arr.length-1;i++){
      int minnumb = i;
      for(int j = i+1;j<arr.length;j++){
        if(arr[minnumb]>arr[j]){
          minnumb = j;
        }
      }int temp = arr[minnumb];
      arr[minnumb] = arr[i];
      arr[i] = temp;
    }for(int k =0;k<arr.length;k++){
       System.out.print(arr[k]+" ");
    }
  }
  public static void bobble_sort(int numb[]){
    for(int i =0;i<numb.length-1;i++){
      for(int j =0;j<numb.length-1-i;j++){
        if(numb[j]>numb[j+1]){
          int temp = numb[j+1];
          numb[j+1] = numb[j];
          numb[j] = temp;
        }
      }}for(int k =0;k<numb.length;k++){
        System.out.print(numb[k]+" "); }
      }

  public static void insertion_sort(int num[]){
   for(int i =0;i<num.length;i++){
       int curr = num[i];
       int prev = i-1;
       while(prev >=0 && num[prev]>curr){
       num[prev +1] = num[prev] ;
       prev--;
       }  num[prev+1]=curr;
   }for(int i=0;i<num.length;i++){
    System.out.print(num[i]+" ");
   }  }


   public static void countingarray(int arr[]){
    int largest = Integer.MIN_VALUE;
    for(int i =0; i<arr.length;i++){
     largest = Math.max(largest, arr[i]);
      }
   int count[] = new int[largest+1];
   for(int i =0;i<arr.length;i++){
    count[arr[i]]++;
   }
   int j =0;
for(int i=0;i<count.length;i++){
  while(count[i]>0){
    arr[j] = i;
    j++;
    count[i]--;
  }
}
for(int i =0;i<arr.length;i++){
//System.out.print(arr[i]+" ");
}


   }
  
    public static void main(String[] args) {
  //    int arrr[]={5,4,1,2,3};
      //  System.out.println("enter the numbers for multiplication");
     //    Scanner mul = new Scanner(System.in);
     //   int ab = mul.nextInt();
     //   int bc = mul.nextInt();
     //   int prod = multipication(ab,bc);
    //  System.out.println(prod);
    // prod = multipication(12,13);
    //   System.out.println(prod);
    //   mul.close();
    //selection(arrr);
   //bobble_sort(arrr);
   // insertion_sort(arrr);
  // countingarray(arrr);
   //int a = 13;
// System.out.println("%15s",a);
    }
    
}
