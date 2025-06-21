package com.poc;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface XYZ {
    void display();
}

public class App implements Cloneable
{
    public static void main( String[] args )
    {

       XYZ obj = () -> System.out.println("Hello App");
       obj.display();

       // inbuilt funtional interface
        //1. Predicate
        // 2. Consumer
        // 3. Supplier
        // 4. Function

        Predicate<String> isLong = s -> s.length()>5;
        System.out.println(isLong.test("Chadnan")); // true
        System.out.println(isLong.test("poc")); // false

        Consumer<String> name = n -> System.out.println("Hello" + n);
        name.accept("Proof Of Concept");


        Supplier<String> supplier = () -> "Hello World";
        System.out.println(supplier.get());

        Function<String, Integer> calculateLength = (text) -> text.length();
        System.out.println(calculateLength.apply("Chandan"));
    }
}
