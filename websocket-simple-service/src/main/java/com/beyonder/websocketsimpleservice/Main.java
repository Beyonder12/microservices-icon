package com.beyonder.websocketsimpleservice;

public class Main {
    public static void main(String[] args) {
        Human iqbal = new Human();
        iqbal.walk(1);

        //Linked List Data Structure ---> space complexity : O(constant), time complexity : O(n)
        Node ll = new Node(1);
        ll.next = new Node(2);
        ll.next.next = new Node(3);

        System.out.println(ll.head);
        System.out.println(ll.next.head);
        System.out.println(ll.next.next.head);

        // List Data Structure ---> space complexity : O(n), time complexity : O(constant)
        // n = [1, 2, 3, 4, 5] -> n.get(4)
    }
}
