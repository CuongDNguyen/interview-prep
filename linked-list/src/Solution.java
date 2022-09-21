package src;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        String s = "A2Le";
        String T = "2pL1";
        System.out.println(checkOrm(s, T));

        HashMap<Integer, Character> hashMap = new HashMap<>();
        HashMap<Integer, Character> hashMap2 = new HashMap<>();
        char[] test = s.toCharArray();
        for (int i = 0; i< test.length; i++) {
            try {
                Integer.parseInt("" + test[i]);
            } catch (NumberFormatException error) {
                System.out.println(i);
                System.out.println(test[i]);
                hashMap.put(i, test[i]);
            }
        }


        char[] test2 = T.toCharArray();
        for (int i = 0; i< test2.length; i++) {
            try {
                Integer.parseInt("" + test2[i]);
            } catch (NumberFormatException error) {
                System.out.println(i);
                System.out.println(test2[i]);
                hashMap2.put(i, test2[i]);
            }
        }
        System.out.println(hashMap.entrySet());
        System.out.println(hashMap2.entrySet());

        Set index = hashMap.keySet();
        Character[] letters = hashMap.values().toArray(new Character[0]);

        System.out.println(index);
        System.out.println(Arrays.toString(letters));
        char[] sResult = new char[getLengthOfArray(s)];
        char[] tResult = new char[getLengthOfArray(T)];

        Arrays.fill(sResult, '1');
        Arrays.fill(tResult, '1');
        for (Map.Entry<Integer, Character> entry : hashMap.entrySet()) {
            sResult[entry.getKey()] = entry.getValue();
        }

        for (Map.Entry<Integer, Character> entry2 : hashMap2.entrySet()) {
            tResult[entry2.getKey()] = entry2.getValue();
        }
        System.out.println(Arrays.toString(sResult));
        System.out.println(Arrays.toString(tResult));

       for (int i = 0; i < sResult.length; i++) {
           if (sResult[i] != '1') {
               if (sResult[i] != tResult[i] && tResult[i] != '1') {
                   System.out.println(tResult[i]);
                   System.out.println(false);
               }
           }
       }
        System.out.println(true);

    }

    static boolean checkOrm(String S, String T) {
        char[] test = S.toCharArray();
        char[] tArray = T.toCharArray();
        int lengthOfS = 0;
        int lengthOfT = 0;
        lengthOfS = getLengthOfArray(S);
        lengthOfT = getLengthOfArray(T);
        if (lengthOfS == lengthOfT) {
            return true;
        }
        return false;
    }
    static int getLengthOfArray(String s) {
        int lengthOfS = 0;
        for (char t : s.toCharArray()) {
            try {
                lengthOfS += Integer.parseInt("" + t);
            } catch (NumberFormatException error) {
                lengthOfS++;
            }
        }
        return lengthOfS;
    }

}