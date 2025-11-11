/*
 * Title: Inheritance in Java
 * Description: The code includes inheritance using base and derived classes.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
class base
{int x;
int y;
int z;
base(){}
base(int a){
	//We use this keyword to reference an object of the class when there's two identical variables
	this.x = a;
	System.out.println("X :" + x);
}
public void setX(int a) {
	this.x = a;
}
public int getX() {
	return x;
} }

//When we use extends keyword, first the base class constructor runs then the derived class one.

class derived extends base{
	derived(){}
	derived(int a, int b){
		//Super constructor is used to access immediate parent class constructor
		super(a);
		this.y = b;
		System.out.println("Y :" +  y);
	};
	public void setY(int b) {
		//We can also use the super keyword to access parent class methods and variables
		super.getX();
		int a = super.x;
		System.out.println(a);
		this.y = b;
	}
	public int getY() {
		return y;
	} 
	}	

//constructors execute top to bottom in hierarchy.
//Extended classes can only access constructors of superclass and can only call them when overridden and not even by passing parameters or calling them as their own methods.
class thirdDerived extends derived{
	thirdDerived(int a, int b, int c){
		super(a,b);
		this.z = c;
		System.out.println("Z :" + z);
	}
	public void setZ(int c) {
		this.z = c;
	}
	public int getZ() {
		return z;
	} 
}
public class Inherit {

	public static void main(String[] args) {
		base b = new base();
		b.setX(2);
		System.out.println("X :" + b.getX());
		derived d = new derived();
		d.setX(7);
		System.out.println("X :" + d.getX());
		d.setY(2);
		System.out.println("Y :" + d.getY());
		thirdDerived t = new thirdDerived(11,234,356);
	}
}
