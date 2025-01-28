package com.libleetcode;


import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
*
*
* Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a
*
* */
public class LC003LongestSubstringWithoutRepeatingChar {

    //Brute Force Solution
    public int lengthOfLongestSubstring3(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder subString = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (subString.indexOf(String.valueOf(s.charAt(j))) != -1) {
                    break;
                }

                subString.append(s.charAt(j));
                maxLength = Math.max(maxLength, subString.length());
            }
        }

        return maxLength;
    }


    // Sliding window algorithm
    public int lengthOfLongestSubstring(String s) {
        int leftIndex = 0, maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar)
                    && map.get(currentChar) >= leftIndex
            ) {
                leftIndex = map.get(currentChar) + 1;
            }
            maxLength = Math.max(maxLength, right - leftIndex + 1);
            map.put(currentChar, right);
        }

        return maxLength;
    }


    // Use of String only
    public int lengthOfLongestSubstring4(String s) {
        int maxLength = 0;

        for (int right = 0, leftIndex = 0; right < s.length(); right++) {
            int indexOfFirstApperanceInSubstring = s.indexOf(s.charAt(right), leftIndex);
            if (indexOfFirstApperanceInSubstring != right) {
                leftIndex = indexOfFirstApperanceInSubstring + 1;
            }
            maxLength = Math.max(maxLength, right - leftIndex + 1);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        StringBuilder lSubstring = new StringBuilder();
        int value = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                lSubstring.append(s.charAt(i));
                map.put(s.charAt(i), true);
            } else {
                if (lSubstring.length() > value) {
                    value = lSubstring.length();
                    lSubstring = new StringBuilder();
                    map = new HashMap<>();
                    lSubstring.append(s.charAt(i));
                    map.put(s.charAt(i), true);
                }
            }
        }

        return Math.max(lSubstring.length(), value);
    }


    public static void main(String[] args) {
        LC003LongestSubstringWithoutRepeatingChar aChar = new LC003LongestSubstringWithoutRepeatingChar();


        System.out.println("abcabcbb >>> Expected > 3");
        System.out.println("bbbbb >>> Expected > 1");
        System.out.println("pwwkew >>> Expected > 3");
        System.out.println("dvdf >>> Expected > 3");
        System.out.println("abba >>> Expected > 2");

        String[] inputs = new String[]{"abcabcbb", "bbbbb", "pwwkew", "dvdf", "abba"};

        for (String input : inputs) {
//            System.out.println(input + " >>> " + aChar.lengthOfLongestSubstring(input));
        }


//        System.out.println("abcabcbb >>> Expected > 3, Output > " +aChar.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println("bbbbb >>> Expected > 1, Output > " +aChar.lengthOfLongestSubstring("bbbbb"));
//        System.out.println("pwwkew >>> Expected > 3, Output > " +aChar.lengthOfLongestSubstring("pwwkew"));
//        System.out.println("dvdf >>> Expected > 3, Output > " +aChar.lengthOfLongestSubstring("dvdf"));

        System.out.println("\n********************\n");

        for (String input : inputs) {
            System.out.println(input + " >>> " + aChar.lengthOfLongestSubstring(input));
        }

//        System.out.println("abcabcbb >>> Expected > 3, Output > " +aChar.lengthOfLongestSubstring2("abcabcbb"));
//        System.out.println("bbbbb >>> Expected > 1, Output > " +aChar.lengthOfLongestSubstring2("bbbbb"));
//        System.out.println("pwwkew >>> Expected > 3, Output > " +aChar.lengthOfLongestSubstring2("pwwkew"));
//        System.out.println("dvdf >>> Expected > 3, Output > " +aChar.lengthOfLongestSubstring2("dvdf"));
    }
}
