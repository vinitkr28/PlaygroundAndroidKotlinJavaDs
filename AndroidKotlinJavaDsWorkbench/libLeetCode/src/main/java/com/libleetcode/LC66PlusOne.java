package com.libleetcode;

import java.util.Arrays;

public class LC66PlusOne {
    public int[] plusOne(int[] digits) {





        int lastIndex = digits.length - 1;
        if (lastIndex == -1) return digits;
        int currentPointer = lastIndex;
        long finalValue = digits[currentPointer--];

        while (currentPointer > -1) {
            finalValue = finalValue + ((long) Math.pow(10, (lastIndex - currentPointer)) * digits[currentPointer]);

            currentPointer--;
        }

        finalValue++;

        int powerOf = (int) Math.pow(10, lastIndex);

        int newArraySize = finalValue / powerOf >= 10 ? digits.length + 1 : digits.length;

        int[] result = new int[newArraySize];
        int resultIndexPointer = result.length - 1;

        int res = (int) (finalValue % 10);
        long quotient = finalValue / 10;
        result[resultIndexPointer] = res;
        resultIndexPointer--;

        while (quotient > 0) {
            result[resultIndexPointer] = (int) quotient % 10;
            quotient = quotient / 10;
            resultIndexPointer--;
        }

        return result;

    }


    public static void main(String[] args) {


        LC66PlusOne plusOne = new LC66PlusOne();

        //int[] digits = new int[]{1,2,3};
        int[] digits = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        //int[] digits = new int[]{8, 9, 9, 9};
        //int[] digits = new int[]{9};

        int[] v = plusOne.plusOne(digits);

        System.out.println(Arrays.toString(v));
    }

}
