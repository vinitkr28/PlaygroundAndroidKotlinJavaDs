package com.libjavapractice.dsa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DsaPractice {


    public static String solutions(int n) {
        int[] intArr = new int[n];
        Arrays.fill(intArr, 1);

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(1);
        }

        System.out.println("intArray: " + Arrays.toString(intArr) + "\n");
        System.out.println("list: " + list + "\n");

        charTransformation(intArr);
        charTransformation(list);

        return null;
    }

    private static List<Integer> charTransformation(List<Integer> list) {
        List<Integer> transformedList = new LinkedList<>();

        for (int i =0;i<list.size();) {


            if (i < list.size()-1 && list.get(i) == list.get(i+1)){
                transformedList.add(list.get(i) + 1);
                i += 2;
                if (i >= (list.size() - 1)) i -= 1;
            } else {
                i++;
            }
        }

        System.out.println("transformedList:" + transformedList);

        return null;
    }

    private static int[] charTransformation(int[] arr) {

//        for(int i = 0; i < arr-1;) {
//            if(arr[i] == arr[i+1])
//        }

        return arr;
    }

    public static void main(String[] args) {
        solutions(11);
    }
}
