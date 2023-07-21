import java.util.*;
public class stacks {


    public static class StackAL{
        public static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isempty(){
            return list.size() == 0;
        }
        public static void push(int data){
          list.add(data);
        }

        public static int pop(){
            int val = list.get(list.size()-1);
            list.remove(list.size()-1);
            return val;
        }

        public static int peek(){
            return list.get(list.size()-1);
        }
    }

    public static class StackLL {
        public static LinkedList l1 = new LinkedList<>();
        public static boolean isempty(){
            return l1 == null;
        }

        //push
        public static void push(int data){
            l1.addFirst(data);
        }

        //pop
        public static void pop(){
      //      System.out.println(l1.get(l1.size()-1));
        l1.removeFirst();
        }

        //peek
        public static void peek(){
            System.out.println(l1.peekFirst());
        }

        }

        public static void pushtothebottom(Stack<Integer> s,int data){
            while(s.isEmpty()){
                s.push(data);
                return;
            }
            int top = s.pop();
            pushtothebottom(s, data);
            s.push(top);
        }

        public static void reverseAString(String str){
            Stack<Character> st = new Stack<>();
            for(int i=0;i<str.length();i++){
                st.push(str.charAt(i));
            }
            StringBuilder sb = new StringBuilder("");
            while(!st.isEmpty()){
                sb.append(st.pop());
               }

               System.out.println(sb);
        }

        public static void reversestack(Stack <Integer> s){
            if(s.isEmpty()){
                return;
            }
            int top = s.pop();
            reversestack(s);
            s.push(top);
        }



    public static void main(String[] args) {
       // StackAL s = new StackAL();
     //  StackLL s = new StackLL();
        Stack <Integer> s  = new Stack<>();
        s.push(3);
        s.push(2);
        s.push(1);
    //    pushtothebottom(s, 4);
   /*     while(!s.isEmpty()){
        System.out.println(s.peek());
        s.pop();
       } */
      // reverseAString("abc");
       reversestack(s);
       System.out.println(s);
       

        
    }
}
    

    





    

