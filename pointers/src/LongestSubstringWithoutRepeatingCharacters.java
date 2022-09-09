
//Sliding window pointers
//Time complexity O(n) since we slide the window whenever we see repetitions
//Space complexity O(1)
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        String str = "geeksforgeeks";
        System.out.println("The input string is " + str);

        int len = longestUniqueSubstring(str);
        System.out.println("The length of the longest "
                + "non-repeating character "
                + "substring is " + len);
    }

    public static int longestUniqueSubstring(String str) {
        String test = "";
        int maxLength = -1;

        //Return edge cases of null or 1
        if (str.isEmpty()) {
            return 0;
        } else if (str.length() == 1) {
            return 1;
        }

        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);

            if (test.contains(current)) {
                test = test.substring(test.indexOf(current) + 1);
            }
            test = test + String.valueOf(c);
            maxLength = Math.max(test.length(), maxLength);
        }

        return maxLength;
    }
}
