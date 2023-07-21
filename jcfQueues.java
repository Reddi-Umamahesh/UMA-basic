import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class jcfQueues {

    public static class Stacks{
        static Queue <Integer> q1 = new LinkedList<>();
        static Queue <Integer> q2 = new LinkedList<>();

       public static boolean isEmpty(){
        return q1.isEmpty() && q2.isEmpty();
       }


       public static void push(int data){
        if(q1.isEmpty()){
            q1.add(data);
        }else{
            q2.add(data);
        }
       }

       public static int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        int top =-1;
        if(q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                if(q1.isEmpty()){
                    break;
                }
                q2.add(top);
            }
            return top;
        }else{
            while(!q2.isEmpty()){
                top = q2.remove();
                if(q2.isEmpty()){
                    break;
                }
                q1.add(top);
            }
            return top;
        }

       }
       public static int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        int top =-1;
        if(q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                q2.add(top);
            }
            return top;
        }else{
            while(!q2.isEmpty()){
                top = q2.remove();
                q1.add(top);
            }
            return top;
        }

       }
    }

    public static void Interleave(Queue<Integer> q){
        Queue <Integer>q1 = new LinkedList<>();
        int n  = q.size()/2;
        for(int i=0;i<n;i++){
            int temp = q.remove();
            q1.add(temp);
        }
        while(!q1.isEmpty()){
            q.add(q1.remove());
            q.add(q.remove());
        }
       while(!q.isEmpty()){
        System.out.print(q.remove()+" ");
    } 
        System.out.println();
    }

    public static void Queuereversal(Queue<Integer> q){
        Stack <Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        } 
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        } 
        System.out.println();
    }

    public static void firstnonrep(String str){
        int freq[] = new int[26];
        Queue <Character> q = new LinkedList<>();
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print("-1 ");
                
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }

    static class stack{
       static  Deque <Integer> deque = new LinkedList<>();
        static void push(int data){
            deque.addLast(data);
        }
        static int  pop(){
            return deque.removeLast();
        }
        static int peek(){
            return deque.getLast();
        }
    }

    public static class queue{
        Deque <Integer> deque = new LinkedList<>();
        public void add(int data){
            deque.addLast(data);
        }
        public int remove(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getFirst();
        }
    }
    public static void main(String[] args) {
         Queue <Integer> q= new LinkedList<>();
         for(int i=1;i<=10;i++){
            q.add(i);
         }

        // System.out.println(q.remove());
        
        // }
      //  Stacks s = new Stacks();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println(s.pop());
        // firstnonrep("aabccxb");
        
        // Interleave(q);
      //  Queuereversal(q);
        Deque <Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        // System.out.println(deque);
        // System.out.println(deque.removeLast());
        // System.out.println(deque);
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        // System.out.println(s.peek());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        queue q1 = new queue();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        System.out.println(q1.remove());
        System.out.println(q1.remove());
        System.out.println(q1.remove());
}
}

