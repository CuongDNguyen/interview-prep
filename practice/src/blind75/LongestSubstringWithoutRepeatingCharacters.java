package blind75;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        System.out.println(getLongestSubstring("geeksforgeeks"));
        System.out.println(mimicGetLongestSubstring("geeksforgeeks"));
    }

    static String getLongestSubstring(String s) {
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

    static String mimicGetLongestSubstring(String str) {
        Map<Character, Integer> map = new HashMap<>();

        String longestSubstring = "";

        for (int start = 0, end = 0; end < str.length(); end++) {
            Character currCharacter = str.charAt(end);

            if (map.containsKey(currCharacter)) {
                start = Math.max(map.get(currCharacter) + 1, start);
            }

            if (longestSubstring.length() < end - start + 1) {
                longestSubstring = str.substring(start, end + 1);
            }

            map.put(currCharacter, end);
        }
        return longestSubstring;
    }
}
