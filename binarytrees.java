import java.lang.invoke.LambdaConversionException;
import java.util.*;
import java.util.Queue;
public class binarytrees{

    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Binarytree{
        static int idx= -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);


            return newNode;
        }

        public static void preorder(Node root){ // TC --> o(n) linear
        if(root == null){
            System.out.print("0 ");
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
        
    }

    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
        
        
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

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) +1;
    }

    public static int count(Node root){
        if(root == null){
            return 0;
        }
        int lc = count(root.left);
        int rc = count(root.right);
        return lc+rc+1;
    }

    public static int sumofNodes(Node root){
        if(root == null){
            return 0;
        }
        int ls = sumofNodes(root.left);
        int rs = sumofNodes(root.right);
        return ls+rs+root.data;
    }

    public static int Diameter(Node root){ //o(n^2) because diam and ht are calculated sperately
        if(root== null){
            return 0;
        }
        int ldiam = Diameter(root.left);
        int rdiam = Diameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        int selfdiam = lh+ rh+1;
        return Math.max(Math.max(rdiam, selfdiam),ldiam); 
    }

    static class info{
        int ht;
        int diam;
        public info(int ht,int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }
     public static info optDiameter(Node root){ // o(n) because diam and ht are calculated at once
        if(root == null){
            return new info(0,0);
        }
        info leftinfo = optDiameter(root.left);
        info rightinfo = optDiameter(root.right);
        int diam = Math.max(leftinfo.ht+rightinfo.ht+1,Math.max(leftinfo.diam,rightinfo.diam));
        int ht = Math.max(leftinfo.ht,rightinfo.ht)+1;
        return new info(ht, diam);
     }

     public static boolean isidentical(Node root, Node subroot){
        if(root== null && subroot==null){
            return true;
        }else if(root == null || subroot== null || root.data!=subroot.data){
            return false;
        }

        if(!isidentical(root.left, subroot.left)){
            return false;
        }
        if(!isidentical(root.right, subroot.right)){
            return false;
        }
        return true;
     }

     public static boolean issubtree(Node root , Node subroot){
        if(root == null){
            return false;
        }
        if(root.data == subroot.data){
            if(isidentical(root,subroot)){
                return true;
            }
        }

        return issubtree(root.left, subroot) || issubtree(root.right, subroot);
     }

     static class Infor{
        int hd;
        Node node;
        public Infor(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
     }

     public static void topview(Node root){
        Queue <Infor> q = new LinkedList<>();
        HashMap<Integer,Node> map  = new HashMap<>();
        int min =0,max=0;
        q.add(new Infor(root,0));
        q.add(null);


        while(!q.isEmpty()){
            Infor curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
            if(!map.containsKey(curr.hd)){
                map.put(curr.hd, curr.node);
            }

            if(curr.node.left != null){
                q.add(new Infor( curr.node.left,curr.hd-1));
                min = Math.min(min,curr.hd-1);
            }

            if(curr.node.right != null){
                q.add(new Infor(curr.node.right,curr.hd+1));
                max = Math.max(max,curr.hd+1);
            } }
        }

        for(int i = min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
    }

    public static void klevel(Node root,int level,int k){
        if(root== null){
            return;
        }
        if(level==k){
            System.out.print(root.data+" ");
        }
        klevel(root.left, level+1, k);
        klevel(root.right, level+1, k);
    }
    public static boolean getpath(Node root,int n,ArrayList<Node> path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return true;
        }

        boolean foundLeft = getpath(root.left, n, path);
        boolean foundRight = getpath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;

    } 

    public static Node lca1(Node root,int n1,int n2){ // tc = o(n) sc = o(n)
        ArrayList <Node> path1 = new ArrayList<>();
        ArrayList <Node> path2 = new ArrayList<>();

        getpath(root,n1,path1);
        getpath(root,n2,path2);

        int i = 0;
        for(;i<path1.size()&&i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        // i-1 is lca
        return path1.get(i-1);   
    }

    public static Node lca2(Node root,int n1,int n2){ // tc = o(n) sc = o(n) no extra space only call stack of recursion
        if(root==null || root.data==n1 || root.data==n2){
            return root;
        }
        Node leftlca = lca2(root.left,n1,n2);
        Node rightlca = lca2(root.right,n1,n2);

        if(leftlca==null){
            return rightlca;
        }
        if(rightlca==null){
            return leftlca;
        }
            return root;
    }
    public static int lcadist(Node root,int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftdist = lcadist(root.left, n);
        int rightdist = lcadist(root.right, n);
        if(leftdist== -1 && rightdist == -1){
            return -1;
        }else if(leftdist == -1){
            return rightdist+1;
        }else{
            return leftdist+1;
        }
    }

    public static int minDist(Node root,int n1,int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = lcadist(root,n1);
        int dist2 = lcadist(root,n2);
        return dist1+dist2;
    }

    public static int kAncestor(Node root,int n,int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int left = kAncestor(root.left,n, k);
        int right = kAncestor(root.right, n, k);
        if(left==-1 && right==-1){
            return -1;
        }
        int max = Math.max(left, right);
        if(max+1==k ){
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int sumtree(Node root){
        if(root == null){
            return 0;
        }
        int data = root.data;
        int left = sumtree(root.left);
        int right = sumtree(root.right);
        int newleft = root.left==null ?0: root.left.data;
        int newright = root.right==null?0:root.right.data;
        root.data = left + newleft + right + newright;
        return data;
    }

    
    }

    
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,7,-1,-1,6,-1,-1};
        int nodes2[] = {2,4,-1,-1,5,-1,-1};
        Binarytree tree = new Binarytree(); // TC--> o(n)
        Node root = tree.buildTree(nodes);
        
        // Node subroot = new Node(2);
        // subroot.left = new Node(4);
        // subroot.right = new Node(5);
        //tree.levelorder(root);
        // tree.preorder(root);
        // System.out.println(tree.issubtree(root,subroot));
        // System.out.println(tree.optDiameter(root).diam);
        // tree.levelorder(root);
        // tree.topview(root);

        // tree.klevel(root, 1, 3);
        // System.out.println(tree.lca1(root, 4, 5).data);
        //System.out.println(tree.lca2(root,4,3).data);
        //System.out.println(tree.minDist(root, 4,6));
        //tree.kAncestor(root, 4, 2);
        tree.sumtree(root);
        tree.levelorder(root);



    }
}