import java.util.LinkedList;
import java.util.*;
import java.util.Queue;
public class BinarySearchtrees {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root,int val){
        if(root == null){
            root =new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean serach(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data== key){
            return true;
        }
        if(root.data>key){
           return serach(root.left, key);
        }else{
           return serach(root.right, key);
        }
    }

    public static void levelorder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }
    public static Node findinordersuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root,int n){
        if(root.data<n){
            root.right = delete(root.right, n);
        }else if(root.data>n){
            root.left = delete(root.left, n);
        } else{
            //case -1 no child
            if(root.left == null && root.right==null){
                return null;
            }

            //case-2  1-child
            if(root.left == null){
                return  root.right;
            }else if(root.right == null){
                return root.left;
            }

            //case 3 2-childern
            Node IS = findinordersuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;


    }

    public static void printinrange(Node root,int k1,int k2){
        if(root == null){
            return;
        }
        //case -1 
        if(root.data >=k1 &&  root.data<=k2){
            printinrange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printinrange(root.right, k1, k2);
        }
        if(root.data<k1 && root.data<k2){
            printinrange(root.right, k1, k2);
        }
        if(root.data>k1 && root.data>k2){
            printinrange(root.left, k1, k2);
        }
    }
    public static void printlist(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("null");
    }
    public static void printRoot2leaf(Node root,ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printlist(path);
        }
        printRoot2leaf(root.left,path);
        printRoot2leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isvalid(Node root,Node min,Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data<=min.data){
            return false;
        }else if(max != null && root.data >= max.data){
            return false;
        }

        return isvalid(root.left, min, root) && isvalid(root.right, root, max);
    }

    public static Node mirror(Node root){
        if(root == null){
            return null;
        }
        Node lefts = mirror(root.left);
        Node rights = mirror(root.right);
        root.left = rights;
        root.right = lefts;
        return root;
    }
    public static Node SortedArrayto_binarytree(int si,int ei,int arr[]){
        if(si>ei){
            return null;
        }
        int mid = (si+ei)/2;
        Node newNode = new Node(arr[mid]);
        newNode.left = SortedArrayto_binarytree(si,mid-1, arr);
        newNode.right = SortedArrayto_binarytree(mid+1, ei, arr);
         
        
        return newNode;

    }
    static ArrayList <Integer> list = new ArrayList<>();
    public static void getinorder(Node root,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        getinorder(root.left,list);
        list.add(root.data);
        getinorder(root.right,list);
    }
    public static Node createBST(int si,int ei,ArrayList<Integer> list){
        if(si>ei){
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(list.get(mid));
        root.left = createBST(si, mid-1, list);
        root.right = createBST(mid+1, ei, list);
        return root;
    }
    public static void preorder(Node root){
        if(root == null){
            System.out.print("-1 ");
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static class info{
        boolean isBST;
        int size;
        int min;
        int max;
        public  info(boolean isBST,int size,int min,int max){
            this.isBST = isBST;
            this.size =size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxsize=0;
    public static info largestBST(Node root){
        if(root == null){
            return new info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        info leftinfo = largestBST(root.left);
        info rightinfo = largestBST(root.right);
        int size = leftinfo.size + rightinfo.size+1;
        int min = Math.min(root.data,(Math.min(leftinfo.min, rightinfo.min)));
        int max = Math.max(root.data,(Math.max(leftinfo.max, rightinfo.max)));
        if(root.data<=leftinfo.max || root.data >= rightinfo.min){
            return new info(false, size, min, max);
        }
        if(leftinfo.isBST && rightinfo.isBST){
            maxsize = Math.max(maxsize,size);
            return new info(true, size, min, max);
        }
        return new info(false, size, min, max);
    }

    public static ArrayList<Integer> list2 = new ArrayList<>();

    public static Node merge2BST(Node root1,Node root2){
        getinorder(root1, list2);
        getinorder(root2, list2);
        Collections.sort(list2);
        Node root = createBST(0,list2.size()-1, list2);
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        int nodes[] = {5,3,1,4,6,10,11,14};

        for(int i=0;i<nodes.length;i++){
            insert(root,nodes[i]);
        }
        // if(serach(root, 4)){
        //     System.out.println("found");
        // }else{
        //     System.out.println("not found");
        // }
        // inorder(root);
        // root = delete(root, 5);
        // System.out.println();
        // inorder(root);
        //printinrange(root, 5, 12);
        //printRoot2leaf(root, new ArrayList<>());
        // if(isvalid(root,null,null)){
        //     System.out.println("valid");
        // }else{
        //     System.out.println("Not valid");
        // }
        // inorder(root);
        // mirror(root);
        // System.out.println();
        // inorder(root);  
        int arr[] = {3,5,6,8,10,11,12};
        //inorder(SortedArrayto_binarytree(0, arr.length-1, arr));
        Node root2 = new Node(50);
        root2.left = new Node(30);
        root2.right = new Node(60);
        root2.left.left = new Node(5);
        root2.left.right = new Node(20);
        root2.right.right = new Node(70);
        root2.right.left = new Node(45);
        root2.right.right.right = new Node(80);
        root2.right.right.left = new Node(65);
        // getinorder(root2);
        // inorder(createBST(0, list.size()-1, list));
        // System.out.println();
        // preorder(createBST(0, list.size()-1, list));
        // preorder(root2);
        // largestBST(root2);
        // System.out.println(maxsize);
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node subroot2 = new Node(9);
        subroot2.left = new Node(3);
        subroot2.right = new Node(12);

        preorder(merge2BST(root1, subroot2));


        
    }
}
