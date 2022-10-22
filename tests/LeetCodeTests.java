import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.*;

public class LeetCodeTests {

    @Test
    public void testGetThreeRhombusSumsInAGrid() {
        int[][] testGrid1 = new int[][]
                {
                        { 3,   4,   5,   1,   3},
                        { 3,   3,   4,   2 ,  3},
                        { 20,  30,  200, 40,  10},
                        { 1,   5,   5,   4,   1},
                        { 4,   3,   2,   2,   5}};
        /*
        Blue: 20 + 3 + 200 + 5
        Red: 200 + 2 + 10 + 4
        Green: 5 + 200 + 4 + 2
         */
        int[] expectedGrid1 = new int[]{228, 216, 211};
        int[] resultGrid1 = getThreeRhombusSumsInAGrid(testGrid1);

        int[][] testGrid2 = new int[][]
                {   {1,2,3},
                    {4,5,6},
                    {7,8,9}  };
        /*
        Blue: 4 + 2 + 6 + 8
        Red: 9
        Green: 8
         */
        int[] expectedGrid2 = new int[]{20,9,8};
        int[] resultGrid2 = getThreeRhombusSumsInAGrid(testGrid2);
        assertArrayEquals(resultGrid1, expectedGrid1);
        assertArrayEquals(resultGrid2, expectedGrid2);
    }

    public int[] getThreeRhombusSumsInAGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxLength = (Math.min(m, n) + 1) / 2; //maxLength of Rhombus
        TreeSet<Integer> ans = new TreeSet<>( (x, y) -> y - x);

        for (int len = 0; len < maxLength; len++)
            for (int i = 0; i < m - 2*len; i++)
                for (int j = 0 + len; j < n - len; j++) {
                    int current = grid[i][j];
                    for (int k = 1; k < 2*len; k++) {
                        if (k <= len) {
                            current += grid[i+k][j-k] + grid[i+k][j+k];
                        } else {
                            current += grid[i+k][j-(2*len-k)] + grid[i+k][j+(2*len-k)];
                        }
                    }

                    current += len == 0 ? 0 : grid[i + 2*len][j];
                    ans.add(current);
                    if (ans.size() > 3) {
                        ans.pollLast();
                    }
                }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void testCountPrimes() {
        int testNum1 = 10;
        int expectedNum1 = 4;
        /*
        4 prime numbers less than 10: 2, 3, 5, 7
         */
        int resultNum1 = countPrimes(testNum1);
        assertEquals(resultNum1, expectedNum1);

        int testNum2 = 0;
        int expectedNum2 = 0;
        int resultNum2 = countPrimes(testNum2);
        assertEquals(resultNum2, expectedNum2);

        int testNum3 = 1;
        int expectedNum3 = 0;
        int resultNum3 = countPrimes(testNum3);
        assertEquals(expectedNum3, resultNum3);
    }

    public int countPrimes(int num) {
        if (num <= 2) {
            return 0;
        }

        boolean[] numbers = new boolean[num];
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (numbers[i] == false) {
                for (int j = i * i; j < num; j += i) {
                    numbers[j] = true;
                }
            }
        }

        int numberOfPrimes = 0;
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] == false) numberOfPrimes++;
        }
        return numberOfPrimes;
    }

    @Test
    public void testRotateTheBox() {
        char[][] box1 = new char[][]{
                {'#','.','#'}};
        char[][] expectedBox1 = new char[][]{
                {'.'},
                {'#'},
                {'#'}};
        char[][] resultBox1 = rotateTheBox(box1);
        assertArrayEquals(expectedBox1, resultBox1);

        char[][] box2 = new char[][]{
                {'#','.','*','.'},
                {'#','#','*','.'}};
        char[][] expectedBox2 = new char[][]{
                {'#','.'},
                {'#','#'},
                {'*','*'},
                {'.','.'}};
        char[][] resultBox2 = rotateTheBox(box2);
        assertArrayEquals(expectedBox2, resultBox2);

        char[][] box3 = new char[][]{
                {'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}
        };

        char[][] expectedBox3 = new char[][] {
                {'.','#','#'},
                {'.','#','#'},
                {'#','#','*'},
                {'#','*','.'},
                {'#','.','*'},
                {'#','.','.'}
        };
        char[][] resultBox3 = rotateTheBox(box3);
        assertArrayEquals(resultBox3, expectedBox3);
    }

    public char[][] rotateTheBox(char[][] box) {
        //rotate the matrix 90 degrees
        //drop the stones in the box to obstacle or the end

        int row = box.length;
        int col = box[0].length;
        char[][] rotatedBox = new char[col][row];

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                rotatedBox[j][i] = box[row - i - 1][j];
            }

        for (int i = col - 1; i >= 0; i--)
            for (int j = 0; j < row; j++) {
                if (rotatedBox[i][j] == '#') {
                    int currentRow = i;
                    while (currentRow + 1 < col && rotatedBox[currentRow + 1][j] == '.') {
                        currentRow++;
                    }
                    if (currentRow != i) {
                        rotatedBox[currentRow][j] = '#';
                        rotatedBox[i][j] = '.';
                    }
                }
            }

        return rotatedBox;
    }

    @Test
    public void testTextJustification() {
        String[] testWords1 = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int testMaxWidth1 = 16;
        List<String> expectedWords1 = Arrays.asList("This    is    an",
                "example  of text",
                "justification.  ");
        List<String> resultWords1 = textJustification(testWords1, testMaxWidth1);
        assertEquals(resultWords1, expectedWords1);

        String[] testWords2 = new String[]{"What","must","be","acknowledgment","shall","be"};
        int testMaxWidth2 = 16;
        List<String> expectedWords2 = Arrays.asList("What   must   be",
                "acknowledgment  ",
                "shall be        ");
        List<String> resultWords2 = textJustification(testWords2, testMaxWidth2);
        assertEquals(expectedWords2, resultWords2);

        String[] testWords3 = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int testMaxWidth3 = 20;
        List<String> expectedWords3 = Arrays.asList("Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  ");
        List<String> resultWords3 = textJustification(testWords3, testMaxWidth3);
        assertEquals(resultWords3, expectedWords3);
    }

    public List<String> textJustification(String[] words, int testMaxWidth) {
        //left being the first word
        //findRight go far as right as possible until fill current line
        //justify one line at a time
        //justify, pad right side with spaces until we reach max width
        int left = 0;
        List<String> result = new ArrayList<>();

        while (left < words.length) {
            int right = findRight(left, words, testMaxWidth);
            result.add(justify(left, right, words, testMaxWidth));
            left = right + 1;
        }
        return result;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();

        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth) {
            sum += 1 + words[right++].length();
        }
        return right - 1;
    }

    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) return padResult(words[left], maxWidth);

        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);

        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;

        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++) result.append(words[i])
                .append(space)
                .append(remainder-- > 0 ? " " : "");

        return padResult(result.toString().trim(), maxWidth);
    }

    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) {
            wordsLength += words[i].length();
        }
        return wordsLength;
    }

    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }

    @Test
    public void testTwoSumLessThanK() {
        int[] testNums1 = new int[]{34,23,1,24,75,33,54,8};
        int testK1 = 60;
        int expected1 = 58;
        int result1 = twoSumLessThanK(testNums1, testK1);
        assertEquals(result1, expected1);

        int[] testNums2 = new int[] {10,20,30};
        int testK2 = 15;
        int expected2 = -1;
        int result2 = twoSumLessThanK(testNums2, testK2);
        assertEquals(result2, expected2);
    }

    public int twoSumLessThanK(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            int number = nums[i];
            hashMap.put(number, index);
        }

        int maxSum = -1;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < k) {
                maxSum = Math.max(nums[left] + nums[right], maxSum);
                left++;
            }

            if (nums[left] + nums[right] > k) {
                right--;
            }
        }
        return maxSum;
    }

    @Test
    public void testMeetingScheduler() {
        int[][] testSlots1One = new int[][]{
                {10, 50},
                {60, 120}};
        int[][] testSlots2One = new int[][]{
                {0,15},
                {60,70}};
        int testDuration1 = 8;
        List<Integer> expected1 = Arrays.asList(60, 68);
        List<Integer> result1 = meetingScheduler(testSlots1One, testSlots2One, testDuration1);
        assertEquals(result1, expected1);

        int[][] testSlots1Two = new int[][]{
                {10,50},
                {60,120},
                {140,210}
        };
        int[][] testSlots2Two = new int[][]{
                {0,15},
                {60,70}
        };
        int testDuration2 = 12;
        List<Integer> expectedOutput2 = new ArrayList<>();
        List<Integer> resultOutput2 = meetingScheduler(testSlots1Two, testSlots2Two, testDuration2);
        assertEquals(expectedOutput2, resultOutput2);

    }

    public List<Integer> meetingScheduler(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int pointer1 = 0;
        int pointer2 = 0;
        while(pointer1 < slots1.length && pointer2 < slots2.length) {
            int intersectLeft = Math.max(slots1[pointer1][0], slots2[pointer2][0]);
            int intersectRight = Math.min(slots1[pointer1][1], slots2[pointer2][1]);

            if (intersectRight - intersectLeft >= duration) {
                return new ArrayList<>(Arrays.asList(intersectLeft, intersectLeft + duration));
            }

            if (slots1[pointer1][1] < slots2[pointer2][1]) {
                pointer1++;
            } else {
                pointer2++;
            }
        }
        return new ArrayList<>();
    }
}
