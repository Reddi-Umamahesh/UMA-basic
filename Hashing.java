import java.util.HashMap;
import java.util.Set;

public class Hashing {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Nepal", 50);
        // System.out.println(hm);
        // System.out.println(hm.get("India"));
        // containsKey, remove(), size, isEmpty
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String k : keys) {
            System.out.println(k+hm.get(k));
        }
        
    }
}
