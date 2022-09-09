import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time complexity is O(logn) Space complexity is O(1)
public class BinarySearch {
    public static void main(String[] args) {
        Integer[] numsArray = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        List<Integer> nums = Arrays.asList(numsArray);
        System.out.println(binarySearch(nums, 0, nums.size() - 1, 6));
    }

    static int binarySearch(List<Integer> array, int length, int height, int target) {
        int left = 0;
        int right = array.size() - 1;

        while (left <= right) { // <= here because left and right could point to the same element, < would miss it
            int mid = left + (right - left) / 2; // use `(right - left) /2` to prevent `left + right` potential overflow
            // found target, return its index
            if (array.get(mid) == target) return mid;
            if (array.get(mid) < target) {
                // middle less than target, discard left half by making left search boundary `mid + 1`
                left = mid + 1;
            } else {
                // middle greater than target, discard right half by making right search boundary `mid - 1`
                right = mid - 1;
            }
        }
        return -1;
    }
}
