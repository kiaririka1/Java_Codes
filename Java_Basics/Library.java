/*
 * Title: Library in Java
 * Description: The code includes implementation of a basic library using arrays and interface in Java
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.Arrays;
import java.util.*;
interface BooksInLibrary{
	void showAvailableBooks();
	void addBook(String singleBook);
}

class givenBooks implements BooksInLibrary{
	String[] books = {"1. Catcher in the Rye","2. Everything,Everything","3. Meet Cute","4. The Art of Seduction","5. Turtles on the way down","6. The Sun is Also a Star"};
	String[] newBooks;
	//Time Complexity - O(N) and Space complexity - O(N)
	public void showAvailableBooks() {
		for(String i : books) {
			System.out.println(i);
		}
	}
	
	//Time Complexity - O(N+1) and Space complexity - O(N + 1)
	public void addBook(String singleBook) {
		newBooks = Arrays.copyOf(books, books.length +1);
		newBooks[newBooks.length -1] = singleBook;
		for(String i : newBooks) {
			System.out.println(i);
		}	
	}
	
	//Time Complexity - O(1) and Space complexity - O(1)
	String issueBook(int no) {
		if(newBooks == null) {
			return books[no];
		}
		else {
			return newBooks[no];
		}
	}
	
	//Time Complexity - O(N+1) and Space complexity - O(N+1)
	public void returnBook(String book) {
		System.out.println("You have returned the book: "+book);
		System.out.println("Books in the system now :");
		addBook(book);
	}
}
public class Library {
	public static void main(String[] args) {
givenBooks g = new givenBooks();
g.showAvailableBooks();
Scanner sc = new Scanner(System.in);
g.addBook("7. Nice to Meet You");
System.out.println("Enter the number of book you want to issue: ");
int issue = sc.nextInt();
System.out.println("You have issued the book :" + g.issueBook(issue-1));
g.returnBook("8. Rivers");
	}
}
