import java.util.ArrayList;
import java.util.PriorityQueue;

public class Heaps {
    static class Heap{
        ArrayList <Integer> arr = new ArrayList<>();
        public void add(int data){ // o(logn)
            // add to last
            arr.add(data);

            // fix
            int x = arr.size()-1;
            int parent = (x-1)/2;
            while(arr.get(x)<arr.get(parent)){
                //swap
                int temp = arr.get(x);
                arr.set(x,arr.get(parent));
                arr.set(parent, temp);

                x  = parent;
                parent = (x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i){
            int left = 2*i +1;
            int right = 2*i+2;
            int min = i;
            if(left<arr.size() && arr.get(left)<arr.get(min)){
                min = left;
            }
            if(right<arr.size() && arr.get(right)<arr.get(min)){
                min = right;
            }
            if(min!=i){
                //swap 
                int temp = arr.get(min);
                arr.set(min,arr.get(i));
                arr.set(i, temp);

                heapify(min);
            }
        }

        public int remove(){
            if(isEmpty()){
                return -1;
            }
            int data = arr.get(arr.size()-1);
            //s -1 swap
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //s-2 remove last
            arr.remove(arr.size()-1);

            //s-3 heapify 
            heapify(0);

            return data;
        }

        public boolean isEmpty(){
            return arr.size()==0;
        }
    }
     public static void maxheapify(int arr[],int i,int size){
            int left = 2*i +1;
            int right = 2*i+2;
            int min = i;
            if(left<size && arr[left]>arr[min]){
                min = left;
            }
            if(right<size&& arr[right]>arr[min]){
                min = right;
            }
            if(min!=i){
                //swap 
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;

                maxheapify(arr,min,size);
            }
        }
    
    public static void heapsort(int arr[]){ // onlogn)
        int n = arr.length;
        //step -1 heapify
        for(int i=n/2;i>=0;i--){
            maxheapify(arr,i,n);
        }

        // s-2
        for(int i= n-1;i>0;i--){
            //swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxheapify(arr,0,i);
        }
    }
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distsq;
        int idx;
        public Point(int x,int y,int distsq,int idx){
            this.x = x;
            this.y = y;
            this.distsq= distsq;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point p2){
            return this.distsq - p2.distsq;
        }
    }
    public static int ConnectNodes(int ropes[]){
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }
        int cost  =0 ;
        while(pq.size()>1){
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += min1+ min2;
            pq.add(min1+min2);
        }
        return cost;
    }
    static class info implements Comparable<info>{
        int str;
        int idx;
        public info(int str,int idx){
            this.str = str;
            this.idx = idx;
        }
        @Override
        public int compareTo(info i2){
            
            if(i2.str==this.str){
                return i2.idx - this.idx;
            }else{
                return i2.str-this.str;
            }
            
        }
    }
    public static void WeakestSoilder(int matrix[][],int k){
        PriorityQueue<info> pq = new PriorityQueue<>();
        
        for(int i=0;i<matrix[0].length;i++){
            int strenght =0;
           for(int j =0;j<matrix[0].length;j++){
            strenght += matrix[i][j]==1?1:0;
           }
            pq.add(new info(strenght, i));
        }
       
        while(k>0){
            System.out.println("idx "+pq.remove().idx);
            k--;
        }
        
    }

    public static void main(String[] args) {
        Heap h= new Heap();
        h.add(2);
        h.add(3);
        h.add(1);
        h.add(4);
        // while(!h.isEmpty()){
        //     System.out.println(h.peek());
        //     h.remove();
        // }
        // int arr[] = {2,4,3,5,1};
        // heapsort(arr);
        // for(int i=0;i<arr.length;i++){
        //     System.out.println(arr[i]);
        // }
        // System.out.println();

        PriorityQueue <Point> pq = new PriorityQueue<>();
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int distsq = 0;
        for(int i =0;i<pts.length;i++){
            distsq = pts[i][0]*pts[i][0]+ pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distsq, i));
        }
        for(int i=0;i<2;i++){
            System.out.println("c"+pq.remove().idx);
        }

        
        int ropes[] = {2,3,3,4,6};
        System.out.println(ConnectNodes(ropes));
        int matrix[][] = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k =2;
        WeakestSoilder(matrix, k);
        
    }
}
