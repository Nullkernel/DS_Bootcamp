import java.util.*;

public class BFS {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        boolean[] visited = new boolean[v];
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int src = 0;
        visited[src] = true;
        q.add(src);

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 1, 0);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);

        ArrayList<Integer> res = bfs(adj);
        System.out.println(res);
    }
}
