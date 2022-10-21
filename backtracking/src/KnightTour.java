/*
Given a N*N board with the Knight placed on the first block of an empty board.
Moving according to the rules of chess knight must visit each square exactly once.
Print the order of each cell in which they are visited.

Example:
Input :
N = 8
Output:
0  59  38  33  30  17   8  63
37  34  31  60   9  62  29  16
58   1  36  39  32  27  18   7
35  48  41  26  61  10  15  28
42  57   2  49  40  23   6  19
47  50  45  54  25  20  11  14
56  43  52   3  22  13  24   5
51  46  55  44  53   4  21  12
 */
public class KnightTour {
    static int sizeMatrix;

    //Inside the length of the array for i and j, also hasn't been visited
    static boolean validIndex(int i, int j, int[][] array) {
        return (i >= 0 && i < sizeMatrix &&
                j >= 0 && j < sizeMatrix &&
                array[i][j] == -1);
    }

    static boolean knightTour(int n) {
        sizeMatrix = n;
        int sol[][] = new int[sizeMatrix][sizeMatrix];

        //Make initial matrix all -1 for not visited
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                sol[i][j] = -1;
            }
        }

        //Knight moves
        int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1};

        //Knight start
        sol[0][0] = 0;

        //Traverse through matrix
        if (!knightUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("No solution");
            return false;
        } else {
            for (int i = 0; i < sizeMatrix; i++) {
                for (int j = 0; j < sizeMatrix; j++) {
                    System.out.print(sol[i][j] + " ");
                    System.out.println();
                }
            }
        }

        return true;
    }

    static boolean knightUtil(int i, int j, int movei, int[][] sol, int[] xMove, int[] yMove) {
        int k, next_x, next_y;
        if (movei == sizeMatrix * sizeMatrix) {
            return true;
        }

        for ( k = 0; k < sizeMatrix; k++) {
            next_x = i + xMove[k];
            next_y = i + yMove[k];
            if (validIndex(next_x, next_x, sol)) {
                sol[next_x][next_y] = movei;
                if (knightUtil(next_x, next_y, movei + 1, sol, xMove, yMove)) {
                    return true;
                } else {
                    sol[next_x][next_y] = -1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        knightTour(8);
    }
}
