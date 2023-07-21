import java.util.*;
import java.util.Queue;
public class Graphs {
    static class edge{
        int source;
        int dest;
        int wt;
        public edge(int source,int dest,int wt){
            this.source = source;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static void  bfs(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsutil(graph,vis);
            }
        }
    }
    public static void bfsutil(ArrayList<edge> graph[],boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0); // add source
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static boolean haspath(ArrayList<edge> graph[],int source,int dest,boolean vis[]){
        if(source==dest){
            return true;
        }
        vis[source] = true;
        for(int i=0;i<graph[source].size();i++){
            edge e= graph[source].get(i);
            if(!vis[e.dest]&&haspath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }
    public static void  dfs(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[10];
        for(int i=0;i<graph.length;i++){
            dfsutil(graph,i,vis);
        }
    }

    public static void dfsutil(ArrayList<edge> graph[],int curr,boolean vis[]){
        System.out.print(curr+" ");
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsutil(graph, e.dest, vis);
            }
        }
    }

    public static boolean Detectcycle(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(Detectcycleutil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean Detectcycleutil(ArrayList<edge> graph[],boolean vis[],int curr,int par){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            //case-3
            if(!vis[e.dest]){
                if(Detectcycleutil(graph,vis,e.dest,curr)){
                    return true;
                }
            }
            //case -1
            else if(vis[e.dest] && e.dest!=par){
                return true;
            }
        }
        return false;
    }

    public static boolean isBipartite(ArrayList<edge>graph[]){
        int col[] = new int[graph.length];
        for(int i=0;i<col.length;i++){
            col[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){ // not coloured
                col[i] = 0; // yellow
                q.add(i);
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        edge e = graph[curr].get(j);
                        if(col[e.dest]==-1){
                            int nextcol = col[curr] == 0 ?1:0;
                            col[e.dest] = nextcol;
                            q.add(e.dest);
                        }else if(col[curr]==col[e.dest]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean iscycle(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(iscycleutil(graph,i,vis,stack)){
                    return true;
                }
            }
        }
        return false;

    }
    public static boolean iscycleutil(ArrayList<edge> graph[],int curr,boolean vis[],boolean stack[]){
        vis[curr] = true;
        stack[curr]  = true;
        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(stack[e.dest]){ // cycle
                return true;
            }
            if(!vis[e.dest]&& iscycleutil(graph,e.dest,vis,stack)){
                return true;
            }
        }
        stack[curr]= false;
        return false;
    }

    public static void topsort(ArrayList<edge> graph[]){
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topsortutil(graph,i,vis,s);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void topsortutil(ArrayList<edge> graph[],int curr,boolean vis[],Stack<Integer> s){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topsortutil(graph,e.dest,vis,s);
            }
        }
        s.push(curr);
    }
    public static void main(String[] args) {
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
        ArrayList<edge> []graph2 = new ArrayList[6];
        for(int i=0;i<graph2.length;i++){
            graph2[i] = new ArrayList<>();
        }
        // graph2[0].add(new edge(0, 2, 0));
        // graph2[1].add(new edge(1, 0, 0));
        // graph2[2].add(new edge(2, 3, 0));
        // graph2[3].add(new edge(3, 0, 0));
        // System.out.println(iscycle(graph2));

        graph2[2].add(new edge(2, 3, 0));

        graph2[3].add(new edge(3, 1, 0));

        graph2[4].add(new edge(4, 0, 0));
        graph2[4].add(new edge(4, 1, 0));

        graph2[5].add(new edge(2, 3, 0));
        graph2[5].add(new edge(2, 3, 0));
        topsort(graph2);

    }
}
