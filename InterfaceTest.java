
/*
	- Think of interfaces as a template that can be applied to a class. 
	- Similar to inheritance, but specifies what a class has/must do. 
	- Classes can apply more than one interface, whereas java does not support 
		multiple inheritances. 

	- Difference between Interfaces and Abstract Classes: 
		- Interfaces cannot define methods, only  declare them. 
		- Abstract classes can do both.

	- Lambda Function: 
		- Syntax: (args) -> {statements}
*/

public class InterfaceTest{

	public static void main(String[] args){
		
		Hawk hawk = new Hawk();
		Rabbit rabbit = new Rabbit();

		hawk.hunt();
		rabbit.flee();	

		Fish fish = new Fish();

		fish.hunt();
		fish.flee();
	}
}