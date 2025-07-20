package com.poc;

/**
 * Hello world!
 *
 */
public class App extends Thread
{
    @Override
    public void run() {
        System.out.println("Hey this is Thread class thread");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main( String[] args )
    {
        App obj = new App();
        System.out.println("This is main().. thread name: " + Thread.currentThread().getName());
        obj.start();
    }
}
