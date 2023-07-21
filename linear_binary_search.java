//package DSA;

public class linear_binary_search {
    public static void linearsearch(int numbers[] ,int key){
        int start = numbers[0];
        for(int i = start;i<numbers.length;i++ ){
            if(i==key){
                System.out.print("key is at the index = "+numbers[i]);
            }
        }
    }

    public static void largest_smallest(int numbers[]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for(int i = 0;i<=numbers.length;i++){
            if(i>largest){
                largest = i;

                if(i<smallest){
                    smallest = i; }
                    
            }
        }System.out.println("largest value = "+largest);
        System.out.println("smallest value = "+smallest);
    }


    public static int binarysearch(int numbers[],int n){
        int start = 0,end = numbers.length-1;
        for(int i= start;i<=end;i++){
            int mid = (start + end) /2;
            if(n == mid){
              return mid; 
            }
            if(n<mid){
                end = mid -1;
            }
            else start = mid +1;

        }

    return -1;}
              

              public static void reverse_array(int numbers[]){
               
                int first = 0;
                int last = numbers.length-1;
               while(first < last){
               int temp = numbers[last];
               numbers[last] = numbers[first];
                numbers[first] = temp;
                first++;
                last--;
               }  for(int i =0;i<numbers.length;i++){
                System.out.print(numbers[i]+" ");
             }
        
              
              }






    public static void main(String[] args) {
        int numbers[] = {1,2,3,4,5,6,7,8,9,10};
       // int key = 11;
       // linearsearch(numbers, key);
      // largest_smallest(numbers);
      
     // System.out.println("key = "+binarysearch(numbers, key));
      reverse_array(numbers);
     
   

    }
    
}
