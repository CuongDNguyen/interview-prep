import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Rooted tree n
m triplets,

jth triplet is denoted as
    uj vj cj
        represents path in the tree
        where u is ancestor of v
        cost of path is c

select path where sum of path costs is max
i edge of tree belongs to at most d paths from subset
print sum as output

first line T denotes # number of testcases

testcases
2 integers space separated v (vertices) and m (# paths)
each line i of v - 1 contains 3 integers
    a b = edge, d = max # paths include this edge
each line of m contains 3
    u v c, define j and its cost

8 vertices
[[1, 2, 3], [1, 3, 1], [2, 4, 5], [2, 5, 1], [2, 6, 1], [3, 7, 2], [4, 8, 1]] paths
[[1, 2, 3], [2, 8, 5], [1, 8, 7], [1, 5, 8], [1, 6, 10], [3, 7, 5], [1, 7, 6], [1, 7, 6]] edges

Example:
[1 2 3]
1 is ancestor of 2, with edge value of 3
 */
public class VerticalPaths {
    public static void main(String[] args) {

        verticalPaths(8, createTestCasePaths(), createTestCaseEdges());
    }

    static List<List<Integer>> createTestCasePaths() {
        List<List<Integer>> paths = new ArrayList<>();
        paths.add(Arrays.asList(1, 2, 3));
        paths.add(Arrays.asList(1, 3, 1));
        paths.add(Arrays.asList(2, 4, 5));
        paths.add(Arrays.asList(2, 6, 1));
        paths.add(Arrays.asList(3, 7, 2));
        paths.add(Arrays.asList(4, 8, 1));
        return paths;
    }

    static List<List<Integer>> createTestCaseEdges() {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1, 2, 3));
        edges.add(Arrays.asList(2, 8, 5));
        edges.add(Arrays.asList(1, 8, 7));
        edges.add(Arrays.asList(1, 5, 8));
        edges.add(Arrays.asList(1, 6, 10));
        edges.add(Arrays.asList(3, 7, 5));
        return edges;
    }

    static int verticalPaths(int n, List<List<Integer>> paths, List<List<Integer>> edges) {
        System.out.println(n);
        System.out.println(paths);
        System.out.println(edges);
        return 0;
    }
}

class Tree {
    Tree left;
    Tree right;
    int val;

    Tree (int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }

    Tree(int val, Tree left, Tree right) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}

class Edge {
    int v;
    long c;
}
