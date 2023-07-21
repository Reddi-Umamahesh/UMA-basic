import java.util.ArrayList;
import java.util.LinkedList;

public class Hashmapcode {
    static class Hashmap<K,V>{ // genrices -> data type of constructor can be any thing
        private class Node{
            K key;
            V value;
            public Node(K key,V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n; //n
        private int N;
        private LinkedList<Node> buckets[]; //N
        @SuppressWarnings("unchecked")
        public Hashmap(){
            this.N =4;
            this.buckets = new LinkedList[4];
            for(int i=0;i<4;i++){
                buckets[i] = new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc)%N; // always returns value less than 4 idx value (0-3)
        }
        private int  SearchInLL(K key,int bi){
            LinkedList <Node> ll = buckets[bi];
            int dataidx = 0;
            for(int i=0;i<ll.size();i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return dataidx;
                }
                dataidx++;
            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node> oldbuckets[] = buckets;
            buckets = new LinkedList[N*2];
            N = N*2;
            for(int i=0;i<buckets.length;i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i=0;i<oldbuckets.length;i++){
                LinkedList<Node> ll = oldbuckets[i];
                for(int j =0;j<ll.size();j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key,V value){
            int bucketidx = hashFunction(key);
            int dataidx = SearchInLL(key,bucketidx);
            if(dataidx!= -1){
                Node node = buckets[bucketidx].get(dataidx);
                node.value = value;
            }else{
                buckets[bucketidx].add(new Node(key, value));
                n++;
            }
            double lamda = (double)n/N;
            if(lamda>2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bucketidx = hashFunction(key);
            int dataidx = SearchInLL(key,bucketidx);
            if(dataidx!= -1){
                return true;
            }else{
                return false;
            }

        }

        public V get(K key){
            int bucketidx = hashFunction(key);
            int dataidx = SearchInLL(key,bucketidx);
            if(dataidx!= -1){
                Node node = buckets[bucketidx].get(dataidx);
                return node.value;
            }else{
                return null;
            }
        }

        public V remove(K key){
            int bucketidx = hashFunction(key);
            int dataidx = SearchInLL(key,bucketidx);
            if(dataidx!= -1){
                Node node = buckets[bucketidx].remove(dataidx);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keyset(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }
        

    }
    public static void main(String[] args) {
        Hashmap<String,Integer> hm = new Hashmap<>();
        hm.put("India", 100);
        hm.put("China",150);
        hm.put("US",50);
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.keyset());
        

    }
}
