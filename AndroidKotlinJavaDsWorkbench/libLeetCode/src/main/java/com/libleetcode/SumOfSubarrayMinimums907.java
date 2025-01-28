package com.libleetcode;

/*
907. Sum of Subarray Minimums
        Medium
        Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.



        Example 1:

        Input: arr = [3,1,2,4]
        Output: 17
        Explanation:
        Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
        Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
        Sum is 17.
        Example 2:

        Input: arr = [11,81,94,43,3]
        Output: 444


        Constraints:

        1 <= arr.length <= 3 * 104
        1 <= arr[i] <= 3 * 104

*/

import java.lang.reflect.Array;

//monotonic stack along with a prefix some pattern
public class SumOfSubarrayMinimums907 {

    public int min(int[] arr) {
        for(int i = 0; i < arr.length; i++) {

            for(int j = 0; j < arr.length; j++) {
                int[] tempArr = new int[i + 1];
//                tempArr[j]
            }
        }
        return 0;
    }

    public int findMinimumValue(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > temp) {
                temp = arr[i];
            }
        }
        return temp;
    }

}
