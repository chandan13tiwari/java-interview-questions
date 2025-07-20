package com.poc;

class LifecycleDemo extends Thread {
    public void run() {
        System.out.println("Thread is executing");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) throws InterruptedException {
        LifecycleDemo t = new LifecycleDemo();
        System.out.println("1. State before start: " + t.getState()); // NEW
        t.start();
        System.out.println("2. State after start: " + t.getState()); // RUNNABLE
        Thread.sleep(10); // Give time to run
        System.out.println("3. State after start: " + t.getState()); // RUNNABLE or TERMINATED
        Thread.sleep(10); // Give time to run
        System.out.println("4. State after start: " + t.getState()); // RUNNABLE or TERMINATED
        t.join();
        System.out.println("Final state: " + t.getState()); // TERMINATED
    }
}