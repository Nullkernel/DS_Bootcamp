public class AdjacencyMatrix {
    private static void validateVertex(int[][] mat, int vertex, String name) {
        if (vertex < 0 || vertex >= mat.length) {
            throw new IllegalArgumentException(
                name + " Index out of bounds: " + vertex + ". Valid range is 0 to " + (mat.length - 1)
            );
        }
    }
    public static void addEdge(int[][] mat, int i, int j) {
        validateVertex(mat, i, "Source vertex");
        validateVertex(mat, j, "Destination vertex");
        mat[i][j] = 1;
        mat[j][i] = 1; // for undirected graph
    }
    public static void removeEdge(int[][] mat, int i, int j) {
        validateVertex(mat, i, "Source vertex");
        validateVertex(mat, j, "Destination vertex");
        mat[i][j] = 0;
        mat[j][i] = 0; // for undirected graph
    }
    public static void displayMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int v = 4;
        int[][] mat = new int[v][v];
        addEdge(mat, 0, 1);
        addEdge(mat, 0, 2);
        addEdge(mat, 1, 2);
        addEdge(mat, 2, 3);
        System.out.println("Adjacency Matrix after adding edges:");
        displayMatrix(mat);
        removeEdge(mat, 1, 2);
        removeEdge(mat, 2, 3);
        System.out.println("Adjacency Matrix after removing edges (1,2) and (2,3):");
        displayMatrix(mat);
    }
}
