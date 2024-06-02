package com.libjavapractice;

import java.util.HashMap;
import java.util.Map;

public class MyClass {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        StringBuilder lSubstring = new StringBuilder();
        int value = 0;

        for(int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                lSubstring.append(s.charAt(i));
                map.put(s.charAt(i), true);
            } else {
                if(lSubstring.length() > value) {
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
        MyClass myClass = new MyClass();
        int v = myClass.lengthOfLongestSubstring("dvdf");
        System.out.println("======> " + v);
    }
}
