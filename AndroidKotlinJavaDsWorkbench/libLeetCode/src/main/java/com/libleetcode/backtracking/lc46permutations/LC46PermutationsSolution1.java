package com.libleetcode.backtracking.lc46permutations;

import java.util.List;

public class LC46PermutationsSolution1 {
    public static void printPermutation(String str, int idx, String perm) {
        if(str.isEmpty()) {
            System.out.println(perm);
            return;
        }

        for(int i=0; i<str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);

            printPermutation(newStr, idx+1, perm+currChar);
        }
    }


    public static void main(String[] args) {
        String str = "abc";
        printPermutation(str, 0, "");
    }

}
