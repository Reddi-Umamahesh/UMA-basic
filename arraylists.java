import java.util.ArrayList;
import java.util.List;
public class arraylists {

    public static void container_with_most_water(ArrayList <Integer> height){
        int max=0;
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int height_level = Math.min(height.get(i),height.get(j));
                int water_level = height_level*(j-i);
                max = Math.max(max, water_level);
            }   
        }
        System.out.println(max);
    }

    public static void two_ptr(ArrayList<Integer> height){
        int max = 0,lp=0,rp=height.size()-1;
        while(lp<rp){
            //calulate waterlevel
            int level = Math.min(height.get(lp),height.get(rp));
            int currwater = level * (rp-lp);
            max = Math.max(max, currwater);

            //update
            if(lp<rp){
                lp++;
            }else{
                rp--;
            }
        }
        System.out.println(max);
    }

    
        public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=0;i<=5;i++){
            list.add(i);
        }
        list.add(0,0);
        list.remove(1);
    //    System.out.println(list);
   //     System.out.println(list.size());
        ArrayList <Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        container_with_most_water(height);
        two_ptr(height);

    }


}
