import java.util.*;

public class Dijkstra {

    /**
     * Adds an undirected weighted edge between vertices {@code u} and {@code v}.
     *
     * <p>This inserts both {@code u -> v} and {@code v -> u} into the adjacency list.
     */
    static void addUndirectedEdge(ArrayList<ArrayList<int[]>> adj, int u, int v, int w) {
        adj.get(u).add(new int[]{v, w});
        adj.get(v).add(new int[]{u, w});
    }

    /**
     * Adds a directed weighted edge from {@code u} to {@code v}.
     *
     * <p>This inserts only {@code u -> v}. No reverse edge is added.
     */
    static void addDirectedEdge(ArrayList<ArrayList<int[]>> adj, int u, int v, int w) {
        adj.get(u).add(new int[]{v, w});
    }

    /**
     * Computes shortest paths from {@code src} with Dijkstra's algorithm.
     *
     * <p>Precondition: all edge weights in {@code adj} must be non-negative.
     */
    static long[] dijkstra(ArrayList<ArrayList<int[]>> adj, int src) {
        for (ArrayList<int[]> edges : adj) {
            for (int[] edge : edges) {
                int w = edge[1];
                if (w < 0) {
                    throw new IllegalArgumentException("Dijkstra requires non-negative edge weights");
                }
            }
        }

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

        // This example graph is undirected, so we use addUndirectedEdge(...).
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
