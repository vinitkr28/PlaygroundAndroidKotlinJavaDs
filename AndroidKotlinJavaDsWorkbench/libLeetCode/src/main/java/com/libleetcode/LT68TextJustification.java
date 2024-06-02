package com.libleetcode;

import java.util.LinkedList;
import java.util.List;

public class LT68TextJustification {


    /*Example 1:

    Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
    Output:
            [
            "This    is    an",
            "example  of text",
            "justification.  "
            ]


    Example 2:

    Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
    Output:
            [
            "What   must   be",
            "acknowledgment  ",
            "shall be        "
            ]
    Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
    Note that the second line is also left-justified because it contains only one word.


    Example 3:

    Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
    Output:
            [
            "Science  is  what we",
            "understand      well",
            "enough to explain to",
            "a  computer.  Art is",
            "everything  else  we",
            "do                  "
            ]*/

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> finalValue = new LinkedList<>();
        StringBuilder finalLine = new StringBuilder();
        int noOfElement = 0;

        for (int i = 0; i < words.length; i++) {
            int temp = 0;
            for (int j = i; j < words.length; j++) {
                if((temp + words[j].length()) >= maxWidth) {

                    int extraSpace = (maxWidth - temp) % j;
                    for (int k = i; k < j; k++) {
                        finalLine.append(words[k]).append(" ");
                        if (extraSpace > 0){
                            finalLine.append(" ");
                            extraSpace--;
                        }
                    }
                    finalValue.add(finalLine.toString());
                    finalLine = new StringBuilder();
                    break;
                } else {
                    temp = temp + 1 + words[j].length();
                }
            }
        }



        return finalValue;
    }

    public static void main(String[] args) {
        LT68TextJustification justification = new LT68TextJustification();

        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> value = justification.fullJustify(words, 16);

        System.out.println(value);
    }
}
