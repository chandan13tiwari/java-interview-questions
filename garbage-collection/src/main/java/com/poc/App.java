package com.poc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App obj = new App();
        obj = null; // Make object eligible for GC

        System.gc(); // Suggest GC

        System.out.println("Garbage Collection suggested");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() method called before object is garbage collected");
    }
}
