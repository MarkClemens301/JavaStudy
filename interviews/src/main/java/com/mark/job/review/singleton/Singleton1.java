package com.mark.job.review.singleton;

public class Singleton1 {
    public static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
        System.out.println("SingleClass.class = " + Singleton1.class);
    }
}
