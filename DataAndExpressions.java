import java.util.Scanner;

public class DataAndExpressions {

	public static void main(String[] args){

		System.out.println("Hello"); // println appends new line after printing

		System.out.print("Hey");
		System.out.print(" There!"); // No new line when using print
		System.out.println(); // We can create a new line by calling println with no parameters. 

		// Variables
		int total; 

		int count, temp, result; 

		total = 0; 

		int sum = 0; 

		int base = 32, max = 149; 

		// String concatenation
		System.out.println("Peanut " + "Butter");
		System.out.println("x = " + 1);

		String s1 = "Computer Science";
		int x = 307; 

		String s2 = s1 + " " + x; 
		String s3 = s2.substring(10,17);
		String s4 = "is fun"; 
		String s5 = s2 + s4; 

		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);
		System.out.println("s3: " + s3);
		System.out.println("s4: " + s4);
		System.out.println("s5: " + s5);

		// Precedence

		x = 3; 
		int y = 5; 
		String s6 = x + y + "total";
		String s7 = "total " + x + y;
		String s8 = " " + x + y + "total";
		System.out.println("s6: " + s6);
		System.out.println("s7: " + s7);
		System.out.println("s8: " + s8);

		// Escape Sequences: a series of characters that represent a special character e.g. \t, \n, \", \b, \'
		// Begin with backslash character \
		System.out.println("I said \"Hello\" to you.");
		System.out.println("Hello\nThere\n!");
		
		// Constants: Value of constant variables never change; we declare them with 'final'
		final int MIN_HEIGHT = 67; // Typical practice is to capitalize constants. 

		// Primitive Data Types: 
		// 4 integer representations: byte(-128,127), short(-32,768, 32,767), int(-2,147,483,648,2,147,483,647), long(-9,223,372,036,854,775,808,9,223,372,036,854,775,807)
		// 2 floating point: float(-3.4E+38, 3.4E+38) with 7 sig. digits, double(-1.7E+308, 1.7E+308) with 15 sig. digits
		// 1 char: char
		// One Boolean: boolean
		// Primitives are not composed of other data types. 
		// Primitives are passed by value e.g. copy of primitive itself is passed, whereas for objects a copy of the reference is passed. 
		// Primitives are independent data types; as such they do not exist in a hierarchy. Objects descend from initial "Object" class
		// Primitives do not have default methods of themselves, whereas objects do (e.g. toString())

		// Java assumes all integer literals are of type int, and all float literals of type double if we do not specify. 
		float ratio = 0.2363f; 
		double delta = 453.523311903;
		long countedStars = 86826253927L;
		byte smallNum = 120; 

		// Characters
		// Defined by single quotations 

		char grade = 'A';

		// Strings are just "strings" of characters. 

		// Character sets are ordered list of characters, each corresponding to a unique number. 
		// E.g. ASCII Character Set
		// Java uses Unicode Character Set

		// Expressions: +,-,*,/,%
		// If either or both operands used by an arithmetic operator are floating point, then the result is a floating point as well. 

		// Operator Precedence follows BEDMAS model. 

		x = 20; 
		y = 10; 

		System.out.println("printing: " + x + y); // -> "printing: 2010" (As print function uses + as string concatenation since it evaluates left to right)
		System.out.println("printing: " + (x+y)); // -> "printing: 30"
		System.out.println("printing: " + x*y); // -> "printing: 200"

		System.out.println(1 + 2 + "abc"); // Evaluates left to right, so it starts with regular numerical addition before string concat
		System.out.println("abc" + 1 + 2); // starts with string concat, so we get "abc12"

		// Increment and Decrement
		count = 0; 
		System.out.println("count = " + count);
		count++; // Post-fix form
		System.out.println("count = " + count);
		--count; // pre-fix form
		System.out.println("count = " + count);

		// Difference between both fix's
		System.out.println(count++ + 10); // -> 10, increments after print executes
		System.out.println(++count + 10); // -> 12, increments before print executes

		// Assignment Operators
		// +=, -=, *=, /=, %=
		// Entire right-hand expression is evaluated first, then combined with original variable WRT assignment operator used
		count += 5;
		System.out.println(count);

		// += can be used for string concat is both operands are strings
		String x2 = "Hello";
		x2 += " There!";
		System.out.println(x2);

		// Scanner Class
		// Allows us to read input of various types
		// E.g. System.in object for keyboard input

		Scanner scan = new Scanner(System.in); // Creation of scanner object

		int userInput;

		System.out.print("Enter an integer: ");
		userInput = scan.nextInt();

		// nextInt, nextDouble, nextLine for strings

		// What is a primitive?
		
		/*
		A primitive is a data type that is composed of no other data types and can not be broken down any further. 
		It is like the atoms in the programming scenario. I say atom because atom is a basic unit of matter and there is nothing that can be derived from it.

		I mean, an int in C can not be broken down into smaller data type. An object, on the other hand can be thought of a molecule, consisting of more than one primitive type. 
		For example, string comes as part of the C++ standard library; however, it is an object and it is composed of smaller data types internally and contains methods.

		It is important to note that not all object-oriented languages are class based (eg. Javascript) You can not define a class in Javascript, so an object is quite different here. 
		Even though everything in Javascript is an object (Ruby also), the Number object is really a wrapper for an internal primitive.
		*/

		System.out.println(13/4); // performs integer division since neither operand is a float; essentially just floors actual value. 

		// Widening conversion: Byte -> Short -> Int -> Long -> Float -> Double (Safer because moving up the ladder we can still represent the value without overflow)
		// Narrowing Conversion: Double -> Float -> Long -> Int -> Short -> Byte (Not as safe, if we have short value of 500 and we convert to byte, we'll be over the byte's maximum capacity)
	}
}