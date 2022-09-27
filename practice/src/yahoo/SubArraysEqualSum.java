package yahoo;

import java.util.HashMap;

public class SubArraysEqualSum {
    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        int sum = -10;
        int n = arr.length;
        System.out.println(getSubArrays(arr, sum));
    }

    static int getSubArrays(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            int removeSum = currentSum - sum;

            if(map.containsKey(removeSum)) {
                result += map.get(removeSum);
            }

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return result;
    }
}
