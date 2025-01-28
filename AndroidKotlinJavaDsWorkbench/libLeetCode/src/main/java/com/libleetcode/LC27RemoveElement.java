package com.libleetcode;

import java.util.Arrays;

public class LC27RemoveElement {


    public int removeElement(int[] nums, int val) {
        int arraySize = nums.length;
        int lastPointer = arraySize;
        int firstPointer = 0;

        while (firstPointer != lastPointer) {
            if (nums[firstPointer] == val) {
                nums[firstPointer] = nums[lastPointer - 1];
                nums[lastPointer - 1] = val;
                lastPointer--;
                System.out.println(Arrays.toString(nums));
            } else {
                firstPointer ++;
            }
        }

        System.out.println("1. " + Arrays.toString(nums));
        return lastPointer;
    }


    public int removeElement2(int[] nums, int val) {
        int arraySize = nums.length;
        int pointer = 0;

        for(int i = 0; i < arraySize; i++) {
            if(nums[i] != val) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }


        return pointer;
    }


    public static void main(String[] args) {
        LC27RemoveElement element = new LC27RemoveElement();

        int[] nums = new int[]{3, 2, 2, 3};

        int result = element.removeElement(nums, 3);

        System.out.println("result: " + result);
        System.out.println("2. " + Arrays.toString(nums));
    }
}


