//package DSA;

public class sorting {
    //bubble sort
    public static void bobblesort(int numbers[]){
        int n = numbers.length;
        for(int i = 0;i<n-1;i++){
            int swops = 0;
            for(int j =0;j<n-1-i;j++){
                if(numbers[j]>numbers[j+1]){
                    int temp = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = temp;
                } 
               swops++;
              if(swops ==0){
                i = n+1;
               }
            }
        }for(int i =0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }System.out.println();
    }


    public static void selectionsort(int numbers[]){
        int n = numbers.length;
        for(int i =0;i<n-2;i++){
            int curr = i;
            for(int j = i+1;j<n;j++){
                if(numbers[curr] > numbers[j]){
                    curr = j;
                }
            } int temp = numbers[curr];
            numbers[curr] = numbers[i];
            numbers[i] = temp;

        }for(int i =0;i<n;i++){
            System.out.print(numbers[i]+" ");
        } 
    }

    public static void insertion(int numbers[]){
        
        
    }

    public static void main(String[] args) {
        int numbers[] = {5,4,1,3,2};
       // bobblesort(numbers);
        selectionsort(numbers);
    }
    
}