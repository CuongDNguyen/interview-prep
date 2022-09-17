package yahoo;

import java.util.*;

/*
Given an integer array nums and an integer k,
 return the k most frequent elements.
  You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

Solve:
Use a HashMap to count the occurence of each number
Find all keys where value >= k

Time Complexity would be O(n)
Space complexity would be O(n)
 */
public class TopKFrequentElements {
    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(kFrequentElements(nums, 2)));
    }

    static int[] kFrequentElements(int[] arrays, int k) {
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrays.length; i ++) {
            if (numberMap.containsKey(arrays[i])) {
                numberMap.put(arrays[i], numberMap.get(arrays[i]) + 1);
            } else {
                numberMap.put(arrays[i], 1);
            }
        }

        for (Map.Entry entry : numberMap.entrySet()) {
            int value = (int) entry.getValue();
            if (value >= k) {
                result.add((Integer)entry.getKey());
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }


}
