import java.util.Scanner;
import java.util.Random;
public class BasicJavaProgramming{

	public static void main(String[] args){


		// Creating Objects

		String title; 

		title = new String("Java"); // Object must be created seperately from declaration.

		System.out.println(title);


		// Once an object is instantiated, we use the dot operator to access its methods
		System.out.println(title.length());	


		// Object References: 
		// pointer to the location of the object

		// For primitive types, the primitive itself is the value which it is assigned.
		// For object references, it is a pointer to the location of the object. 

		String name1 = "Sam"; // name variables point to their values
		String name2 = "Peter";

		name2 = name1; // We can think of this as name2 now pointing to name1 location, as opposed to name2 itself being altered. 
						// name2's initial value, "Peter", now no longer has any valid reference; this is known as "garbage". 
						// Java preforms automatic garbage collection periodically, meaning its memory will be returned to the system for future use.

		// String Class
		// Once a string object is created, neither its value nor its length can be changed (e.g. it's immutable)
		
		String x = "Hello";
		System.out.println(x);
		x = "There";
		System.out.println(x);	

		// The above works, but Java is simply changing the value that the variable references. 
		// By doing x = "There", we are changing the reference of x to a new object created by the string literal "There".
		// "There" is the new string literal which x references. "Hello" becomes garbage. 

		// Indexing a string
		String y = "Hello";

		System.out.println(y.charAt(0));

		String str = "Hello There!";
		String subStr = str.substring(6,str.length()-1);
		System.out.println(subStr);	

		System.out.println("Original String: \"" + str + "\"");
		System.out.println("Length of String: " + str.length());

		String mut1, mut2, mut3, mut4; 

		mut1 = str.concat(" General Kenobi!");
		mut2 = mut1.toUpperCase();
		mut3 = mut2.replace('E', 'X');
		mut4 = mut3.substring(10,20);

		System.out.println(mut1);	
		System.out.println(mut2);	
		System.out.println(mut3);	
		System.out.println(mut4);	


		// Class Libraries
		// Collection of classes that we can use while developing
		// Java Standard Class Library is part of any java environment

		// Packages
		// Classes of Java Standard Library are organized into packcages
		// E.g. java.lang, java.applet, java.awt, javax.swing, java.net, java.util, etc.

		// We can import these packages via the "import" declaration
		// e.g. import java.util.Scanner; 
		// or if we want all class libraries in a particular package
		// import java.util.*;

		// All classes of the java.lang package are improted automatically into all programs

		// Random Class
		// Part of java.util package - provides methods to generate pseudo-random numbers

		Random generator = new Random(); 
		int num1;
		float num2; 

		num1 = generator.nextInt();
		System.out.println("A random integer: " + num1);

		num1 = generator.nextInt(10);
		System.out.println("From 0 to 9: " + num1);

		num1 = generator.nextInt(10) + 1;
		System.out.println("From 1 to 10: " + num1);
		
		num1 = generator.nextInt(15) + 20;
		System.out.println("From 20 to 34: " + num1);

		num1 = generator.nextInt(20) - 10;
		System.out.println("From -10 to 9: " + num1);

		num2 = generator.nextFloat();
		System.out.println("A random float between 0-1: " + num2);
		
		
		// Math Class
		// A part of the java.lang package
		// Contains various mathematical functions e.g. absolute value, square root, exponentiation, trig functions, etc.

		int a, b, c; 
		double delta, root1, root2; 

		Scanner scan = new Scanner(System.in);
		System.out.println("ax^2 + bx + c");

		System.out.println("Enter the value of a: ");
		a = 4; //scan.nextInt();
		System.out.println("Enter the value of b: ");
		b = 8; //scan.nextInt();
		System.out.println("Enter the value of c: ");
		c = 3; //scan.nextInt();

		// Use the Quadratic Formula to Find the Roots of the equation given these values
		// x = (-b +/- sqrt(b^2 -4ac))/2a

		delta = Math.pow(b,2) - (4 * a * c);
		root1 = (-b + Math.sqrt(delta))/(2*a);
		root2 = (-b - Math.sqrt(delta))/(2*a);

		System.out.println("Root #1: " + root1);
		System.out.println("Root #2: " + root2);


		// Control Structures
		// All programs can be written with three control structures: Sequence Structure, Selection Structure, Repition Structure
		// Java has all three

		// Selection Statements: if, if-else, switch
		// Repition Statement (Looping): while(performs body actions 0 or more times), do..while()performs body actions one or more times, for(performs body actions 0 or more times) 

		int num = 10; 

		if(num > 0){
			System.out.println("Number is positive.");
		}
		else if(num < 0){
			System.out.println("Number is negative.");
		}
		else{
			System.out.println("Number is 0.");
		}

		// Conditional Operator
		// (? : )
		// Java's only ternary operator (takes three operands)
		// ?: and its three operands form a conditional expression
		// Entire conditional expression evalutes to the second operand if first operand is true, or third operand if it is false. 

		double d = Math.random() * 10; 

		int e = (int) d; 
		System.out.println(e);

		e %= 2; 

		String str2;

		str2 = e == 0 ? "even" : "odd"; // operands split by '?' and ':' respectively: operand_1 ? operand_2 : operand_3

		System.out.println(str2);

		 
		// Don't need curly braces if body of if-statement is one line.
		if(num % 2 == 1 && num > 0)
			System.out.println(true);
		

		// The above if-statement is equivalent to
		System.out.println(num%2 != 0 && num>0);

		// While repetition statement
		// Repeats body action while loop-continuation condition remains true

		while(num >= 0){
			System.out.println(num);
			num--;
		}

		// Switch Statement
		int option = 3; 

		switch (option){
			case 1: 
				System.out.println("1");
				break; 
			case 2: 
				System.out.println("2");
				break; 
			default: 
				System.out.println("Not 1 or 2");
				break; 
		}

		// do-while Statement
		// Executed once initially and then condition is evaluated (differs from while which evaluates condition first and potentially not execute at all). 
		// Statement is executed repeatedly until the condition becomes false
		// Body of a do-while loop executes at least once. 

		int counter = 1; 

		do{
			System.out.println("Counter: " + counter);
			counter++;
		}while(counter < 6);

		// for loop
		// for(initialization; condition; increment){ statement; }
	
		for(int i = 0; i<6; i++){
			System.out.println(i);
		}

		for(int i = 100; i >= 0; i-=5){
			System.out.println(i);
		}
	}

}