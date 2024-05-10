package com.libjavapractice.hashing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {
        Set<Integer> intSet = new HashSet<>();

        intSet.add(1);
        intSet.add(2);
        intSet.add(3);

        Iterator it = intSet.iterator();

        System.out.println(it.hasNext());//true
        System.out.println(it.hasNext());//true
        System.out.println(it.hasNext());//true


        System.out.println(it.next());//1
        System.out.println(it.next());//2
        System.out.println(it.next());//3
//        System.out.println(it.next());//java.util.NoSuchElementException


        System.out.println(it.hasNext());//false
        System.out.println(it.hasNext());//false


    }
}
