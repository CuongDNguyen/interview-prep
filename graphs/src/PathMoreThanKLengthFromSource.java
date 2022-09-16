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
