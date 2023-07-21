import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
public class queue2 {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Queues{
       static Node head = null;
       static Node tail = null;


       static boolean isempty(){
        return head==null && tail==null;
       }

       static void add(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = tail = newnode;
        }
        tail.next = newnode;
        tail = newnode;
       }

       static int remove(){
        int val =head.data;
        if(head == tail){
            tail = head = null;
        }else{
            head = head.next;
        }
        return val;
       }

       static int peek(){
        if(isempty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return head.data;
       }
    }

    static class Queuess{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        static boolean isEmpty(){
            return s1.isEmpty();
        }

        static void add(int data){
            s1.push(data);
        }

        static int remove(){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            if(s2.isEmpty()){
                System.out.println("Queue is empty");
            }else{
                int val  = s2.pop();
                return val;
            }
            return -1;
        }
       
    }

    public static class Stacks{
        static Queue <Integer> q1 = new LinkedList<>(null);
        static Queue <Integer> q2 = new LinkedList<>(null);

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

    public static void main(String[] args) {
      //  Queue q = new Queue();

        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }
        // Queuess qq = new Queuess();
        // qq.add(1);
        // qq.add(2);
        // qq.add(3);
        // System.out.println(qq.remove());
        // System.out.println(qq.remove());
        // System.out.println(qq.remove());
        // System.out.println(qq.remove());
        Stacks s = new Stacks();
        s.push(1);
        System.out.println(s.peek());
        


        
    }


}
