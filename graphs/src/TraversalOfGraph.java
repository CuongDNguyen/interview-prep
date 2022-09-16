import java.util.*;

/*
BFS:
Declare a queue and insert the starting vertex.
Initialize a visited array and mark the starting vertex as visited.
Follow the below process till the queue becomes empty:
Remove the first vertex of the queue.
Mark that vertex as visited.
Insert all the unvisited neighbours of the vertex into the queue.

 DFS: visited array and sourceNode in function,
 for each neighbors not visited, call DFS recursively

 DFS uses stack data structure
    1. Detecting cycles in a graph
            Run DFS for checking back edges
    2. Path finding
        Call DFS(G, startVertex)
        Use stack to keep track between start and current
        As soon as end vertex reached, return stack path
    3. Topological Sorting
    4. Test if graph bipartite
    5. Finding strongly connected components
    6. Solving puzzles with only one solution

 BFS
    1. Shortest path and minimum spanning tree for unweighted graph
    2. Cycle detection in undirected graph
    3. Ford-Fulkerson (find max flow)
    4. Test if graph bipartite
    5. Path finding
    6. Find all nodes within one connected components
 */
public class TraversalOfGraph {
    public static void main(String[] args) {
        System.out.println("BFS###");
        createTestCase().BFS(2);

        System.out.println("DFS###");
        createTestCase().DFS(2);
    }

    static Graph createTestCase() {
        /*
                0   1
                2   3
         */
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        return g;
    }
}

class Graph {
    private int vertices;
    private LinkedList<Integer>[] neighbors;

    Graph(int vertices) {
        this.vertices = vertices;
        neighbors = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            neighbors[i] = new LinkedList<>();
        }
    }

    void addEdge(int x, int y) {
        neighbors[x].add(y);
    }

    void BFS(int sourceNode) {
        boolean[] visited = new boolean[vertices];

        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(sourceNode);
        visited[sourceNode] = true;

        while (queue.size() != 0) {
            sourceNode = queue.poll();
            System.out.println(sourceNode + " ");

            for (int neighbor : neighbors[sourceNode]) {
                if (visited[neighbor] == false) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }


    }

    void DFS(int sourceNode) {
        boolean visited[] = new boolean[vertices];
        DFS(sourceNode, visited);
    }

    void DFS(int sourceNode, boolean[] visited) {
        visited[sourceNode] = true;
        System.out.println(sourceNode);
        for (int neighbor : neighbors[sourceNode]) {
            if (visited[neighbor] != true) {
                visited[neighbor] = true;
                DFS(neighbor, visited);
            }
        }
    }
}

class GraphHash {
    public static void main(String[] args) {
        GraphHash graph = new GraphHash(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();

    }
    int vertices;
    HashMap<Integer, TreeSet<Integer>> graph;

    GraphHash(int vertices) {
        this.vertices = vertices;
        graph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            graph.put(i, new TreeSet<>());
        }
    }

    void addEdge(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    void printGraph() {
        for(int i = 0; i < vertices; i++) {
            System.out.println("Adjacency list of vertex: " + i);
            for (int set : graph.get(i)) {
                System.out.println(set);
            }
        }
    }
}

class GraphArray {

    public static void main(String[] args) {
        int vertices = 7;

        /*

        A mother vertex in a graph G = (V, E) is a vertex v
        such that all other vertices in G can be reached by a path from v.

        1. Undirected Connected Graph (All are mother vertices)
        2. Undirected/Directed Disconnected (No mother vertices)
        3. Directed Connected Graph
         */
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<Integer>());
        }
        addEdge(0, 1, graph);
        addEdge(0, 2, graph);
        addEdge(1, 3, graph);
        addEdge(4, 1, graph);
        addEdge(6, 4, graph);
        addEdge(5, 6, graph);
        addEdge(5, 2, graph);
        addEdge(6, 0, graph);
        System.out.println("Mother vertex " + motherVertex(graph, vertices));
    }

    static void addEdge(int x, int y, ArrayList<ArrayList<Integer>> neighbors) {
        neighbors.get(x).add(y);
    }

    static void DFS(ArrayList<ArrayList<Integer>> graph, int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int x : graph.get(vertex)) {
            if (visited[x] == false) {
                DFS(graph, x, visited);
            }
        }
    }

    static int motherVertex(ArrayList<ArrayList<Integer>> graph, int vertices) {
        boolean[] visited = new boolean[vertices];

        int motherVertex = -1;

        for (int i = 0; i < vertices; i++) {
            if (visited[i] == false) {
                DFS(graph, i, visited);
                motherVertex = i;
            }
        }

        boolean[] check = new boolean[vertices];
        DFS(graph, motherVertex, check);
        for (boolean val : check) {
            if (!val) {
                return -1;
            }
        }
        return motherVertex;
    }
}
