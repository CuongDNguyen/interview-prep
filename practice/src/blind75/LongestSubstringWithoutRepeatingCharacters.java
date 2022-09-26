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
        String longestSubstring = ""; //Initialize the returned string
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < str.length(); end++) { //end pointer
            Character currCharacter = str.charAt(end); //current character

            if (map.containsKey(currCharacter)) { //check map to see if current character is duplicate
                start = Math.max(map.get(currCharacter) + 1, start); // set start of substring to either the starting pointer or previous substring length
            }

            if (longestSubstring.length() < end - start + 1) { //if length of substring is less than end - start + 1
                longestSubstring = str.substring(start, end + 1);
            }

            map.put(currCharacter, end);
        }


        return longestSubstring;
    }
}
