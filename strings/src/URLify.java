import java.util.Arrays;

/*
URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: "Mr 3ohn Smit h 13
Output: "Mr%203ohn%20Smith"

Brute Force Solution:
get index of all the spaces
place %20 into those index
 */
public class URLify {
    public static void main(String[] args) {
        replaceSpacesMyAttempt("Mr 3ohn Smith", 17);
    }

    static void replaceSpacesMyAttempt(String str, int trueLength) {
        char[] strCharArray = str.toCharArray();
        char[] trueCharArray = new char[trueLength];
        int j = 0;
        for (int i = 0; i < trueLength; i++) {
            if (strCharArray[j] == ' ') {
                trueCharArray[i] = '%';
                trueCharArray[i+1] = '2';
                trueCharArray[i+2] = '0';
                i = i + 2;
                j++;
            } else {
                trueCharArray[i] = strCharArray[j];
                j++;
            }
        }
        System.out.println(Arrays.toString(trueCharArray));
    }
}
