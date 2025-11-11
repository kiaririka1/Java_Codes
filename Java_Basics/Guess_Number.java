/*
 * Title: Guess the Number Game in Java
 * Description: The code includes guess the number game between 1 to 100.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.*;
public class Guess_Number{
	private static int randomNo;
	static int noOfGuesses;
Guess_Number(){
	Random r = new Random();
	 randomNo = r.nextInt(1,100);
}

//Time Complexity - O(1) and Space Complexity - O(1)
static int takeUserInput()
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Guess the number(1-100): ");
	int inGuess = sc.nextInt();
	return inGuess;
}

//Time Complexity - O(log N) and Space Complexity - O(log N)
static boolean isCorrectNumber(int no) {
	if(no > randomNo){
		System.out.println("Guessed number is greater than correct number, guess again!");
		noOfGuesses++;
		return false;
	}else if(no < randomNo) {
		System.out.println("Guessed number is smaller than correct number, guess again!");
		noOfGuesses++;
		return false;
	}else
		{System.out.format("You have guessed the correct number in %d guesses!\n",noOfGuesses);
		return true;}
}

////Time Complexity - O(k) and Space Complexity - O(1) where k is the number of guesses
	public static void main(String[] args) {
		boolean isCorrect= false;
		Guess_Number g1 = new Guess_Number();
		while(!isCorrect) {
		int inp = g1.takeUserInput();
		isCorrect = g1.isCorrectNumber(inp);
		}
	}
}
