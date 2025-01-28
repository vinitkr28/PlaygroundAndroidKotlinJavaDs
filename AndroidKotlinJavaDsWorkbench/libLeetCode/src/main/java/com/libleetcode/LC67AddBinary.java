package com.libleetcode;

public class LC67AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder finalString = new StringBuilder();
        String bigString, smallString;
        if (a.length() > b.length()) {
            bigString = a;
            smallString = b;
        } else {
            bigString = b;
            smallString = a;
        }

        int temp = 0;
        int smallStringIndex = smallString.length() - 1;
        for(int i = bigString.length()-1; i >= 0; i--) {
            int bigTemp = bigString.charAt(i) - '0';
            int smallTemp = 0;
            if(smallStringIndex > -1){
                smallTemp = smallString.charAt(smallStringIndex) - '0';
                smallStringIndex--;
            }

            if ((bigTemp + smallTemp + temp) == 3) {
                temp = 1;
                //finalString = "1" + finalString;
                finalString.insert(0, "1");
            } else if ((bigTemp + smallTemp + temp) == 2) {
                temp = 1;
                finalString.insert(0, "0");
            } else if ((bigTemp + smallTemp + temp) == 1) {
                temp = 0;
                finalString.insert(0, "1");
            } else {
                temp = 0;
                finalString.insert(0, "0");
            }

            if (i ==0 && temp == 1) {
                finalString.insert(0, "1");
            }

        }

        return finalString.toString();

        /*

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1)
        {
            if(i >= 0)
                carry += a.charAt(i--) - '0';
            if(j >= 0)
                carry += b.charAt(j--) - '0';
            sb.insert(carry % 2, sb);
//            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.toString();
//        return sb.reverse().toString();
        */

    }

    public static void main(String[] args) {
        LC67AddBinary binary = new LC67AddBinary();
//        String value = binary.addBinary("11", "1");
//        System.out.println("100>>>> " + value);

        String value = binary.addBinary("1010", "1011");
        System.out.println("10101>>>> " + value);

//        String value = binary.addBinary("0", "0");
//        System.out.println("0>>>> " + value);
    }
}
