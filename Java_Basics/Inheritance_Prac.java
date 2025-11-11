/*
 * Title: Practicing Inheritance and Javadocs in Java
 * Description: The code includes inheritance and Javadocs basics.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
class circle1{
	circle1(){}
	circle1(int r){
		this.radius = r;
	}
	static int radius;
	/**
	 * @param Radius of the Circle = r
	 * @return Area of Circle
	 */
		double getArea() {
		double area = 3.142 * (radius * radius);
		return (double)area;
	}
}

class cylinder1 extends circle1{
	static int radius,height;
static void setRadius(int r) {
	radius = r;
}
static void setHeight(int h) {
height = h;	
}

static int getRadius()
{return radius;}
static int getHeight() {
	return height;
}
//param - specifies the parameters used in the function
//return - tells us what return value the function gives when its unclear or a longer code.
/**
 * @param Radius of the Cylinder = r and height of cylinder
 * @return Area of Cylinder
 */
	@Override
	double getArea() {
	double SA = 2 * 3.14 * radius * (radius + height);
	return (double)SA;
	}
	/**
	 * @param Radius of the Cylinder = r and height of cylinder
	 * @return Volume of Cylinder
	 */
static double getVolume() {
	double V = 3.14 * radius * radius * height;
	return (double)V;
	}}
class rectangle1{
	static int length = 1,breadth = 1;
	rectangle1(){}
	rectangle1(int l,int b){
	if(l > b) {
		this.length = l;
		this.breadth = b;
	}else {
		this.length = b;
		this.breadth = l;
	}
	}
 int getArea() {
	int area = length * breadth;
	return area;
}
}
class cuboid extends rectangle1{
	static int height=1;
	cuboid(int l, int b, int h){
		super(l,b);
		this.height = h;
	}
	//We use this method tag to override functions of the extended parent class
	@Override 
	int getArea() {
		int area = 2*((length*breadth)+(breadth*height)+(height*length));
		return area;
	}
	int volume() {
		int vol = length * breadth * height;
		return vol;
	}
}
//We use author- to add author of the code
//version - to know what version of the update we are on
//since - to know when the code was last changed or written
//see - has reference links or material referenced in the code
/**
 * This is a class for Inheritance
 * @author ishas
 * @version 1
 * @since 06-07-2025
 * @see <a href = "https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/Set.html">Hello Everyone</a>
 */
public class Inheritance_Prac {
	/**This is the Inheritance class Constructor
	 * @param Empty
	 */
	Inheritance_Prac(){}
	/**
	 * This is the main class 
	 * @param args : For main class
	 */
	public static void main(String[] args) {
		circle1 c1 = new circle1(3);
		cylinder1 cy1 = new cylinder1();
		cy1.setRadius(2);
		cy1.setHeight(3);
		rectangle1 r1 = new rectangle1(2,4);
		cuboid cu1 = new cuboid(2,3,4);
		System.out.println("Area of Circle :" + c1.getArea());
		System.out.println("Area of Cylinder :" + cy1.getArea() + "\nVolume of Cylinder :"+ cy1.getVolume());
		System.out.println("Area of Rectangle :" + r1.getArea());
		System.out.println("Area of Cuboid :" + cu1.getArea() + "\nVolume of Cuboid :"+ cu1.volume());
	}

}
