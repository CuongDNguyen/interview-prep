import java.util.ArrayList;
import java.util.Arrays;

public class PathMoreThanKLengthFromSource {
    /*
    Given a graph, a source vertex in the graph and a number k,
     find if there is a simple path (without any cycle)
     starting from given source and ending at any other vertex
    such that the distance from source to that vertex is atleast ‘k’ length.

    Input  : Source s = 0, k = 58
    Output : True
    There exists a simple path 0 -> 7 -> 1
    -> 2 -> 8 -> 6 -> 5 -> 3 -> 4
    Which has a total distance of 60 km which
    is more than 58.

    Input  : Source s = 0, k = 62
    Output : False

    In the above graph, the longest simple
    path has distance 61 (0 -> 7 -> 1-> 2
     -> 3 -> 4 -> 5-> 6 -> 8, so output
    should be false for any input greater
    than 61.
     */
}

class GraphWeightedUndirected {
    public static void main(String[] args) {
        int V = 9;
        Graph g = new Graph(V);

        // making above shown graph
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        int src = 0;
        int k = 62;

        if(g.pathMoreThanK(src, k))
            System.out.println("YES");
        else
            System.out.println("NO");


        k = 60;
        if(g.pathMoreThanK(src, k))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    static class GraphNode {
        int val;
        int weight;

        GraphNode (int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
        int getVal() { return this.val;}
        int getWeight() {return this.weight;}

    }

    static class Graph {
        int vertices;
        ArrayList<ArrayList<GraphNode>> adj;

        Graph(int vertices) {
            this.vertices = vertices;
            adj = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int x, int y, int weight) {
            GraphNode node1 = new GraphNode(y, weight);
            adj.get(x).add(node1);

            GraphNode node2 = new GraphNode(x, weight);
            adj.get(y).add(node2);
        }

        boolean pathMoreThanK(int source, int k) {
            boolean path[] = new boolean[vertices];

            Arrays.fill(path, false);
            path[source] = true;
            return pathMoreThanK(source, k, path);
        }

        boolean pathMoreThanK(int source, int k, boolean[] path) {
            if ( k <= 0) {
                return true;
            }

            ArrayList<GraphNode> li = adj.get(source);
            int index = 0;
            for (int i = 0; i < adj.get(source).size(); i++) {
                GraphNode vertex = adj.get(source).get(i);
                int value = vertex.val;
                int weight = vertex.weight;

                index++;

                if (path[value] == true) {
                    continue;
                }

                if (weight >= k) {
                    return true;
                }

                path[value] = true;

                if (pathMoreThanK(value, k - weight, path))
                    return true;

                path[value] = false;
            }
            return false;
        }
    }
}
