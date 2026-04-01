import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class AdjacencyList {
    public static void addEdge(List<List<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
    public static void displayAdjList(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i ++) {
            System.out.print(i +" --> ");
            for (int j : adj.get(i)) {
                System.out.print(j +" ");
            }
        }
    }
    public static void main(String[] args) {
        int v = 4;
        List<List<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v;i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        System.out.println("Adjaceny List representation : ");
        displayAdjList(adj);
    }
}
