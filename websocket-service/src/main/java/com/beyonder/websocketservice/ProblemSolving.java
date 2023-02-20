package com.beyonder.websocketservice;

public class ProblemSolving {
    public static void main(String[] args) {
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));

        System.out.println(factorial(5));

        System.out.println(isAnagram("KataK"));
        System.out.println(isAnagram("bobo"));
        System.out.println(isAnagram("bobt"));

    }

    public static int fibonacci(int num) {
        //base case
        if(num <= 2) return 1;

        //logic
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static int factorial(int num) {
        if(num == 0) return 1;
        return factorial(num - 1) * num;
    }

    public static boolean isAnagram(String str) {
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right) ) return false;
            left++;
            right--;
        }
        return true;
    }
}
