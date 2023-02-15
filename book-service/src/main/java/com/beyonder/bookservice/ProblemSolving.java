package com.beyonder.bookservice;

public class ProblemSolving {
    public static void main(String[] args) {
        revInt(54321);
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
}
