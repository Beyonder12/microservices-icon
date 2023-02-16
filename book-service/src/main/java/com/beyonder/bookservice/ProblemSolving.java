package com.beyonder.bookservice;

import java.util.HashMap;
import java.util.Map;

public class ProblemSolving {
    public static void main(String[] args) {
//        revInt(54321);
        System.out.println(isAnagram("kojok", "joko"));
    }


    public static int revInt(int num) {
        int result = 0;
        while(num != 0) {
            int rem = num % 10;
            result = (result*10) + rem;
            num = num / 10;
        }
        return result;
    }

    public static boolean isAnagram(String words1, String words2) {

        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        char[] wtochar1 = words1.toCharArray();
        char[] wtochar2 = words2.toCharArray();

        for(char c1 : wtochar1) {
            mp1.put(c1, mp1.getOrDefault(c1, 0) + 1);
        }

        for(char c2 : wtochar2) {
            mp2.put(c2, mp2.getOrDefault(c2, 0) + 1);
        }

        //iterate map
        for (Map.Entry<Character, Integer> set : mp1.entrySet()) {
            if(mp2.get(set.getKey()) != set.getValue()) return false;
        }


        return true;
    }
}
