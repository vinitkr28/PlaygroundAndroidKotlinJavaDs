package com.libleetcode.backtracking.lc51nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC51NQueensMain {
    public static void main(String[] args) {
        LC51NQueensInterface nQueens = null;
        List<List<String>> output = null;


        /*nQueens = new LC51NQueensSolution0();
        output = nQueens.solveNQueens(4);
        output.forEach(System.out::println);*/

        /*
        nQueens = new LC51NQueensSolution1();
        output = nQueens.solveNQueens(4);
        output.forEach(System.out::println);


        nQueens = new LC51NQueensSolution2();
        output = nQueens.solveNQueens(4);
        output.forEach(System.out::println);
        */

        /*
        nQueens = new LC51NQueensSolution3();
        output = nQueens.solveNQueens(4);
        output.forEach(System.out::println);
        */


        String[] geeks = {"Rahul", "Utkarsh",
                "Shubham", "Neelam"};

        List<String> al = null;

        al = Arrays.asList(geeks);
        System.out.println("Type1.a: " + al);
        //al.add("Abhishek");//Exception: java.lang.UnsupportedOperationException
        //System.out.println("Type1.b: " + al);

        System.out.println("\n*******\n");

        al = new ArrayList<>();
        //Collections.addAll(null, geeks);//java.lang.NullPointerException
        //Collections.addAll(al, null);////java.lang.NullPointerException
        Collections.addAll(al, geeks);
        System.out.println("Type2.a: " + al);
        al.add("Abhishek");
        System.out.println("Type2.b: " + al);

        System.out.println("\n*******\n");

        al = new ArrayList<>(Arrays.asList(geeks));
        al.add("Mukesh");
        System.out.println("Type3.a: " + al);
    }
}
