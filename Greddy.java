import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Greddy {
    public static void ActivitySelection(int start[],int end[]){
        int activites[][] = new int[start.length][3];
        
        for(int i=0;i<start.length;i++){
           activites[i][0] = i;
           activites[i][1] = start[i];
           activites[i][2] = end[i]; 
        }
        Arrays.sort(activites,Comparator.comparingDouble(o -> o[2]));
        for(int i=0;i<6;i++){
            for(int j=0;j<3;j++){
                System.out.print(activites[i][j]+" ");
            }System.out.println();
        }
        //end time based sort
        int maxact = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        
        //secting first act
        maxact =1;
        ans.add(activites[0][0]);
        int lastend = activites[0][2];
        for(int i=1;i<end.length;i++){
            if(lastend<=activites[i][1]){
                //activity selection
                maxact++;
                ans.add(activites[i][0]);
                lastend = activites[i][2];
            }
        }

        System.out.println("Max activites "+maxact);
        System.out.println(ans);
    }
    public static void Knapsack(int val[],int weight[],int W){
        double ratio[][] = new double[val.length][3];
        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i];
            ratio[i][2] = weight[i];
        }

        Arrays.sort(ratio,Comparator.comparingDouble(o->o[2]));
        int capacity = W;
        int finalval =0;
        for(int i=0;i<val.length;i++){
            if(capacity>=ratio[i][2]){
                finalval+= ratio[i][1];
                capacity-= ratio[i][2];
            }else{
                finalval+= ((int)(ratio[i][1]/ratio[i][2])*capacity);
                capacity =0;
                break;
            }
        }
        System.out.println(finalval);
              

    }

    public static void Minsumofabsdiff(int arr1[],int arr2[]){
        
        Arrays.sort(arr2);
        Arrays.sort(arr1);
        int minval=0;
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]>arr2[i]){
                minval+= (arr1[i]-arr2[i]);
            }else{
                minval+= (arr2[i]-arr1[i]);
            }
        }
        System.out.println(minval);

        
    }

    public static int indiancoins(int v){
        int coins =0;
        int money[] = {2000,500,200,100,50,20,10,5,2,1};
        for(int i=0;i<money.length;i++){
            if(money[i]<=v){
                while(money[i]<=v){
                    coins++;
                    v -= money[i];
                }
            }
            
        }
        return coins;
    }

    public static void maxchainlength(int pairs[][]){
        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
        
    }

    //chocola problem
    public static void mincost(int m,int n,Integer costVer[],Integer costHor[]){
        Arrays.sort(costVer, Collections.reverseOrder());
         Arrays.sort(costHor, Collections.reverseOrder());
         int v =0; int h= 0;
         int vp = 1;int hp =1;
         int cost =0;
         while(h<costHor.length && v<costVer.length){
            //horizontalcut
            if(costHor[h]>=costVer[v]){
                cost += (costHor[h]* vp);
                hp++;
                h++;
            }else{
                //vertical cut
                cost += (costVer[v]*hp);
                vp++;
                v++;
            }
         }

         while(h<costHor.length){
            cost += (costHor[h]* vp);
            hp++;
            h++;
         }
         while( v<costVer.length){
            cost += (costVer[v]*hp);
            vp++;
            v++;
         }

         System.out.println(cost);

    }

    public static void main(String[] args) {
        // int start[] = {5,8,5,1,3,0};
        // int end[] = {7,9,9,2,4,6};
      //  ActivitySelection(start, end);
    //   int val[] = {60,100,120};
    //   int weight[]={10,20,30};
   //   Knapsack(val, weight, 50);
      int arr1[] = {4,1,8,7};
      int arr2[]= {2,3,6,5};
    //  Minsumofabsdiff(arr1, arr2);
 //   System.out.println(indiancoins(590));


    Integer costVer[] = {2,1,3,1,4};
    Integer costHor[] = {4,1,2};
    mincost(0, 0, costVer, costHor);
        
        
        
    }

   
}
