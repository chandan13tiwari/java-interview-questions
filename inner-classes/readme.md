1. What is inner class? 
	-> a class defined inside another class (or interface)
	

2. Why inner class are being used? 
	-> logically groups classes that are only used in one place
	-> increase encapsulation, code readablity and maintainabity
	-> improves code cohesion (term for interview)

3. Encapsulation using inner class --> issi ko code cohesion kehnte h

4. Types of inner class
	- Member Inner class 
		-> define inside abother class but outside any method
		-> has access to all members of outer class (including private)
		-> Eg. 
		class Outer {
    		private int x = 10;

    		class Inner {
        		void display() {
            		System.out.println("x = " + x);
        		}
    		}
		}
		-> instantiate using Outer.Inner inner = new Outer().new Inner();	
	

	- Static Nested Class
		-> define inside another class with static keyword
		-> can access only static members of outer class
		-> can't access non static members of outer class
		-> Eg.
		class Outer {
    		static int y = 20;

    		static class Inner {
        		void display() {
            		System.out.println("y = " + y);
        		}
    		}
		}
		-> Does not require an instance of the outer class to be instantiated
		Eg. Outer.Inner obj = new Outer.Inner()
		-> Usecase - when they don't need to access instance variable/method of the outer class

	- Loal Inner Class
		-> define inside a method or a block
		-> scope is only within that method
		-> can access local variables of the method only of they are final or effectively final (cannot be public, protected, private, static)
		-> Effectively final means - not declared as final + bit never reassigned after it is initialized
		-> Eg.
		class Outer {
    		void outerMethod() {
        		int z = 30;
        		class Inner {
            		void display() {
                		System.out.println("z = " + z);
            		}
        		}
        		Inner inner = new Inner();
        		inner.display();
    		}
		}
		-> Usecase - when you need a one-time helper class inside a method

	- Anonymous Inner Class
		-> class defined without a name (name decided by JAVA Compiler) and instantiated in a single expression
		-> declared and instantiated at the same time
		-> Use for implementing interfaces or abstract classes on the fly
		-> Eg.
		abstract class Animal {
    		abstract void sound();
		}

		class Test {
    		public static void main(String[] args) {
        		Animal a = new Animal() {
            		void sound() {
                		System.out.println("Meow");
            		}
        		};
        		a.sound();
    		}
		}
		-> Cannot have constructors or define static members
		-> Comminly used in event handling, threads, and GUI Code (like swing)
		-> Usecase - when an implementation is needed only once (eg. passing a callback or handler)

5. Advantages of Inner Classes
	- Encapsulation -> keeps related classes together
	- Code readability -> help organize code better
	- Access to outer class members -> inner class can access members of outer class, even if they are private


6. Real World examples -
	- Event Handling (GUI) - Using anonymous class
	-> Eg. 
	button.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
        	System.out.println("Button clicked!");
    	}
	});

	- Iterator Implementation - Using Member Inner class
	-> Eg. 
	public class MyList<T> {
    	private T[] data;

    	public class MyIterator {
        	int index = 0;

        	boolean hasNext() {
            	return index < data.length;
        	}

        	T next() {
            	return data[index++];
        	}
    	}
	}


7. When to use Inner Classes??
	-> when the class is only relevant within the context of its enclosing class
	-> When you need to improve encapsulation or encapsulate helper classes
	-> When you want to simplify code that won't be reused anywhere


8. Bonus Tips -
	-> Avoid using too many nested levels - too many inner classes decreases readability
	-> Anonymous inner classes are great for short, one-off implementation
	-> Prefer Lambda Expression over anonymous inner classes for functional interface 
		->
