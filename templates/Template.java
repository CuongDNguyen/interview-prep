import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Template {
    public static void main(String[] args) {
        int[] testBinarySearch = new int[]{1,2,3,4,5,6,7,8,9,10,12,15,16};
        System.out.println(Template.binarySearch(testBinarySearch, 8));
        System.out.println(lengthOfLongestSubstring("whatisthisabc"));
    }

    /*
    Use hashMap keep track of latest index of each letter
    Keep left pointer at rest, move right 1 letter at a time
    Repeating character encountered, update max length and move left to max (left, value in map),
    Do max because we don't move left backwards
    Return max (right - left, maxLength)
    Do outside loop to handle strings with all unique chars
     */
    static String lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            if (map.containsKey(currChar)) {
                start = Math.max(map.get(currChar) + 1, start);
            }

            if (output.length() < end - start + 1) {
                output = s.substring(start, end + 1);
            }

            map.put(currChar, end);
        }
        return output;
    }
    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /*
    backtracking
    choose, explore, unchoose

    1. define helper function, to accept more parameters
    2. parameters
        1. the object
        2. start / end index
        3. step result, remember current choose and do unchoose
        4. final result

     3. base case
     4. for-loop
     5. choose
     6. explore
     7. unchoose
     */
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;
    }

    public void helper(String s, List<String> step, List<List<String>> result) {
        for(int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if(!isPalindrome(temp)) continue; // only do backtracking when current string is palindrome

            step.add(temp);  // choose
            helper(s.substring(i, s.length()), step, result); // explore
            step.remove(step.size() - 1); // unchoose
        }
        return;
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
}
