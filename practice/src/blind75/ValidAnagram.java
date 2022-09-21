package blind75;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, return true if t is an anagram of s,
and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters
of a different word or phrase, typically using all the original
letters exactly once.

Given two strings s and t, return true if t
 is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by
 rearranging the letters of a different word or phrase,
  typically using all the original letters exactly once.

HashMap of both words
compare the counts of index
if match == true else false
 */
public class ValidAnagram {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(isValidAnagram(s, t));
    }

    static boolean isValidAnagram(String s, String t) {
        if (s==null && t==null) return true;
        else if (s==null || t==null) return false;
        else if (s.length() != t.length()) return false;

        Map<Character, Integer> dict = new HashMap<>();
        for(char c : s.toCharArray()) dict.put(c, dict.getOrDefault(c, 0) + 1);
        for(char c : t.toCharArray()) {
            int count = dict.getOrDefault(c, 0);
            if (count == 0) return false;
            else dict.put(c, count - 1);
        }

        return true;
    }
}
