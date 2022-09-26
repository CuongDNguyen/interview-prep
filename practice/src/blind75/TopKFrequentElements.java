package blind75;

import java.util.*;

/*
Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] testCase = {1,1,1,2,2,3,3,3,3,3,3,3,3,4,4,4,4,4};
        System.out.println(Arrays.toString(getTopKFrequentElements(testCase, 2)));
    }

    /*
    Create hashmap to store the frequency of each number in array
    Priority queue to give the k frequent numbers
     */
    static int[] getTopKFrequentElements(int[] arrays, int k) {

        List<Integer> lst = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for ( int num : arrays) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pqueue = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? Integer.compare(b.getKey(), a.getKey()) :
                        Integer.compare(b.getValue(), a.getValue())
        );

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            pqueue.add(entry);
        }

        for (int i = 0; i < k; i++) {
            lst.add(pqueue.poll().getKey());
        }

        return lst.stream().mapToInt(i -> i).toArray();
    }
}
