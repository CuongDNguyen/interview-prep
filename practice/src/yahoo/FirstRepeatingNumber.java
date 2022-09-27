package yahoo;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingNumber {
    public static void main(String[] args) {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        System.out.println(getFirstRepeatingNumber(arr));

        int arr2[] = {6, 10, 5, 4, 9, 120, 4, 6, 10};
        System.out.println(getFirstRepeatingNumber(arr2));
    }

    static int getFirstRepeatingNumber(int[] nums) {
        //iterate through array, get the duplicates, find the first one that occurred
        //get duplicates by counting frequency of each number in an array through hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) > 1) {
                return nums[i];
            }
        }
        return -1;
    }
}
