import java.util.Arrays;

//2 pointers in same direction, in place
//Time complexity: O(n) Space complexity: O(1)
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] testRemoveDuplicatesInSortedArray = {1,2,2,2,3,3,3,3,4,4,4,4,5,23};
        System.out.println(Arrays.toString(removeDuplicates(testRemoveDuplicatesInSortedArray)));
    }

    public static int[] removeDuplicates(int[] nums) {
        int lengthOfArray = nums.length;
        if (lengthOfArray == 0 || lengthOfArray == 1) {
            return nums;
        }

        //2 pointer
        int j = 0;

        for (int i = 0; i < lengthOfArray - 1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[j] = nums[i];
                j++;
            }
        }

        nums[j] = nums[lengthOfArray - 1];
        j++;

    return nums;
    }
}

