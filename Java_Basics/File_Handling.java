/*
 * Title: File Handling in Java
 * Description: The code includes reading,writing and deleting a file using File class in Java.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.*;
import java.io.*;
public class File_Handling {
	public static void main(String[] args) {	
		//Creating a new File
		File myFile1 = new File("Deletion.txt");//We use file class to create an object.
		//We use a try-catch block to avoid the file not found error.
		try {
			myFile1.createNewFile();//creates a file
		} catch (IOException e) {
			e.printStackTrace();//prints the error route
		}
		
		//Writing to a file
		try {
			//we use this class for writing to a file
			FileWriter fw = new FileWriter("Tables.txt");
			int arr[] = {2,3,4,5,6,7,8,9};
			for(int no : arr) {
			for(int i=1;i<=10;i++) {
				int pro = no*i;
				fw.write(pro + " ");
			}
			fw.write(System.getProperty("line.separator"));			
			}
			fw.close();//it is a good practice to close the file
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Reading a file - reads the given file's lines in console
		File myFile = new File("Tables.txt");
		Scanner sc;
		try {
			sc = new Scanner(myFile);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				System.out.println(line);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		//Deleting a file always be careful while using this function
		if(myFile1.delete()) {
			System.out.println("File Deleted :" + myFile1.getName());
		}
		else {
			System.out.println("Could not delete file");
		}
	}
}
