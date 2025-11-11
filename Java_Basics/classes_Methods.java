/*
 * Title: Classes and Methods in Java
 * Description: The code includes various types of classes, methods,constructors and functions.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.Scanner;
class square{
	static int side;
	//This is a constructor and it is the same name as class name. It is a member functions used to initialize an object.
	//It gets invoked when you make an object of the class and does not need to be called externally. It does not return a value.
	square(int s){
		this.side = s;
	}
	
	double getArea() {
		int area = side * side;
		return (double)area;
	}
	
	int getPerimeter() {
		int peri= 4 * side;
		return peri;
	}
}

class Phone{
	void ring() {System.out.println("Ringing...");}
	void vibrate() {System.out.println("Vibrating...");}
	void call() {System.out.println("Calling...");}
}

class rectangle{
	int length = 1,breadth = 1;
	//A constructor can have multiple or no parameters
	rectangle(int l,int b){
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
	int getPerimeter() {
		int peri = 2 * (length + breadth);
		return peri;
	}
}
class circle{
	static int radius;
	circle(int r){
		this.radius = r;
	}
	int getDiameter() {
		int dia= 2 * radius;
		return dia;
	}
	double getArea() {
		double area = 3.142 * (radius * radius);
		return (double)area;
	}
	double getCircumference() {
		double peri = 2 * 3.142 * radius;
		return (double)peri;
	}
}

	class cylinder{
		static int radius,height;
		void setRadius(int r) {
			radius = r;
		}
		void setHeight(int h) {
		height = h;	
		}
		
		int getRadius()
		{return radius;}
		static int getHeight() {
			return height;
		}
		
		double getSurfaceArea() {
			double SA = 2 * 3.14 * radius * (radius + height);
			return (double)SA;
			}
		
		double getVolume() {
			double V = 3.14 * radius * radius * height;
			return (double)V;
			}
	}
	
	class Employee {
		public static int salary = 10000;
		public String name = "Lia";
		//getter to get a value in the class that is often private
		int getSalary()
		{return salary;}
		String getName() {return name;}
		//setter to set a private value of the class
		void setName(String newName) {
			name = newName;
		}
	}
		
	public class classes_Methods{
	public static void main(String[] args) {
		//Employee class object
		Employee emp = new Employee();
		System.out.println(emp.getSalary());
		emp.setName("Rahul");
		System.out.println(emp.getName());
		
		//Square class object
		System.out.println("Enter side of square: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		square s1 = new square(n);
		sc.close();
		System.out.println("Perimemter of square: "+ s1.getPerimeter()+"\nArea of square: "+ s1.getArea());
		
		//Phone class object
		Phone onePlus = new Phone();
		onePlus.call();
		onePlus.ring();
		onePlus.vibrate();
		
		//rectangle class object
		rectangle rect = new rectangle(2,4);
		System.out.println("Perimemter of rectangle: "+rect.getPerimeter()+"\nArea of rectangle: "+rect.getArea());
	
		//circle class object
		circle c = new circle(3);
		System.out.println("Diameter of circle is:"+c.getDiameter()+"\nPerimemter of circle: "+c.getCircumference()+"\nArea of circle: "+c.getArea());
	
		//cylinder class object
		cylinder cy = new cylinder();
		cy.setHeight(5);
		cy.setRadius(2);
		System.out.println("Radius of cylinder: "+cy.getRadius()+"\nSurface Area of cylinder:" +cy.getSurfaceArea()+"\nVolume of cylinder:"+cy.getVolume());
	}
}
