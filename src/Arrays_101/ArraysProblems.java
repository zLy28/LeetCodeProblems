package Arrays_101;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysProblems {
    @Test
    public void test() {
     
    }
//    Given a binary array, find the maximum number of consecutive 1s in this array.
//    Input: [1,1,0,1,1,1]
//    Output: 3
//    Explanation: The first two digits or the last three digits are consecutive 1s.
//    The maximum number of consecutive 1s is 3.
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = 0;
        int max = 0;
        ArrayList<Integer> windows = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                length += 1;
            }

            if (length > max) {
                max = length;
            }

            if (nums[i] == 0) {
                length = 0;
            }
        }
        return max;
    }

//    Given an array nums of integers, return how many of them contain an even number of digits.
//
//
//    Example 1:
//
//    Input: nums = [12,345,2,6,7896]
//    Output: 2
//    Explanation:
//            12 contains 2 digits (even number of digits).
//            345 contains 3 digits (odd number of digits).
//            2 contains 1 digit (odd number of digits).
//            6 contains 1 digit (odd number of digits).
//            7896 contains 4 digits (even number of digits).
//    Therefore only 12 and 7896 contain an even number of digits.
//
//    Constraints:
//
//            1 <= nums.length <= 500
//            1 <= nums[i] <= 10^5
//
//    Sample Solution from LeetCode (1ms runtime):
//    class Solution {
//        public int findNumbers(int[] nums) {
//            int count=0;
//            for(int i=0;i<nums.length;i++)
//            {
//                count=String.valueOf(nums[i]).length()%2==0 ? ++count :count;
//            }
//            return count;
//        }
//    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int digits = findDigits(nums[i]);
            if (digits % 2 == 0) {
                count += 1;
            }
        }
        return count;
    }

    public int findDigits(int i) {
        int digits = 1;
        while (i / 10 != 0) {
            i = i / 10;
            digits += 1;
        }
        return digits;
    }

//    Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
//
//
//
//    Example 1:
//
//    Input: [-4,-1,0,3,10]
//    Output: [0,1,9,16,100]
//    Example 2:
//
//    Input: [-7,-3,2,3,11]
//    Output: [4,9,9,49,121]
//
//
//    Note:
//
//            1 <= A.length <= 10000
//            -10000 <= A[i] <= 10000
//    A is sorted in non-decreasing order.

    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i] * A[i];
        }
        Arrays.sort(B);
        return B;
    }
}
