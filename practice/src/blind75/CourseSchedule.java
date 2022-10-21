package blind75;

import java.util.*;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.

//Topological Sort, find all nodes starting from the one that isn't dependent on any other node

 */
public class CourseSchedule {
    public static void main(String[] args) {
        int[][] testCase = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(BFSLeetCodeOfficialSolution.findOrder(4, testCase)));
    }
   static class BFSLeetCodeOfficialSolution {
       static int[] findOrder(int numCourses, int[][] prerequisites) {
           Map<Integer, List<Integer>> checkedMap = new HashMap<>();
           int[] degree = new int[numCourses];
           int[] schedule = new int[numCourses];

           for(int i = 0; i < prerequisites.length; i++) {
               int destination = prerequisites[i][0];
               int src = prerequisites[i][1];

               List<Integer> lst = checkedMap.getOrDefault(src, new ArrayList<>());
               lst.add(destination);

               checkedMap.put(src, lst);
               degree[destination] += 1;
           }

           Queue<Integer> queue = new LinkedList<>();
           for (int i = 0; i < numCourses; i++) {
               if (degree[i] == 0) {
                   queue.add(i);
               }
           }

           int i = 0;
           while(!queue.isEmpty()) {
               int current = queue.poll();
               schedule[i++] = current;

               if(checkedMap.containsKey(current)) {
                   for (Integer neighbor : checkedMap.get(current)) {
                       degree[neighbor]--;

                       if (degree[neighbor] == 0) {
                           queue.add(neighbor);
                       }
                   }
               }
           }

           if (i == numCourses) return schedule;
           return new int[0];
       }
   }

   static class mySolution {
       public static void main(String[] args) {
           int[][] testCase = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
           System.out.println(findTopologicalSort(4, testCase));
       }

       static boolean findTopologicalSort(int numCourses, int[][] prerequisites) {
           {
               //topological sort
               //graph with prerequiites as the edges
               Map<Integer, List<Integer>> map = new HashMap<>();

               int[] degree = new int[numCourses];
               int[] schedule = new int[numCourses];

               for (int i = 0; i < prerequisites.length; i++) {
                   int destination = prerequisites[i][0];
                   int src = prerequisites[i][1];

                   List<Integer> list = map.getOrDefault(src, new ArrayList<>());
                   list.add(destination);

                   degree[destination] += 1;
                   map.put(src, list);
               }

               int courses = 0;
               Queue<Integer> queue = new LinkedList<>();
               for (int i = 0; i < numCourses; i++) {
                   if (degree[i] == 0) {
                       queue.add(i);
                   }
               }

               while (!queue.isEmpty()) {
                   int current = queue.poll();
                   schedule[courses++] = current;
                   if (map.containsKey(current)) {
                       for (Integer neighbor : map.get(current)) {
                           degree[neighbor]--;

                           if (degree[neighbor] == 0) {
                               queue.add(neighbor);
                           }
                       }
                   }
               }

               if (courses == numCourses) return true;
               return false;
           }
       }
   }
}
