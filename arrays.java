//package DSA;

public class arrays {
    //pairs
    public static void pairs(int numbers[]){
        int tp = 0;
        for(int i =0;i<numbers.length;i++){
            int start = numbers[i];
            for(int j =i+1;j<numbers.length;j++){
                System.out.print("("+start+","+numbers[j]+")");
               tp++;
            }System.out.println();
          
        } System.out.println(tp);
    }

    //subarrays
    public static void subarrays(int numbers[]){
        for(int i =0;i<numbers.length;i++){
            for(int j =i+1;j<numbers.length;j++){
                for(int k = i; k<j;k++){
              System.out.print(numbers[k]+" ");
                }System.out.println();
            }System.out.println();
        }
    }

    public static void MAX_sum_of_subarrays(int numbers[]){   //method -1
        int sum = 0;
        int largest = Integer.MIN_VALUE;
       for(int i =0;i<=numbers.length;i++){
        for(int j = i;j<=numbers.length;j++){
             sum =0;
          for(int k =i;k<j;k++){
            sum += numbers[k];
            if(sum>largest){
                largest = sum;
            }
         
          }//if(sum == 0){
           // continue;
         // }
         System.out.println(sum);
        }

        }System.out.println("max sum = "+largest);

    }

    public static void sum_of_arrays_prefixmethod(int numbers[]){
         int max = Integer.MIN_VALUE;
         int sum = 0;
        int prefix[] = new int[numbers.length];
        prefix[0] = numbers[0];
        for(int i = 1;i<prefix.length;i++){
            prefix[i] = prefix[i-1] + numbers[i];
        }
        for(int i =0;i<numbers.length;i++){
            int start = i;
            for(int j =i;j<numbers.length;j++){
            int end = j;
                sum = i ==0 ?prefix[end]:prefix[end]-prefix[start-1];
                if(sum>max){
                    max = sum;
                }
              
            }

        }System.out.println("max sum = "+max);
    }
      
    
    public static void kadanes(int numbers[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for(int i=0;i<numbers.length;i++){
          cs = cs + numbers[i];
          if(cs<0){
            cs =0;
          }ms = Math.max(cs,ms);

        }System.out.println("max sum = "+ms);
    
    }
    //best time to sell or buy stocks

    public static void buyANDsellStocks(int prices[]){
        int buyingprices = Integer.MAX_VALUE;
        int max_profit = 0;
        for(int i = 0;i<prices.length;i++){
            if(buyingprices<prices[i]){
                int profit = prices[i] - buyingprices;
                max_profit = Math.max(max_profit,profit);
            }else {
                buyingprices = prices[i];
            } 
        }
        System.err.println("max profit = "+max_profit);
    }


    
    



public static void main(String[] args){


  //  int numbers[] ={2,4,6,8,10};
    int prices[] = {7,1,5,3,6,4};
   // pairs(numbers);
  //  MAX_sum_of_subarrays(numbers);
 // sum_of_arrays_prefixmethod(numbers);
  // kadanes(numbers);
   buyANDsellStocks(prices);
}
}
