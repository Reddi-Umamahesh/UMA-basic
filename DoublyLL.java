public class DoublyLL {
    public class Node{
        Node next;
        Node prev;
        int data;
        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    public static Node tail;
    public static Node head;
    public int size;
    
    public void addfirst(int data){
        Node newnode = new Node(data);
        size++;
        if(head==null){
            head = tail = newnode;
            return;
        }

        newnode.next= head;
        head.prev = newnode;
        head = newnode;

    }

    public int removefirst(){
        if(size==0){
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
            
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

   
    public void addlast(int data){
        Node newnode = new Node(data);
        size++;
        if(head ==null){
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        newnode.prev = tail;
        tail = newnode;
    }

    public int removelast(){
        if(size==0){
            return Integer.MIN_VALUE;
        }
        if(size==1){
           int val= head.data;
            head = tail = null;
            size=0;
            return val;
        }

        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reversell(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addfirst(3);
        dll.addfirst(2);
        dll.addfirst(1);
        
    //    dll.removefirst();
   //     dll.print();
        dll.addlast(4);
    //    dll.print();
    //    dll.removelast();
        dll.print();
        dll.reversell();
        dll.print();
        
    }
    
}

