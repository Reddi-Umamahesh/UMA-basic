import java.util.HashMap;
import java.util.Set;

public class Hashingproblems {
    public static void majorityelements(int arr[]){  //o(n)
        int n = arr.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            // if(!hm.containsKey(arr[i])){
            //     hm.put(arr[i], 1);
            // }else{
            //     hm.put(arr[i], hm.get(arr[i])+1);
            // }
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1); // it aslo does the same
        }
          
        for (Integer k : hm.keySet() ) {
            if(hm.get(k)>n/3){
                System.out.println(k);
            }
        }
    }

    public static boolean validAnagram(String str1,String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        HashMap <Character,Integer> map1 = new HashMap<>();
        HashMap <Character,Integer> map2 = new HashMap<>();
        for(int i =0;i<str1.length();i++){
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i),0)+1);
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i),0)+1);
        }
        return map1.equals(map2);

    }
    public static void main(String[] args) {
        int arr[] = {1,3,2,5,1,3,1,5,1};
        int arr2[] = {1,2};
        //majorityelements(arr);
        String str1 = "tulip";
        String str2 = "lipid";
        System.out.println(validAnagram(str1, str2));
    }
}
