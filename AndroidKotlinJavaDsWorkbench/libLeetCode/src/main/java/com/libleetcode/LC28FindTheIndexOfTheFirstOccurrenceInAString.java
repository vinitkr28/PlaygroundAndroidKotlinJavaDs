package com.libleetcode;

public class LC28FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {

        String[] a = haystack.split(needle);

        if(a[0].length() == haystack.length()) return -1;

        return a[0].length();
    }

    public static void main(String[] args) {
        LC28FindTheIndexOfTheFirstOccurrenceInAString string = new LC28FindTheIndexOfTheFirstOccurrenceInAString();


        int value = string.strStr("leetcode", "leetcode");

        System.out.println(value);
    }
}
