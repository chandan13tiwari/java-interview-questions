package com.poc;

public class StarvationDemo {
    public static void main(String[] args) {
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            int count = 0;
            while (count < 5) {
                System.out.println(name + " is cooking...");
                count++;
                try { Thread.sleep(5000); } catch (InterruptedException e) {}
            }
        };

        Thread vipChef1 = new Thread(task, "VIP-Chef-1");
        Thread vipChef2 = new Thread(task, "VIP-Chef-2");
        Thread regularChef = new Thread(task, "Regular-Chef");

        vipChef1.setPriority(Thread.MAX_PRIORITY);
        vipChef2.setPriority(Thread.MAX_PRIORITY);
        regularChef.setPriority(Thread.MIN_PRIORITY);

        vipChef1.start();
        vipChef2.start();
        regularChef.start();
    }
}
