import java.util.*;

public class BFS {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        // BFS forest traversal: iterate vertices in index order so disconnected
        // components are also visited in a deterministic output order.
        boolean[] visited = new boolean[v];
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int s = 0; s < v; s++) {
            if (!visited[s]) {
                Queue<Integer> q = new LinkedList<>();
                visited[s] = true;
                q.add(s);

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
