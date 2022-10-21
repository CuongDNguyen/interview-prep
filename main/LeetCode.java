import java.util.*;

public class LeetCode {
    public static void main(String[] args) {
        CapitalOneProblems cp = new CapitalOneProblems();
        System.out.println(cp.countPrimes(10));
    }

    static class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
                next = null;
            }
        }

    static class TwoPointerProblems {

        /*Linked Lists (Fast & Slow)*/
        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            if (head == null) return false;

            while (fast != null && fast.next != null) {
                head = head.next;
                fast = fast.next.next;
                if (fast == head) return true;
            }

            return false;
        }

        public ListNode detectCycle(ListNode head) {
            if (head == null) return null;
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    ListNode slow2 = head;
                    while (slow2 != slow) {
                        slow = slow.next;
                        slow2 = slow2.next;
                    }
                    return slow;
                }
            }
            return null;
        }

        public ListNode removeNthFromEnd(ListNode head, int n) {

            if (head == null) return null;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;
            for (int i = 0; i < n + 1; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next;
            return dummy.next;
        }

        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;
            int length = 0;
            for (length = 0; fast.next != null; length++) {
                fast = fast.next;
            }

            for (int j = length - k % length; j > 0 ; j--) //Get the i-n%i th node
                slow = slow.next;

            fast.next = dummy.next;
            dummy.next = slow.next;
            slow.next = null;
            return dummy.next;
        }

        /*
         */
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;
            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;
            ListNode l1 = head;

            while (fast != null && fast.next != null) {
                prev = slow;
                fast = fast.next.next;
                slow = slow.next;
            }

            prev.next = null;

            ListNode l2 = reverse(slow);
            merge(l1, l2);

        }

        ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode current = head;
            ListNode next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            return prev;
        }

        void merge(ListNode l1, ListNode l2) {
            while (l1 != null) {
                ListNode n1 = l1.next;
                ListNode n2 = l2.next;
                l1.next = l2;

                if (n1 == null) break;
                l2.next = n1;
                l1 = n1;
                l2 = n2;
            }
        }
        /*
         */

        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;
            ListNode temp = head;
            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            prev = slow;
            slow = slow.next;
            prev.next = null;
            while (slow != null) {
                temp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = temp;
            }
            fast = head;
            slow = prev;
            while (slow != null) {
                if (fast.val != slow.val) return false;
                fast = fast.next;
                slow = slow.next;
            }
            return true;

        }

        /*
        Merging 2 arrays
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m-1 , p2 = n-1 ,i = m+n-1;
            while(p2 >=0 ){
                if(p1 >=0 && nums1[p1] > nums2[p2]){
                    nums1[i--] = nums1[p1--];
                }
                else{
                    nums1[i--] = nums2[p2--];
                }
            }
        }
    }

    static class SlidingWindowProblems {
        public static void main(String[] args) {
            SlidingWindowProblems slidingWindowProblems = new SlidingWindowProblems();
            slidingWindowProblems.findAnagrams("abcabcabc", "abc");
        }

        /*
        Fixed Sliding Window
         */
        public List<Integer> slidingWindowTemplate(String s, String p) {
            //Result collection
            List<Integer> result = new LinkedList<>();
            if (p.length() > s.length()) return result;

            //HashMap to save Characters of target substring
            //(K, V) = Character, Frequence of the Characters
            Map<Character, Integer> map = new HashMap<>();
            for (char c : p.toCharArray()) {
                map.put(c, map.getOrDefault(c , 0) + 1);
            }

            //counter to check match of target string
            int counter = map.size(); // use map size, because char may be duplicated

            //2 pointers: begin - left of window, end - right of window
            int begin = 0, end = 0;

            //length of target substring
            int len = Integer.MAX_VALUE;
            while (end < s.length()) {
                char c = s.charAt(end);

                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) counter --;
                }
                end--;
                while (counter == 0) {
                    char tempC = s.charAt(begin);
                    if (map.containsKey(tempC)) {
                        map.put(tempC, map.get(tempC) + 1);
                        if (map.get(tempC) > 0) counter++;
                    }
                    begin++;
                }
            }
            return result;
        }
        public int lengthOfLongestSubstring(String s) {
            if (s.length() < 2)
                return s.length();
            int left = 0;
            int right = 0;
            int maxLength = 0;
            HashMap<Character, Integer> map = new HashMap<>();

            while (right < s.length()) {
                char ch = s.charAt(right);

                if (map.containsKey(ch)) {
                    maxLength = Math.max(maxLength, right - left);
                    left = Math.max(left, map.get(ch) + 1);
                }

                map.put(ch, right++);
            }
            return Math.max(maxLength, right - left);
        }

        /*
        Find all anagrams in a string
        Given two strings s and p,  return an array of all the start indices
        of p's anagrams in s. You may return the answer in any order

        Input: s = "cbaebabacd", p = "abc"
        Output: [0,6]

        The substring with start index = 0 is "cba", anagram of abc
        The substring with start index is 6 "bac", anagram of abc
         */
        public List<Integer> findAnagrams(String s, String p) {
           int sLength = s.length();
           int pLength = p.length();

           if (pLength > sLength) return new ArrayList<>();

           Map<Character,Integer> pHashMap = new HashMap<>();
           Map<Character,Integer> sHashMap = new HashMap<>();

           for (char c : p.toCharArray()) {
               pHashMap.put(c, pHashMap.getOrDefault(c, 1) + 1);
           }

           List<Integer> result = new ArrayList<>();

           for (int i = 0; i < sLength; i++)  {
               char ch = s.charAt(i);
               sHashMap.put(ch, sHashMap.getOrDefault(ch, 1) + 1);

               if (i >= pLength) {
                   ch = s.charAt(i - pLength);;
                   if (sHashMap.get(ch) == 1) {
                       sHashMap.remove(ch);
                   } else {
                       sHashMap.put(ch, sHashMap.get(ch) - 1);
                   }
               }

               if (pHashMap.equals(sHashMap)) {
                   result.add(i - pLength + 1);
               }
           }
           return result;
        }
    }

    static class CapitalOneProblems {
        CapitalOneProblems() {}

        /*
        Given an integer n, return the number of prime numbers
        that are strictly less than n.

        The initial thought would be to how to create the function
        isPrime(int n) and loop through each number that is strictly
        less than n.

        O(n), the prime check itself is O(sqrt(n))

        Optimal Approach is Sieves:

         */
        public List<Integer> countPrimes(int n) {
            List<Integer> results = new ArrayList<>();
            if (n <= 2) {
                return results;
            }

            boolean[] numbers = new boolean[n];
            for (int p = 2; p <= (int) Math.sqrt(n); ++p) {
                if (numbers[p] == false) {
                    for (int j = p*p; j < n; j+= p) {
                        numbers[j] = true;
                        System.out.println("j: " + j);
                    }
                }
            }
            for (int i = 2; i < n; i++) {
                if (numbers[i] == false) {
                    results.add(i);
                }
            }
            return results;
        }

        /*
        m x n int matrix: grid
        input: 3 4 5 1 3
               3 3 4 2 3
               20 30 200 40 10
               1 5 5 4 1
               4 3 2 2 5
        output: 228, 216, 211
        Blue: 20 + 3 + 200 + 5 = 228
        Red: 200 + 2 + 10 + 4 = 216
        Green: 5 + 200 + 4 + 2  = 211

        Input: 1 2 3
               4 5 6
               7 8 9

        Output: 20 9 8
        Blue = 4 + 2 + 6 + 8
        Red = 9
        Green = 8

        Input: 7 7 7
        Output: 7
        */
        public int[] getBiggestThree(int[][] grid) {

           int end = Math.min(grid.length, grid[0].length);
           int maxThree[] = {0,0,0};
           return null;
        }

        public char[][] rotateBox(char[][] box) {
            int row = box.length;
            int col = box[0].length;

            char[][] rotatedBox = new char[col][row];

            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++) {
                    rotatedBox[j][i] = box[row-1-i][j];
                }

            for (int i = col - 1; i >= 0; i--)
                for (int j = 0; j < row; j++) {
                    if (rotatedBox[i][j] == '#') {
                        int curRow = i;
                        while (curRow+1 < col && rotatedBox[curRow+1][j] == '.') {
                            curRow++;
                        }
                        if (curRow != i) {
                            rotatedBox[curRow][j] = '#';
                            rotatedBox[i][j] = '.';
                        }
                    }
                }

            return rotatedBox;
        }

        public int[][] candyCrush(int[][] board) {
            int R = board.length, C = board[0].length;
            boolean todo = false;
            for (int r = 0; r < R; ++r) {
                for (int c = 0; c + 2 < C; ++c) {
                    int v = Math.abs(board[r][c]);
                    if (v != 0 && v == Math.abs(board[r][c+1]) && v == Math.abs(board[r][c+2])) {
                        board[r][c] = board[r][c+1] = board[r][c+2] = -v;
                        todo = true;
                    }
                }
            }
            for (int r = 0; r + 2 < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    int v = Math.abs(board[r][c]);
                    if (v != 0 && v == Math.abs(board[r+1][c]) && v == Math.abs(board[r+2][c])) {
                        board[r][c] = board[r+1][c] = board[r+2][c] = -v;
                        todo = true;
                    }
                }
            }

            for (int c = 0; c < C; ++c) {
                int wr = R - 1;
                for (int r = R-1; r >= 0; --r)
                    if (board[r][c] > 0)
                        board[wr--][c] = board[r][c];
                while (wr >= 0)
                    board[wr--][c] = 0;
            }

            return todo ? candyCrush(board) : board;
        }
    }

    static class BinarySearchProblems {
        public static void main(String[] args) {
            BinarySearchProblems binarySearchProblems = new BinarySearchProblems();
            int[] test = new int[]{1,2,3,4,5,6,7};
            System.out.println(binarySearchProblems.generalBinarySearch(test, 4));
        }
        int generalBinarySearch(int[] array, int target) {
            int left = 0;
            int right = array.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (array[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
