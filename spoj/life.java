import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class life {

    public static int flippingMatrix(List<List<Integer>> matrix) {

        class Node {
            int data;
            Node next;
            Node(int d) {this.data = d; this.next = null;}
        }
        //2n * 2n matrix
        int sizeMatrix = matrix.size();
        int n = sizeMatrix / 2;
        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                max = Integer.MIN_VALUE;
                max = Math.max(
                        matrix.get(i).get(j),
                        max
                );

                max = Math.max(
                        matrix.get(i)
                                .get(2*n - j - 1),
                        max
                );

                max = Math.max(
                        matrix.get(2*n - i - 1)
                                .get(j),
                        max
                );

                max = Math.max(
                        matrix.get(2*n - i - 1)
                                .get(2*n-j-1),
                        max
                );

                sum += max;
            }
        return sum;
    }

    public static String caesarCipher(String s, int k) {
        Character[] alphabets = new Character[]{
                'A','B','C', 'D', 'E', 'F', 'G',
                'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O',
                'P','Q','R','S','T','U','V','W','X','Y','Z'};
        List<Character> alphabetList = Arrays.asList(alphabets);
        System.out.println(alphabetList.size());

        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (Character.isAlphabetic(s.charAt(i))) {
                if (Character.isLowerCase(s.charAt(i))) {
                    int index = alphabetList.indexOf(Character.toUpperCase(s.charAt(i)));
                    if (index + k> 25) {
                        newString.append(Character.toLowerCase(alphabetList.get((index + k) % 26)));
                    } else {
                        newString.append(Character.toLowerCase(alphabetList.get(index + k)));
                    }
                } else {
                    int index = alphabetList.indexOf(s.charAt(i));
                    if (index + k > 25) {
                        newString.append((alphabetList.get((index + k) % 26)));
                    } else {
                        newString.append((alphabetList.get(index + k)));
                    }
                }
            } else {
                newString.append(s.charAt(i));
            }
        }
        return newString.toString();
    }

    public static String gridChallenge(List<String> grid) {
        List<List<Character>> gridList = new ArrayList<>();

        for ( String s : grid) {
            gridList.add(s.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        }

        for (List<Character> row : gridList) {
            Collections.sort(row);
            if (isAscendingOrder(row) == false) {
                return "NO";
            }
        }

        int numRows = gridList.size();
        int numCols = gridList.get(0).size();

        if (numRows == numCols) {
            for (int i = 0; i < gridList.size(); i++)
                for (int j = 0; j + 1<gridList.get(i).size(); j++) {
                    Character current = gridList.get(j).get(i);
                    Character next = gridList.get(j + 1).get(i);
                    if (next < current) {
                        return "NO";
                    }
                }
        } else if (numCols > numRows) {
            System.out.println("greater columns");
            System.out.println(gridList);
            for (int i =0; i < numCols; i++) {
                for (int j = 0; j < numRows; j++) {
                    Character current = gridList.get(j).get(i);
                    Character next = gridList.get(j + 1).get(i);
                    if (next < current) {
                        return "NO";
                    }
                }
            }
        } else {
            System.out.println("greater rows");
            System.out.println(gridList);
            System.out.println("#rows : " +numRows);
            System.out.println("#cols : " +numCols);
            for (int i =0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    if (i < numCols) {
                        Character current = gridList.get(j).get(i);
                        Character next = gridList.get(j+1).get(i);
                        if (next < current) {
                            return "NO";
                        }

                    }
                }
            }
        }
    /*
    [m, p, x, z]
    [a, b, c, d]
    [f, l, m, w]
    */


        return "YES";
    }

    static boolean isAscendingOrder(List<Character> list) {
        List<Character> oldList = list;
        Collections.sort(list);
        if (!oldList.equals(list)) {
            return false;
        } else {
            return true;
        }

    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[adj.size()][adj.size()];
        Arrays.fill(visited, false);
        for (int i = 0; i < adj.size(); i++) {

            for (int j = 0; j < adj.get(i).size(); j++) {
                if (!visited[i][j]) {
                    queue.add(adj.get(i).get(j));
                }
            }
        }

        ArrayList<Integer> bfsResults = new ArrayList<>();
        while (!queue.isEmpty()) {
            bfsResults.add(queue.poll());
        }
        return bfsResults;
    }

    public Node sortedInsert(Node head, int key) {
        Node newNode = new Node(key);
        if (head == null) {
            return newNode;
        }

        if (head.data >= key) {
            newNode.next = head;
            head = newNode;
            return head;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < key) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
            return head;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();

            for (; start <= end; start++) {
                if (isPrime(start)) {
                    System.out.println(start);
                }
            }
        }


    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        if (n <= 3) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
            for (int i = 5; i * i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        return true;
    }
}
