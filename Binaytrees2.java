import java.util.*;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

import org.w3c.dom.Node;

public class Binaytrees2 {
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

        for(int i = min;i<max;i++){
            System.out.print(map.get(i).data+" ");
        }
    }
     public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right= new Node(7);
        topview(root);
        

     }


}
