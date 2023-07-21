public class linkedlists {

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public  int size;

    public void addfirst(int data){ //o(1)
        //step-1 create a newnode
        Node newnode = new Node(data);
        size++;
        if(head == null){
            head = tail = newnode;
            return;
        }

        //step-2  newnode = nextnode head (linking)
        newnode.next = head;
        //step-3 making newnode  head
        head = newnode;
    }

    public void addlast(int data){
        //s-1
        Node newnode = new Node(data);
        size++;
        if(head == null){
          head=tail=newnode;
          return;  
        }
        //s-2
        tail.next = newnode;
        //s-3
        tail = newnode;
    }
    
    public void print(){
        Node temp =head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp =temp.next;
        }
        System.out.println("null");


    }
    public void addmiddle(int idx,int data){
        if(idx==0){
            addfirst(data);
            return;  
          }
        Node newnode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        newnode.next = temp.next;
        temp.next = newnode;

    }
    public int removefirst(){
        if(size ==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if(size ==1){
            int v = head.data;
            head = tail = null;
            size =0;
            return v;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removelast() {
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null ;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev ;
        size --;
        return val;
    }
    public boolean iterativeSearch(int key){
        int i=0; 
        int idx =0;
        Node temp = head;
        while(temp != null){
            if(temp.data == key){
                System.out.println("Key found at index "+idx);
                return true;
            }
            temp = temp.next;
            idx++;
        }
        System.out.println("key not found");
        return false;


    }
    public int helper(Node head,int key){
            if(head == null){
                return -1;
            }

            if(head.data == key){
                return 0;
            }
            int idx = helper(head.next, key);
            if(idx == -1){
                return -1;
            }

            return idx+1;
    }
    public int recursiveSearch(int key){
       return  helper(head, key);
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }  
        head = prev;

    }

    public void remove_Nth_termfromEnd(int n){
        int sz=0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if(n == sz){
            head = head.next;
            return;
        }
        Node prev = head;
        int iToRemove = sz-n;
        for(int i=1;i<iToRemove;i++){
            prev = prev.next;
        }
        prev.next = prev.next.next;

    }
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
    public  boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step-1 - find the mid
        Node midNode = findMid(head);
        //step-2 - reverse the second half
        Node curr = midNode;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        // step-3 - compare every index
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public boolean isLoop(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            if(slow == fast){
                return true; // loop exists
            }
            slow = slow.next;
            fast = fast.next;

        }
        return false; // loop not sections
    }

    public void removecycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        Boolean cycle = false;
        while(fast!=null && fast.next!=null){
            if(slow == fast){
                cycle = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if(cycle == false){
            return;
        }
        //find meeting point
        slow = head;
        Node prev = null;
        while(slow!=fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
    }

    private Node getmid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private Node merge(Node head1, Node head2){
        Node mergedll = new Node(-1);
        Node temp = mergedll;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1!= null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedll.next;
    }

    public  Node mergesort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node mid = getmid(head);
        Node righthead = mid.next;
        mid.next = null;
        Node newleft = mergesort(head);
        Node newright = mergesort(righthead);


        return merge(newleft,newright);

    }
    public Node getmid2(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public void zigzag(){
        //step-1 get mid
        Node mid = getmid2(head);
        //step-2 reverse
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        Node left = head;
        Node right = prev;
        Node nextl,nextr;

        //step-3
        while(left!=null && right!=null){
            nextl = left.next;
            left.next = right;
            nextr = right.next;
            right.next = nextl;

            left = nextl;
            right = nextr;
    }
}


    

    

    public static void main(String args[]){
        linkedlists ll = new linkedlists();
    /* Direct call
        ll.head = new Node(1);
        ll.head.next = new Node(2);  */

        //indirect call
    //    ll.print();
   //     ll.addfirst(2);
   
    //    ll.addfirst(1);
        
    //    ll.addlast(2);
       
    //    ll.addlast(1);
     //   ll.addmiddle(0, 0);
   //    ll.print();
     //   System.out.println(ll.size);
    //    ll.removefirst();
    //    ll.print();
      //  ll.removelast();
    //    ll.print();
    //    System.out.print(ll.recursiveSearch(0));
    //    ll.reverse();
   //     ll.print();
   //     ll.remove_Nth_termfromEnd(3);
    //    ll.print();
    // System.out.println( ll.isPalindrome());
  /*       head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;
        System.out.println(ll.isLoop());  */
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        ll.addlast(6);
        ll.print();
        ll.zigzag();
        ll.print();
    }
}
