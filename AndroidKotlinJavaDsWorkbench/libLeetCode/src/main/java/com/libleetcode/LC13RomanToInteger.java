package com.libleetcode;

import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/roman-to-integer/description/

/*

I -> can be placed before V (5) and X (10) to make 4 and 9.
X -> can be placed before L (50) and C (100) to make 40 and 90.
C -> can be placed before D (500) and M (1000) to make 400 and 900.

* */


//HashMap - offers 0(1) lookup and insertion - It contains only unique elements.
public class LC13RomanToInteger {

    private Map<String, Integer> romanSymbolWithValue() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        //TreeMap ->    {C=5, D=6, I=1, L=4, M=7, V=2, X=3}
        //HashMap ->    {C=5, D=6, V=2, X=3, I=1, L=4, M=7} |  offers 0(1) lookup and insertion
        //LinkedHashMap ->    {I=1, V=2, X=3, L=4, C=5, D=6, M=7}
        //Hashtable ->  {L=4, V=2, I=1, D=6, C=5, M=7, X=3}

        return map;
    }

    public int romanToInt(String s) {

        Map<String, Integer> map = romanSymbolWithValue();


        int finalValue = 0;
        String tempIndexValue = null;
        for (int i = 0; i < s.length(); i++) {
            String currentIndex = String.valueOf(s.charAt(i));

            if (i == s.length()-1){
                finalValue = finalValue + map.get(currentIndex);

            }

            if (currentIndex.equals("I") || currentIndex.equals("X") || currentIndex.equals("C")) {
                if (tempIndexValue == null) {
                    tempIndexValue = currentIndex;
                } else {
                    finalValue = finalValue + map.get(tempIndexValue);
                    tempIndexValue = currentIndex;
                }

            } else {
                int currentIndexValue = map.get(currentIndex);
                if(tempIndexValue != null && (currentIndex.equals("V") || currentIndex.equals("L") || currentIndex.equals("D"))) {
                    int previousIndexValue = map.get(tempIndexValue);
                    tempIndexValue = null;
                    currentIndexValue = currentIndexValue - previousIndexValue;
                } else if (tempIndexValue != null) {
                    int previousIndexValue = map.get(tempIndexValue);
                    currentIndexValue = currentIndexValue + previousIndexValue;
                }
                finalValue = finalValue + currentIndexValue;
            }
        }
        return finalValue;
    }


    public int romanToInt2(String s){
        int finalValue = 0;

        for (int i = 0; i < s.length(); i++){

        }



        return 0;
    }
    public static void main(String[] args) {
        LC13RomanToInteger integer = new LC13RomanToInteger();
        int intValue = integer.romanToInt("MCMXCIV");
        System.out.println(">>>> " + intValue);
    }
}
