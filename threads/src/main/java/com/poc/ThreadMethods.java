package com.poc;

class MyThread extends Thread {

    public void run() {
        System.out.println(getName() + " is running.");

        try {
            // Sleep the thread for 1 second
            Thread.sleep(1000);

            // Yielding the CPU to other threads
            System.out.println(getName() + " yielding CPU...");
            Thread.yield();

        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted!");
        }

        System.out.println(getName() + " finished.");
    }
}

public class ThreadMethods {
    public static void main(String[] args) {

        // Create thread objects
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // Set names
        t1.setName("Worker-1");
        t2.setName("Worker-2");

        // Set priorities
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        // Set t2 as daemon
        t2.setDaemon(true);

        // Start threads
        t1.start();
        t2.start();

        // Print thread info
        System.out.println("main::" + Thread.currentThread().getName() + " priority::" + Thread.currentThread().getPriority());
        System.out.println("Thread ID of " + t1.getName() + ": " + t1.getId());
        System.out.println("Priority of " + t1.getName() + ": " + t1.getPriority());
        System.out.println("Is " + t2.getName() + " Daemon? " + t2.isDaemon());

        try {
            // Main thread waits for t1 to finish
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        t1.stop();
        t2.stop();

        // Check if threads are alive
        System.out.println(t1.getName() + " is alive? " + t1.isAlive());
        System.out.println(t2.getName() + " is alive? " + t2.isAlive());

        // Interrupt t2 (though it may already be finished)
        t2.interrupt();
        System.out.println(t2.getName() + " is interrupted? " + t2.isInterrupted());

        // Current thread info
        System.out.println("Current Thread: " + Thread.currentThread().getName());
    }
}
