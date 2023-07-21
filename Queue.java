public class Queue {

    static class Queues{
        static int size;
        static int arr[];
        static int rear;
        static int front;
        Queues(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front =-1;
        }
        public static boolean isempty(){
            return rear == -1&&front==-1;
        }

        public static boolean isfull(){
            return (rear+1)%size==front;
        }



        public static void add(int data){
            if(isfull()){
                System.out.println("Queue is full ");
                return;
            }
            if(front==-1){
                front =0;
            }
            rear = (rear+1)%size;
            arr[rear] =data;
        }

        public static int remove(){
            if(isempty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int val =arr[front];
            if(rear==front){
                rear = front =-1;
            }else{
            front = (front+1)%size;
            }
            return val;
        }

        public static int peek(){
            if(isempty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queues q = new Queues(5);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while(!q.isempty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
    
}
