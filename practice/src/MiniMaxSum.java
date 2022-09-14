import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given five positive integers, find the minimum and maximum values
that can be calculated by summing exactly four of the five integers.
Then print the respective minimum and maximum values as a
single line of two space-separated long integers.

Example:
arr = [1, 3, 5, 7, 9]
min sum = 16
max sum = 24

output: 16 24
 */
public class MiniMaxSum {
    public static void main(String[] args) {

        Integer[] sourceArray =
                {256741038, 623958417, 467905213, 714532089, 938071625
                };
        List<Integer> array = Arrays.asList(sourceArray);
        System.out.println(solveMiniMaxSum(array));
    }

    static String solveMiniMaxSum(List<Integer> array) {
        boolean minSumInitial = false;
        Long minSum = 0L;
        Long maxSum = 0L;
        for (int i = 0; i < array.size(); i++) {
            Long currentSum = getExclusiveSum(array, i);
            if (!minSumInitial) {
                minSum = currentSum;
                minSumInitial = true;
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < minSum) {
                minSum = currentSum;
            }
        }
        return minSum + " " + maxSum;
    }

    static Long getExclusiveSum(List<Integer> array, int index) {
        long exclusiveSum = 0;
        for (int i = 0; i < array.size(); i++) {
            if (i == index) {
                continue;
            } else {
                exclusiveSum += array.get(i);
            }
        }
        return exclusiveSum;
    }
}
