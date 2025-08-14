package com.poc;

public class ImprovedStarvationDemo {
    public static void main(String[] args) {
        Runnable vipTask = () -> {
            String name = Thread.currentThread().getName();
            long end = System.currentTimeMillis() + 2000; // run for 2 seconds
            while (System.currentTimeMillis() < end) {
                // Keep working (no sleep)
                if (System.nanoTime() % 1_000_000 == 0) {
                    System.out.println(name + " is cooking...");
                }
            }
        };

        Runnable regularTask = () -> {
            String name = Thread.currentThread().getName();
            long end = System.currentTimeMillis() + 2000;
            while (System.currentTimeMillis() < end) {
                System.out.println(name + " is cooking...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        };

        Thread vipChef1 = new Thread(vipTask, "VIP-Chef-1");
        Thread vipChef2 = new Thread(vipTask, "VIP-Chef-2");
        Thread regularChef = new Thread(regularTask, "Regular-Chef");

        vipChef1.setPriority(Thread.MAX_PRIORITY);
        vipChef2.setPriority(Thread.MAX_PRIORITY);
        regularChef.setPriority(Thread.MIN_PRIORITY);

        vipChef1.start();
        vipChef2.start();
        regularChef.start();
    }
}
