import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class DetectCycleInCycleGraph {
    /*
    Given a directed graph, check whether the graph contains a cycle or not.
    Your function should return true if the given graph contains at least one cycle, else return false.
Example,

Input: n = 4, e = 6
0 -> 1, 0 -> 2, 1 -> 2, 2 -> 0, 2 -> 3, 3 -> 3
Output: Yes
Explanation:
Diagram:

Given a directed graph, check whether the graph contains a cycle or not. Your function should return true if the given graph contains at least one cycle, else return false.
Example,

Input: n = 4, e = 6
0 -> 1, 0 -> 2, 1 -> 2, 2 -> 0, 2 -> 3, 3 -> 3
Output: Yes
Explanation:
Diagram:

Create the graph from given edges and vertices
Create recursive function to DFS graph

     */
    public static void main(String[] args) {
    }

    static class Graph {
        private int vertices;
        private List<List<Integer>> adj;

        Graph(int vertices) {
            this.vertices = vertices;
            adj = new ArrayList<>();

            for (int i = 0; i < vertices; i++) {
                adj.add(new LinkedList<>());
            }
        }

        private void addEdge(int source, int destination) {
            adj.get(source).add(destination);
        }

        private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

            if (recStack[i]) return true;

            if (visited[i]) return false;

            visited[i] = true;
            recStack[i] = true;

            List<Integer> children = adj.get(i);

            for (Integer c : children) {
               if (isCyclicUtil(c, visited, recStack)) return true;
            }

            recStack[i] = false;

            return false;
        }

        private boolean isCyclic() {
            boolean[] visited = new boolean[this.vertices];
            boolean[] recStack = new boolean[this.vertices];

            for (int i = 0; i < this.vertices; i++) {
                if (isCyclicUtil(i, visited, recStack)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Pair {
        private int first;
        private int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }
}
