public class Tries {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;
        Node(){
            for(int i=0;i<26;i++){
                children[i]= null;
            }
            this.freq = 1;
        }
    }
    public static Node root = new Node();
    
    public static void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node(); 
            }else{
                curr.children[i].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;

    }
    public static boolean search(String key){
        Node curr = root;
        for(int i=0;i<key.length();i++){
            int idx = key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow ==true;
    }
    public static boolean Word_break_problem(String key){
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0,i))&&
                Word_break_problem(key.substring(i))){
                    return true;
                }
        }
        return false;
    }
    public static void prefix(Node root,String ans){
        if(root == null){
            return ;
        }
        if(root.freq == 1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                prefix(root.children[i], ans+(char)(i-'a'));
            }
        }
    }

    public static void main(String[] args) {
        // String str[] = {"the","a","there","any","thee"};
        // for(int i=0;i<str.length;i++){
        //     insert(str[i]);
        // }
        // System.out.println(search("an")); 
        // String words[] = {"i","like","sam","samsung","mobile"};
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }
        // System.out.println(Word_break_problem("ilikesamsung"));
        root.freq = -1;
        String words[] = {"zebra","dog","duck","dove"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        prefix(root, "");


    }
}
// ArrayList<edge> []graph = new ArrayList[7];
        // for(int i=0;i<graph.length;i++){
        //     graph[i] = new ArrayList<>();
        // }

        // graph[0].add(new edge(0, 1, 5));
        // graph[0].add(new edge(0, 2, 5));


        // graph[1].add(new edge(1, 0, 5));
        // graph[1].add(new edge(1, 3, 1));


        // graph[2].add(new edge(2, 3, 3));
        // graph[2].add(new edge(2, 0, 3));


        // graph[3].add(new edge(3, 1, 1));
        // graph[3].add(new edge(3, 2, 5));

        // graph[4].add(new edge(4, 3, 3));
        // graph[4].add(new edge(4, 2, 1));


        // graph[4].add(new edge(4, 3, 5));
        // graph[4].add(new edge(4, 5, 5));

        // graph[5].add(new edge(5, 3, 5));
        // graph[5].add(new edge(5, 4, 5));
        // graph[5].add(new edge(5, 6, 5));

        // graph[6].add(new edge(6, 5, 5));



        // bfs(graph);
        // System.out.println();
        // dfs(graph);
        // System.out.println(haspath(graph, 0, 7,new boolean[10]));
        // System.out.println(Detectcycle(graph));
        //System.out.println(isBipartite(graph));
        // ArrayList<edge> []graph2 = new ArrayList[4];
        // for(int i=0;i<graph2.length;i++){
        //     graph2[i] = new ArrayList<>();
        // }
        // graph2[0].add(new edge(0, 2, 0));
        // graph2[1].add(new edge(1, 0, 0));
        // graph2[2].add(new edge(2, 3, 0));
        // graph2[3].add(new edge(3, 0, 0));
        // System.out.println(iscycle(graph2));

        // graph2[2].add(new edge(2, 3, 0));

        // graph2[3].add(new edge(3, 1, 0));

        // graph2[4].add(new edge(4, 0, 0));
        // graph2[4].add(new edge(4, 1, 0));

        // graph2[5].add(new edge(2, 3, 0));
        // graph2[5].add(new edge(2, 3, 0));