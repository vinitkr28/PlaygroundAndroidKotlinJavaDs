package com.libjavapractice.shorting.mergesort;

import java.util.Arrays;
import java.util.List;

public class MergeSortMain {

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        MergeSort mergeSort = new MergeSort();
        mergeSort.divide(arr, 0, n-1);

        //System.out.println(List.of(arr));
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.deepToString(arr));
    }
}
