import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueues {
    static class student implements Comparable<student>{
        int rank;
        String name;
        public student(int rank,String name){
            this.rank = rank;
            this.name = name;
        }
        @Override
        public int compareTo(student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue <Integer> pq = new PriorityQueue<>();  // Comparator.reverseOrder()  for reverse order
        PriorityQueue<student> s = new PriorityQueue<>();
        
        // pq.add(4);
        // pq.add(2);
        // pq.add(6);
        // pq.add(1);
        s.add(new student(3, "uma"));
        s.add(new student(5, "abhi"));
        s.add(new student(7, "ani"));
        s.add(new student(4, "bhavahara"));
        while(!s.isEmpty()){
            System.out.println(s.peek().name +" -> "+s.peek().rank);
            s.remove();
        }
    }
}
