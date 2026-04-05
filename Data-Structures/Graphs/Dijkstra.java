import java.util.*;

public class Dijkstra {

    /**
     * Adds an undirected weighted edge between u and v.
     */
    static void addUndirectedEdge(ArrayList<ArrayList<int[]>> adj, int u, int v, int w) {
        adj.get(u).add(new int[]{v, w});
        adj.get(v).add(new int[]{u, w});
    }

    /**
     * Adds a directed weighted edge from u to v.
     */
    static void addDirectedEdge(ArrayList<ArrayList<int[]>> adj, int u, int v, int w) {
        adj.get(u).add(new int[]{v, w});
    }

    static long[] dijkstra(ArrayList<ArrayList<int[]>> adj, int src) {
        int n = adj.size();
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, src});

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long d = top[0];
            int u = (int) top[1];

            if (d > dist[u]) continue;

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];

                if (dist[u] != Long.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new long[]{dist[v], v});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph is undirected.
        addUndirectedEdge(adj, 0, 1, 2);
        addUndirectedEdge(adj, 0, 2, 4);
        addUndirectedEdge(adj, 1, 2, 1);
        addUndirectedEdge(adj, 1, 3, 7);
        addUndirectedEdge(adj, 2, 4, 3);
        addUndirectedEdge(adj, 3, 4, 1);

        long[] result = dijkstra(adj, 0);
        System.out.println(Arrays.toString(result));
    }
}
