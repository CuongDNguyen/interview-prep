/*
Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells are "off limits" such that
the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
the bottom right.

Example:
            -1  1 -1 -1 -1 -1 -1
            -1 -1 -1 -1 1 -1 -1
            -1 -1 1 -1 -1 -1 -1
            -1 -1 1 -1 -1 -1 -1

Brute Force Solution:
BFS
down all the way then to the right works? no
Recurrence Relation:
2 x 2, if you go to the right and it hits cant step, go down instead and then right
arr[0][0] -> arr[0][1], then go arr[1][0]
continue until arr[r-1][c-1] is reached by robot
 */
public class RobotInAGrid {
    public static void main(String[] args) {

    }

    void robotGo(int[][] grid) {

    }

    private void robotGo(int[][] grid, int row, int column) {

    }
}
