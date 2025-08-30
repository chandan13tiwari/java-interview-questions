package com.poc;

class SharedResource {
    private int data;
    private boolean available = false;

    // Producer writes data
    public synchronized void produce(int value) throws InterruptedException {
        while (available) {  // If data is already available, wait
            wait();
        }
        data = value;
        available = true;
        System.out.println("Produced: " + value);
        notify(); // Notify consumer
    }

    // Consumer reads data
    public synchronized void consume() throws InterruptedException {
        while (!available) {  // If no data available, wait
            wait();
        }
        System.out.println("Consumed: " + data);
        available = false;
        notify(); // Notify producer
    }
}

public class InterThreadCommunicationDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    resource.produce(i);
                }
            } catch (InterruptedException e) {
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    resource.consume();
                }
            } catch (InterruptedException e) {
            }
        });

        producer.start();
        consumer.start();
    }
}
