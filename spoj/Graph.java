import java.util.LinkedList;
import java.util.List;

public class Graph {

    int vertices;
    LinkedList<Integer>[] adj;
    Graph(int v) {
        this.vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }
}
