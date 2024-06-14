package com.libjavapractice.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
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



        HashSetExample example = new HashSetExample();

        Map<String, String> cityRoot = new HashMap<>();
        cityRoot.put("Chennai", "Bengaluru");
        cityRoot.put("Mumbai", "Delhi");
        cityRoot.put("Goa", "Chennai");
        cityRoot.put("Delhi", "Goa");

        example.findItinerary(cityRoot);
    }


    public void findItinerary(Map<String, String> fromTo){
        Map<String, String> reverseFromTo = new HashMap<>();


        String starting = null, ending = null;

        for (Map.Entry<String, String> entry: fromTo.entrySet()) {
            reverseFromTo.put(entry.getValue(), entry.getKey());
        }

        for(String key: reverseFromTo.keySet()) {
            if (!fromTo.containsKey(key)) {
                ending = key;
                break;
            }
        }

        for (String key: fromTo.keySet()) {
            if (!reverseFromTo.containsKey(key)) {
                starting = key;
                break;
            }
        }

        String currentCity = starting;

        if (currentCity == null) return;
        StringBuilder builder = new StringBuilder(currentCity);
        while( !currentCity.equals(ending)) {
            currentCity = fromTo.get(currentCity);
            builder.append(" -> " + currentCity);
        }

        System.out.println(builder);
    }
}
