public class GraphColouring {  
    static void printSolution(int[] colour, int V) {
        System.out.print("Assigned colours are::");
        for (int i = 0; i < V; i++)
            System.out.print(" " + colour[i]);
        System.out.println();
    }

    // Check if the whole graph is coloured properly.
    static boolean isSafe2(boolean[][] graph, int[] colour, int V) {
        for (int i = 0; i < V; i++)
            for (int j = i + 1; j < V; j++)
                if (graph[i][j] && colour[j] == colour[i])
                    return false;
        return true;
    }

    static boolean graphColouring2(boolean[][] graph, int V, int m, int[] colour, int i){
        if (i == V) {
            if (isSafe2(graph, colour, V)) {
                printSolution(colour, V);
                return true;
            }
            return false;
        }

        // Assign each colour from 1 to m
        for (int j = 1; j <= m; j++) {
            colour[i] = j;
            if (graphColouring2(graph, V, m, colour, i + 1))
                return true;
        }
        return false;
    }


    static boolean graphColouring2(boolean[][] graph, int V, int m){
        int[] colour = new int[V];
        if (graphColouring2(graph, V, m, colour, 0))
                return true;
        return false;
    }

    public static void main(String[] args)
    {
        boolean[][] graph = {
        { false, true, false, false, true },
        { true, false, true, false, true },
        { false, true, false, true, true },
        { false, false, true, false, true },
        { true, true, true, true, false },
        };
        int V = 5; // Number of vertices
        int m = 4; // Number of colours
        if (!graphColouring2(graph, V, m))
            System.out.println("Solution does not exist");
        if (!graphColouring(graph, V, m))
            System.out.println("Solution does not exist");
    }

    // Is it safe to colour vth vertice with c colour.
    static boolean isSafe(boolean graph[][], int V, int colour[], int v, int c) {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == true && c == colour[i])
                return false;
        return true;
    }

    static boolean graphColouringUtil(boolean graph[][], int V, int m, int colour[], int i) {
        if (i == V){
            printSolution(colour, V);
            return true;
        }
    
        for (int j = 1; j <= m; j++) {
            if (isSafe(graph, V, colour, i, j)) {
                colour[i] = j;
                if(graphColouringUtil(graph, V,  m, colour, i + 1))
                    return true;
            }
        }
        return false;
    }

    static boolean graphColouring(boolean[][] graph, int V, int m){
        int[] colour = new int[V];
        if (graphColouringUtil(graph, V, m, colour, 0)){
            return true;
        }
        return false;
    }
}