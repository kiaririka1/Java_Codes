/*
 * Title: Practicing Inheritance in Java
 * Description: The code includes an inheritance problem.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.*; 
class Animal{
	Animal(){ System.out.println("I am an animal");}
	Animal(int a){
		if(a==4) {System.out.println("I am a 4-legged animal");}
		if(a==2) {System.out.println("I am a 2-legged animal");}
	}
	void run() {System.out.println("The animal is running");}
	}
class Dog extends Animal{
	Dog(){
		super(4);
		System.out.println("I am a dog.");}
	Dog(int a, int b){
		System.out.println("I am a Shiba Inu");	}
	void bark() {
		System.out.println("Bow bow");
	}
}

class Shiba extends Dog{
	Shiba(){
	super(2,3);
	}
	//This method tag overrides the parent class method
	@Override
	void bark() {System.out.println("Woof woof");}
}

public class Inheritance {
public static void main(String[] Args) {
	Animal a = new Dog(4,3);
	//a.bark();//Animal object cannot access dog methods
	a.run();
	Dog d = new Dog();
	d.bark();
	Shiba s = new Shiba();
	s.bark();
}
} 
