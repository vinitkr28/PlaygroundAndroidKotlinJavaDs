package com.libleetcode;

class LC009PalindromeNumber {


    public boolean isPalindrome(int x) {
        boolean palindromeFound = true;
        String intToString = String.valueOf(x);

        for (int i = 0; i < Math.ceil((double) intToString.length() /2); i++) {
            if (intToString.charAt(i) != intToString.charAt(intToString.length() - (i+1))) {
                palindromeFound = false;
                break;
            }
        }
        return palindromeFound;
    }



    public boolean isPalindrome2(int x) {
        int temp = x;
        long sum = 0;
        while(x>0) {
            sum = (sum*10) +  x%10;
            x = x /10;
        }
        return temp==sum;
    }



    public static void main(String[] args) {
        LC009PalindromeNumber number = new LC009PalindromeNumber();
        System.out.println("palindromeFound>> \t" + number.isPalindrome(-121));
    }
}
