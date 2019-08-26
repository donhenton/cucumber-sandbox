package com.dhenton9000.refactoring;

public class Singleton {

    private static Singleton single_instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (single_instance == null) {
            synchronized (Singleton.class) {
                single_instance = new Singleton();
            }
        }

        return single_instance;
    }
}
