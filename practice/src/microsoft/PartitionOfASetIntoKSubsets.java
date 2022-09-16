package microsoft;
/*
Given an integer array of N elements, the task is to divide this array into K non-empty subsets
 such that the sum of elements in every subset is same.
 All elements of this array should be part of exactly one partition.

 Example:
 Input : arr = [2, 1, 4, 5, 6], K = 3
    Output : Yes
    we can divide above array into 3 parts with equal
    sum as [[2, 4], [1, 5], [6]]

    Input  : arr = [2, 1, 5, 5, 6], K = 3
    Output : No
    It is not possible to divide above array into 3
    parts with equal sum

  Solve:
  Recursion
  1.Base cases: K = 1, subset = entire array
  2.if length of n < k, not possible to divide
  3.is sum of array divisible by k?

  subset = sum / K
  int[] subsetSum = new int[K]

 */
public class PartitionOfASetIntoKSubsets {
    public static void main(String[] args) {

    }
}
