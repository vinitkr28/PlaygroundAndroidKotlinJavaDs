package com.libjavapractice.hashing;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Nokia", 20);
        map.put("Samsung", 30);
        map.put("LG", 20);
        map.put("Nokia", 60);
        map.put(null, 45);
        map.put(null, 200);


        System.out.println("\n\n *************************\n\n");

        System.out.println("returnValue: " + map.put("Mi", 90));
        System.out.println("returnValue: " + map.put("Lava", 10));
        System.out.println("returnValue: " + map.put("Samsung", 10));

        System.out.println("returnValue: " + map.put("Samsung", 100));

        System.out.println("\n\n *************************\n\n");

        for(String eachKey: map.keySet()) {
            System.out.println("Key: " + eachKey + ", Value: " + map.get(eachKey));
        }

        System.out.println("\n\n *************************\n\n");

        for(Map.Entry<String, Integer> eachEntry: map.entrySet()) {
            System.out.println("Key: " + eachEntry.getKey() + ", Value: " + eachEntry.getValue());
        }
    }


}
