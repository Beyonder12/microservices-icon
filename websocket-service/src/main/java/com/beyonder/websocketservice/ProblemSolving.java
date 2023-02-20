package com.beyonder.websocketservice;

public class ProblemSolving {
    public static void main(String[] args) {
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));

    }

    public static int fibonacci(int num) {
        //base case
        if(num <= 2) return 1;

        //logic
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
