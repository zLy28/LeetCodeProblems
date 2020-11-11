package Arrays_101;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysProblems {
    @Test
    public void test() {
        int[] a = new int[]{0,1,2,2,3,0,4,2};
        int i = removeElement(a, 2);
        System.out.println(i);

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


//    Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
//
//        Note that elements beyond the length of the original array are not written.
//
//        Do the above modifications to the input array in place, do not return anything from your function.
//        Example 1:
//        Input: [1,0,2,3,0,4,5,0]
//        Output: null
//        Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

//        Example 2:
//        Input: [1,2,3]
//        Output: null
//        Explanation: After calling your function, the input array is modified to: [1,2,3]
//
//        Note:
//        1 <= arr.length <= 10000
//        0 <= arr[i] <= 9
    public void duplicateZeros(int[] arr) {
        int dups = 0;
        int length_ = arr.length - 1;
        
        //find 0s needed to duplicate
        for (int left = 0; left <= length_-dups; left++) {
            if (arr[left] == 0) {
                //find the edge situations: 0 on the boundaries
                if (left == length_ - dups) {
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                dups++;
            }
        }
        
        //assign values from the right to the left
        int last = length_ - dups;
        for (int i = last; i >=0 ; i--) {
            if (arr[i] == 0) {
                arr[i + dups] = 0;
                dups -= 1;
                arr[i + dups] = 0;
            } else {
                arr[i + dups] = arr[i];
            }
        }
    }

//    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//            Note:
//
//    The number of elements initialized in nums1 and nums2 are m and n respectively.
//    You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
//    Example:
//
//    Input:
//    nums1 = [1,2,3,0,0,0], m = 3
//    nums2 = [2,5,6],       n = 3
//
//    Output: [1,2,2,3,5,6]
//
//
//    Constraints:
//
//            -10^9 <= nums1[i], nums2[i] <= 10^9
//    nums1.length == m + n
//    nums2.length == n

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i]=nums2[i];
        }

        Arrays.sort(nums1);
    }

//    Given an array nums and a value val, remove all instances of that value in-place and return the new length.
//
//    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
//    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
//    Example 1:
//
//    Input: nums = [3,2,2,3], val = 3
//    Output: 2, nums = [2,2]
//    Explanation: Your function should return length = 2, with the first two elements of nums being 2.
//    It doesn't matter what you leave beyond the returned length. For example if you return 2 with nums = [2,2,3,3]
//    or nums = [2,3,0,0], your answer will be accepted.
    public int removeElement(int[] nums, int val) {
        int numOfDel = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==val) {
                nums[i] = -1;
            }
        }

        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] == -1) {
                numOfDel++;
            }

            if (nums[i] != -1) {
                nums[index] = nums[i];
                index++;
            }
        }

        return nums.length-numOfDel;
    }

//    Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns
//    the new length.
//
//    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
//    extra memory.
//
//    Example 1:
//
//    Input: nums = [1,1,2]
//    Output: 2, nums = [1,2]
//    Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
//    It doesn't matter what you leave beyond the returned length.
    public int removeDuplicates(int[] nums) {
        int uniqueNum = 0;
        if (nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[uniqueNum]) {
                uniqueNum++;
                nums[uniqueNum] = nums[i];
            }
        }
        return uniqueNum+1;
    }

//    Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
//
//    More formally check if there exists two indices i and j such that :
//
//    i != j
//    0 <= i, j < arr.length
//    arr[i] == 2 * arr[j]
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] == 2 * arr[i] || 2 * arr[j] == arr[i]) {
                    return true;
                }
            }
        }
        return false;
    }

//    Given an array of integers arr, return true if and only if it is a valid mountain array.
//
//    Recall that arr is a mountain array if and only if:
//
//    arr.length >= 3
//    There exists some i with 0 < i < arr.length - 1 such that:
//    arr[0] < arr[1] < ... < arr[i - 1] < A[i]
//    arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

    public boolean validMountainArray(int[] arr) {
        int max = 0;
        int index = 0;
        if (arr.length < 3) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        if (index == arr.length - 1 || index == 0) {
            return false;
        }
        for (int i = 0; i < index; i++) {
            if (arr[i] >= arr[i+1]) {
                return false;
            }
        }
        for (int i = index; i < arr.length-1; i++) {
            if (arr[i] <= arr[i+1]) {
                return false;
            }
        }
        return true;
    }


//    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//
//    Return the running sum of nums.
//    Input: nums = [1,2,3,4]
//    Output: [1,3,6,10]
//    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
    public int[] runningSum(int[] nums) {
        int[] nums2 = new int[nums.length];
        int sum = 0;
        for (int i = 0; i <nums2.length ; i++) {
            sum += nums[i];
            nums2[i] = sum;
        }
        return nums2;
    }

}