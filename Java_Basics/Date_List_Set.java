/*
 * Title: ArrayList, date and Calendar Class in Java
 * Description: The code includes arraylist functions, Calender and date functions.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date_List_Set {
	//This is a method tag and date is a deprecated method no longer in use in the newer java versions.
	@Deprecated
	public static void myDateMethod() {
		//Date in java is stored in the form of a long number. This number is the number of milliseconds since 1 Jan, 1970.
		Date d = new Date();
		System.out.println("From Date class :"+d.getHours()+":"+d.getHours()+":"+d.getMinutes());
	}
	//This tag suppresses the warnings in output
	@SuppressWarnings(value = { "deprecation" })
	public static void main(String[] args) {
		//ArrayList Class and functions
		ArrayList<Integer> arr1 = new ArrayList<Integer>(10);
		ArrayList<String> arr2 = new ArrayList<String>(10);
		ArrayList<String> arr3 = new ArrayList();
		String[] str = {"Kylie","Khloe","Kris","Kourtney","Kendall","Caitlyn","Katrina","Rob","Bruce","North"};
		for(String s : str) {
		arr3.add(s);
		}
		arr1.add(0,11);//adds to arraylist, we can also put it at a specific index mentioned at the front of element.
		arr1.add(22);
		arr1.add(33);
		arr1.add(44);
		arr1.add(55);
//		arr2.add(34);
//		arr2.add(45);
//		arr1.addAll(arr2);//copys one list into another
		arr1.trimToSize();
		System.out.println(arr3);
		System.out.println(arr1.subList(1,4));
		for(int i : arr1) {
			System.out.println(i);
		}
		//This function returns number of seconds passed since 1 Jan,1970 and we can use it to find hours, minutes and seconds.
		//System.currentTimeMillis(); --doesn't need any package to be imported can use directly to get time
		//Calendar class
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTimeZone());
		System.out.println(c.getTimeInMillis()/1000/3600/24/30);
		System.out.println(c.WEEK_OF_MONTH);
		System.out.println(c.HOUR_OF_DAY+":"+c.MINUTE+":"+c.SECOND);
		//This class is part of java.time package. It gives us date and time.
		LocalDateTime dt = LocalDateTime.now();
		String text = dt.toString();
		//This class is for a formatter for displaying and parsing date-time objects.
		DateTimeFormatter df = DateTimeFormatter.ofPattern("d-M-u H:m:s");//We can various different patterns like "dd-mm-yyyy",etc.
		String myTime = dt.format(df);
		System.out.println(myTime);
		//Set is an interface we implement using HashSet class. We use it to store unique elements of the same data type.
		Set<Integer> mySet = new HashSet<>(5);
		mySet.add(1);
		mySet.add(2);
		mySet.add(12);
		mySet.add(33);
		mySet.add(2);
		System.out.println(mySet);	
	}
}
