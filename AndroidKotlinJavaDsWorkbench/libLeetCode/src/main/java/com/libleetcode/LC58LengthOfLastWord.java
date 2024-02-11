package com.libleetcode;

public class LC58LengthOfLastWord {


    public int lengthOfLastWord(String s) {
        String[] spiltedString = s.trim().split(" ");

        return spiltedString[spiltedString.length-1].length();
    }
}
