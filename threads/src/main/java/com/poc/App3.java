package com.poc;

import java.util.concurrent.*;

/**
 * Hello world!
 *
 */
public class App3 implements Callable<String>{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        System.out.println("main thread::" + Thread.currentThread().getName());
        App3 task = new App3();
        System.out.println("main thread::" + Thread.currentThread().getName());
        Future<String> future = executor.submit(task);
        System.out.println(future.get());
        System.out.println("main thread::" + Thread.currentThread().getName());
        executor.shutdown();
    }

    @Override
    public String call() throws Exception {
        System.out.println("callable thread::" + Thread.currentThread().getName());
        return "Inside Callable";
    }
}
