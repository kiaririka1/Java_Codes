/*
 * Title: Abstract Class and Methods in Java
 * Description: The code includes abstract and inheritance method implementations in java.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//Abstract means existing only in idea but not in existence/idea without concrete existence.
//A class with abstract methods need to be declared abstract.
abstract class shape{
	//An abstract method is a method declared without an implementation.
	abstract void noOfLines();
}

//A subclass referencing abstract class needs to use the extends keyword and implement all of the methods in the abstract class.
class triangle1 extends shape{
	//The abstract class method must be overridden for implementation.
	@Override
	void noOfLines() {
		System.out.println("I have 3 lines");
	}
}

//The subclass which extends the abstract class but does not implement its methods needs to be declared abstract.
abstract class sqr extends shape{
	void angles() {
		System.out.println("I have 4 angles");
	}
}

//We cannot create an object of abstract class directly.
abstract class Pen{
	abstract void refill();
	abstract void write();
}

//A class extending abstract can have its own additional methods different to the abstract class.
class fountainPen extends Pen{
	@Override
	void refill() {
		System.out.println("Refilling the Fountain pen...");
	}
	void write() {
		System.out.println("Writing from the Fountain pen...");
	}
	void changeNib() {
		System.out.println("Changing the Nib...");
	}
}

//In Java, interface is a group of related methods with empty bodies.
interface basicAnimal{
	void eat();
	void sleep();
}

class Monkey{
	void jump() {
		System.out.println("Monkey is now jumping...");
	}
	void bite() {
		System.out.println("Monkey is now biting...");
	}
}

//We can use an interface with implements keyword.
//All the methods in an interface need to be implemented in a class and must be made public.
class Human extends Monkey implements basicAnimal{
	@Override
	public void eat() {
		System.out.println("Human is now eating...");
	}
	public void sleep() {
		System.out.println("Human is now sleeping...");
	}
//	@Override
//	void bite() {
//		System.out.println("Human is now biting...");
//	}
//	@Override
//	void jump() {
//		System.out.println("Human is now jumping...");
//	}

}

//More examples
abstract class Telephone{
	abstract void ring();
	abstract void lift();
	abstract void disconnect();
}

class smartTelephone extends Telephone{
	@Override
	void ring() {
		System.out.println("SmartTelephone is ringing...");
	}
	@Override
	void lift() {
		System.out.println("SmartTelephone is picked up...");
	}
	@Override
	void disconnect() {
		System.out.println("SmartTelephone is disconnected...");
	}

}

interface tvRemote{
	void on();
}
//An interface can extend another interface and also one class can implement multiple interfaces but not multiple abstract classes.
interface smartTvRemote extends tvRemote{
	void mouse();
}

class tv implements smartTvRemote{
	public void on() {
		System.out.println("TVRemote is on...");
	}
	public void mouse() {
		System.out.println("SmartTV Mouse Pointer is on...");
	}
}
public class Abstract_Prac {

	public static void main(String[] args) {
		shape t1 = new triangle1(); // works too because abstract methods are all being implemented
		t1.noOfLines();
		//sqr s = new sqr(); -- throws error, not possible.
		Pen p = new fountainPen();
		p.refill();
		p.write();
		fountainPen p1 = new fountainPen();
		p1.changeNib();
		Monkey m = new Human(); // if overridden displays human methods, if not monkey methods but cannot access only human methods independently
		m.bite();
		m.jump();
		tv t = new tv();
		t.on();
		t.mouse();
		Telephone tele = new smartTelephone();
		tele.disconnect();
		tele.lift();
		tele.ring();
	}

}
