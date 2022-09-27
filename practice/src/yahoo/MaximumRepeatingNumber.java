package yahoo;

import java.util.*;

public class MaximumRepeatingNumber {
    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        int[] arr = new int[] {
                18,23,17,26,16,3,28,28,10,17,44,28,2,20,22,21,18,36,34,37,18,38,20,1,31,17,20,6,27,37,11,24,39,7,3,9,36,31,16,46,27,13,6,9,13,28,9,31,44,43,1,15,35,21,42,45,38,41,4,18,32,15,22,3,1,25,38,37,36,34,15,16,0,22,4,39,29,14,3,5,10,4,20,24
        };
        System.out.println(maxRepeating(arr, 84, 47));
    }

    static int maxRepeating(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = map.entrySet().stream().max( (entry1, entry2) -> Integer.compare(entry1.getValue(), entry2.getValue())).get().getKey();
        return max;
    }
}
