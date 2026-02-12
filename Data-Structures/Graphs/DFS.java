import java.util.*;
public class DFS {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j){
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
    static void dfsUtil(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res){
        visited[node] = true;
        res.add(node);
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfsUtil(neighbor, visited, adj, res);
            }
        }
    }
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj){
        int v = adj.size();
        boolean[] visited = new boolean[v];
        ArrayList<Integer> res = new ArrayList<>();
        dfsUtil(0, visited, adj, res);
        return res;
    }
    public static void main(String[] args){
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 0);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        ArrayList<Integer> res = dfs(adj);
        System.out.println(res);
    }
}
