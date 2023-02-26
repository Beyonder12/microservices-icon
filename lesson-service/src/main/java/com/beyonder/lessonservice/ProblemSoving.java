package com.beyonder.lessonservice;

public class ProblemSoving {

    public static void main(String[] args) {
        System.out.println(reverseString("abcde"));
        System.out.println(reverseString("Katak"));
        System.out.println(reverseString("pastiMati"));
        System.out.println(reverseString("kekuatantakhingga"));

    }

    public static String reverseString(String str) {
        String[] splitStr = str.split("");
        int n = str.length();

        for(int i = 0; i < n/2; i++) {
            String temp = splitStr[i];
            splitStr[i] = splitStr[n-1-i];
            splitStr[n-1-i] = temp;
        }

        return String.join("", splitStr);
    }
}
