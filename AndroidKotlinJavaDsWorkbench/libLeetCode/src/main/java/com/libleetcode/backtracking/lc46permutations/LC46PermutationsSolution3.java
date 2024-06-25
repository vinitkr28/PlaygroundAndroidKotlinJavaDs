package com.libleetcode.backtracking.lc46permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC46PermutationsSolution3 {
    public List<List<Integer>> permute(Integer[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

//        backtrack(resultList, new ArrayList<>(), nums);
//        backtrack2(resultList, new ArrayList<>(), nums);
        backtrack3(resultList, new ArrayList<>(), nums);

        return resultList;
    }


    private void backtrack3(List<List<Integer>> resultList, List<Integer> tempList, Integer[] nums) {
        if (nums.length == 0) {
            resultList.add(tempList);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            Integer[] newList = new Integer[nums.length - 1];
            int currIndex = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j)
                    newList[currIndex++] = nums[j];
            }

            List<Integer> newTempList = new ArrayList<>(tempList);
            newTempList.add(currNum);
            backtrack3(resultList, newTempList, newList);
//            tempList.remove(tempList.size()-1);
        }
    }

    private void backtrack2(List<List<Integer>> resultList, List<Integer> tempList, Integer[] nums) {
        if (nums.length == 0) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            Integer[] newList = new Integer[nums.length - 1];
            int currIndex = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j)
                    newList[currIndex++] = nums[j];
            }

            tempList.add(currNum);
            backtrack2(resultList, tempList, newList);
            tempList.remove(tempList.size()-1);
        }
    }



    private void backtrack(List<List<Integer>> resultList, List<Integer> tempList, Integer[] nums) {
        //https://www.youtube.com/watch?v=H232aocj7bQ
        if (tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (Integer num : nums) {
            if (tempList.contains(num))
                continue;

            tempList.add(num);
            backtrack(resultList, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static void main(String[] args) {
        LC46PermutationsSolution3 solution = new LC46PermutationsSolution3();
//        List<List<Integer>> output = solution.permute(new Integer[]{0, 1});
        List<List<Integer>> output = solution.permute(new Integer[]{1, 2, 3});

        System.out.println(output);
    }

}
