package com.libleetcode.backtracking.lc46permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC46PermutationsSolution2 {
    public List<List<Integer>> permute(Integer[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        /*
        int[] newNum = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            newNum[i] =
        }
        */

        //printPermute(nums, new int[nums.legth], 0, 0, output]);

        List<Integer> input = Arrays.asList(nums);
        List<Integer> input2 = new LinkedList<>();
        for (int i = 0; i < nums.length;i++){
            input2.add(nums[i]);
        }

//        backtrack(input2, new ArrayList<>(), 0, output);
        backtrack(input2, new LinkedList<>(), 0, output);

        return output;
    }

    private void printPermute(Integer[] nums, Integer[] newNums, int idx, int ctr, List<List<Integer>> output) {

        if(ctr == nums.length-1) {
            output.add(Arrays.asList(newNums));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int currChar = nums[i];


        }

    }

    private void backtrack2(List<Integer> nums, List<Integer> param, int idx, List<List<Integer>> output) {
        if(nums.isEmpty()) {
            System.out.println(param);
//            output.add(param);
            return;
        }

        for(int i = 0; i < nums.size(); i++) {
            int currNum = nums.get(i);
            List<Integer> newList = new ArrayList<>();
            for(int j = 0; j < nums.size(); j++) {
                if(i != j)
                    newList.add(nums.get(j));
            }

            param.add(currNum);

            backtrack(newList, param, idx+1, output);
        }
    }


    private void backtrack(List<Integer> nums, List<Integer> param, int idx, List<List<Integer>> output) {
        if(nums.isEmpty()) {
            System.out.println(param);
            param.clear();
//            output.add(param);
            return;
        }

        for(int i = 0; i < nums.size(); i++) {
            int currNum = nums.get(i);
            List<Integer> newList = new ArrayList<>();
            for(int j = 0; j < nums.size(); j++) {
                if(i != j)
                    newList.add(nums.get(j));
            }

            param.add(currNum);

            backtrack(newList, param, idx+1, output);
        }
    }

    public static void main(String[] args) {
        LC46PermutationsSolution2 solution2 = new LC46PermutationsSolution2();
        List<List<Integer>> output = solution2.permute(new Integer[]{1,2,3});

        System.out.println(output);
    }

}
