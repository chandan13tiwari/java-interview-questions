package com.poc;

class Resource {
    String name;
    Resource(String name) {
        this.name = name;
    }
}

public class DeadlockDemo {
    public static void main(String[] args) {
        Resource salt = new Resource("Salt");
        Resource pepper = new Resource("Pepper");

        Thread chef1 = new Thread(() -> {
            synchronized (salt) {
                System.out.println("Chef-1 locked " + salt.name);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Chef-1 waiting for " + pepper.name);
                synchronized (pepper) {
                    System.out.println("Chef-1 locked " + pepper.name);
                }
            }
        });

        Thread chef2 = new Thread(() -> {
            synchronized (pepper) {
                System.out.println("Chef-2 locked " + pepper.name);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Chef-2 waiting for " + salt.name);
                synchronized (salt) {
                    System.out.println("Chef-2 locked " + salt.name);
                }
            }
        });

        chef1.start();
        chef2.start();
    }
}
