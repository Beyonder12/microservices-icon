package com.beyonder.websocketsimpleservice;

public class Human extends Mammal{
    private int energy;

    public Human() {
    }

    public Human(int energy) {
        this.energy = energy;
    }

    //overide
    void walk() {
        System.out.println("Walking with legs");
    }

    //overload
    void walk(int energy) {
        System.out.println("Walking with legs..." + energy);
    }
}
