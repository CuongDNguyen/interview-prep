import java.util.Arrays;

public class JavaAlgorithms {
    public static void main(String[] args) {
        JavaAlgorithms main = new JavaAlgorithms();
        /*
        int sumOfDigits =
                main.sumOfDigits(54);

        System.out.println(sumOfDigits);

        int powerResult = main.power(2, 2);
        System.out.println(powerResult);

        int gcd = main.gcd(8, 4);
        System.out.println(gcd);

        int binary = main.decimalToBinary(13);
        System.out.println(binary);

        int[] intArray = new int[100];
            for (int i = 0; i < intArray.length; i++) {
                if (i + 1 == 73) {
                    continue;
                }
                intArray[i] = i + 1;
            }
        int missingNumber = main.missingNumber(intArray, intArray.length);
        System.out.println(missingNumber);

        int[] num = {2,7,11,15};
        int target = 26;
        int[] pairs = main.twoSums(num, target);
        System.out.println(Arrays.toString(pairs));

        int[] num = {2,7,11,15};
        int searchIndex = main.searchInArray(num, 15);
        System.out.println(searchIndex);

        int[] num = {2,7,11,15};
        int maxProduct = main.maxProductInTwoArrays(num);
        System.out.println(maxProduct);

        int[] num = {2,7,11,15,15};
        boolean isUnique = main.isArrayUnique(num);
        System.out.println(isUnique);

        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {5,4,3,2,1};
        boolean isPermutation = main.isArrayPermutation(nums1, nums2);
        System.out.println(isPermutation);
         */

    }

    /*How to find the sum of digits of a positive integer number using recursion?

    Recursive case - the flow

    10 10/10 = 1 and remainder = 0
    54 54/10 = 5 and remainder = 4
    112 /10 = 11 and remainder = 2
    11 / 10 = 1 and remainder = 1
    f(n) = n%10 + f(n/10);

    Base case - stopping criterion:
    n == 0

    Unintentional case - the constraint
    sumOfDigits(-11)
    sumOfDigits(1.5)
    */
    public int sumOfDigits(int n) {
        if (n == 0 || n < 0) {
            return 0;
        }
        return n % 10 + sumOfDigits(n/10);
    }

    /*
How to calculate power of a number using recursion?
Recursive case - the flow
xn = x*x*x*X
xn = x * xn -1
n=0
n=1


  */

    public int power(int base, int exp) {
        if (exp < 0) {
            return -1;
        }
        if (exp == 0) {
            return 1;
        }
        return base * power(base, exp - 1);
    }

    /*
  gcd is the largest positive integer that divdes the numbers without a remainder
    gcd(8,12) = 4
    8 = 2 * 2 * 2
    12 = 2 * 2 * 3

    Euclidean algorithm
    gcd(48,18)
    48/18 = 2 remainder 12
    18/12 = 1 remainder 6
    12/6 = 2 remainder 0

    gcd(a,0) = a
    gcd(a, b) = gcd(b, a mod b)

    base case = b == 0

    unintentional constraint, negative numbers
  */
    public int gcd(int a, int b) {
        if (b < 0 || a < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /*
    How to convert a number from decimal to binary using recursion

    Recursive case
    Divide number by 2
    Get integer quotient from next iteration
    Get remainder for binary digit
    Repeat until quotient is 0


     */
    public int decimalToBinary(int n) {
        if ( n == 0) {
            return 0;
        }
        return n % 2 + 10 * decimalToBinary(n / 2);
    }

    /*Find the missing number in an integer array of 1 to 10*/
    public int missingNumber(int[] intArray, int lengthArray) {
       int sum1 = 0;
       int sum2 = 0;

       for (int i : intArray) {
           sum1 += i;
       }

       sum2 = lengthArray * (lengthArray + 1) / 2;
       int difference = sum2 - sum1;
       return difference;
    }

    /*
    Find all pair of integers whose sum = given number
    input: nums = 2,7,11,15 target = 9
    output: [0,1]
    */
    public int[] twoSums(int[]nums, int target){

        for(int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
               if(nums[i] + nums[j] == target) {
                   return new int[] {i , j};
               }
            }
        }
        throw new IllegalArgumentException("No solution found.");
    }

    /*
    Finding a number in an array
     */
    public int searchInArray(int[] intArray, int valueToSearch) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == valueToSearch) {
                return i;
            }
        }
        return -1;
    }

    /*
    Max product of two integers where all elements are positive
    */
    public int maxProductInTwoArrays(int[] nums) {
        int maxProduct = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] * nums[j] > maxProduct) {
                    maxProduct = nums[i] * nums[j];
                }
            }
        }
        return maxProduct;
    }

    /*
    Array is unique
     */
    public boolean isArrayUnique(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return false;
                }
            }
        return true;
    }

    /*
    Permutation of 2 arrays
     */
    public boolean isArrayPermutation(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (Arrays.equals(nums1, nums2)) return true;
        return false;
    }
}
