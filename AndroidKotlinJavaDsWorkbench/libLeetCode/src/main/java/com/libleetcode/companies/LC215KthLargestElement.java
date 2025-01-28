package com.libleetcode.companies;

import java.util.Arrays;

//https://leetcode.com/problems/kth-largest-element-in-an-array/

public class LC215KthLargestElement {

    private void divide(int[] arr, int si, int ei) {
        if (si >= ei) return;

        int mid = si + (ei - si) / 2;

        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);

    }

    private void conquer(int[] arr, int si, int mid, int ei) {

        int[] merged = new int[ei - si + 1];

        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public int kthLargestElementWithMergeSort(int[] arr, int k) {
        int result = -1;
        int n = arr.length;
        divide(arr, 0, n-1);

        System.out.println(Arrays.toString(arr));

        if (n > k) {
            result = arr[n-k];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] input1 = {3,2,1,5,6,4};

        int k1 = 2;

        int[] input2 = {3,2,3,1,2,4,5,5,6};
        int k2 = 4;

        LC215KthLargestElement kthLargestElement = new LC215KthLargestElement();


        int output = kthLargestElement.kthLargestElementWithMergeSort(input1, k1);

        System.out.println("output:\t" + output);
    }
}
