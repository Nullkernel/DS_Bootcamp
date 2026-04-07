import java.util.*;

public class AdjacencyList {
    private static void validateVertex(List<List<Integer>> adj, int vertex, String name) {
        if (vertex < 0 || vertex >= adj.size()) {
            throw new IllegalArgumentException(
                name + " index out of bounds: " + vertex + ". Valid range is 0 to " + (adj.size() - 1)
            );
        }
    }

    public static void addEdge(List<List<Integer>> adj, int i, int j) {
        validateVertex(adj, i, "Source vertex");
        validateVertex(adj, j, "Destination vertex");
        adj.get(i).add(j);
        adj.get(j).add(i); // for undirected graph
    }

    public static void removeEdge(List<List<Integer>> adj, int i, int j) {
        validateVertex(adj, i, "Source vertex");
        validateVertex(adj, j, "Destination vertex");
        adj.get(i).remove(Integer.valueOf(j));
        adj.get(j).remove(Integer.valueOf(i)); // for undirected graph
    }

    public static void displayAdjList(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + " --> ");
            for (int j : adj.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v = 4;
        List<List<Integer>> adj = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);

        System.out.println("Adjacency List after adding edges:");
        displayAdjList(adj);

        removeEdge(adj, 1, 2);
        removeEdge(adj, 2, 3);

        System.out.println("Adjacency List after removing edges (1,2) and (2,3):");
        displayAdjList(adj);
    }
}
