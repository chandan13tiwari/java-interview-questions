package com.poc;

/**
 * Hello world!
 *
 */
public class App2 implements Runnable
{
    @Override
    public void run() {
        System.out.println("Hey this is Thread class thread");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main( String[] args )
    {
        App2 obj = new App2();
        Thread thread = new Thread(obj);
        System.out.println("This is main().. thread name: " + Thread.currentThread().getName());
        thread.start();
    }
}
