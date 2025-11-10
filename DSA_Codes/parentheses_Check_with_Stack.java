/*
 * Title: Parenthesis Check Using Stack In Java 
 * Description: This code has two functions - one is to check if the entered equation has equal parenthesis(i.e opening and closing parenthesis in proper pairs)
 * and the other is a infix to postfix conversion program.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.Scanner;
//This class uses stack functionalities for parenthesis check and has all its basic operations like push,pop,isFull and isEmpty.
class parentStack{
	int size;
	int top=-1;
	char[] ch;
	parentStack(int len){
		this.size = len;
		this.ch = new char[size];
	}
	boolean isFull() {
		return top==ch.length-1;
	}
	boolean isEmpty() {
		return top==-1;
	}
	void push(char c) {
		if(isFull()) {
			System.out.println("Stack Overflow");
		}else {
				top++;
				this.ch[top]=c;
		}
	}
	char pop() {
		if(isEmpty()) {return 0;
		}else {
		char popch = ch[top];
		top--;
		return popch;
		}
	}
	
	char stackTop() {
		if(isEmpty()) {return 0;
		}else {
		return ch[top];}
	}
	
	//Function for checking if the character in equation is a operator
	boolean isOperator(char c) {
		if(c=='+'||c=='-'||c== '/'|| c=='*' ||c=='('||c==')') {
		return true;
		}else{
		return false;}
	}
	
	//Function for checking the precedence of a operator
	int checkPrecedence(char c) {
		if(c=='(') {
			return 3;
		}else if(c=='/'||c=='*') {
			return 2;
		}else if(c=='+'||c=='-') {
			return 1;
		}else {
			return 0;
		}
	}
}
public class parentheses_Check_with_Stack {

	public static void main(String[] args) {
		parentStack p = new parentStack(100);
		//This parenthesis check also works for a single type of parenthesis like () or multiple parenthesis all together like ()[]{}
		//System.out.println("Enter equation to check parenthesis: ");
		//System.out.println("Enter equation to check multiple parenthesis: ");
		System.out.println("Enter Infix equation to convert to Postfix: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] c = s.toCharArray();
		char[] postFix = new char[c.length];
		int i=0,j=0;
		//Single type parenthesis check
		//Time Complexity - O(N) and Space complexity - O(1)
		for(char element:c) {
			if(element == '('){
				p.push(element);
			}else if(element == ')'){
				p.pop();
			}
		}
		
		//Multiple type parenthesis check
		//Time Complexity - O(N) and Space complexity - O(N) if there's multiple opening brackets before any closing
		for(char element:c) {
			if(element == '(' || element == '[' || element == '{'){
				p.push(element);
			}else if(element == ')' && p.stackTop() == '('){
				p.pop();
			}else if(element == ']' && p.stackTop() == '['){
				p.pop();
			}else if(element == '}' && p.stackTop() == '{'){
				p.pop();
			}
		}
		
//		if(p.isEmpty()) {
//			System.out.println("Parenthesis is balanced");
//		}else {System.out.println("Parenthesis is unbalanced");}
		
		//Infix to Postfix expression
		//Time Complexity - O(N) and Space complexity - O(N)
		while(i<c.length){
			if(!p.isOperator(c[i])) {
				postFix[j++] = c[i++];
				}else if(c[i] == '(') {
	                p.push(c[i++]);
	            } else if (c[i] == ')') {
	                while(!p.isEmpty() && p.stackTop() != '(') {
	                    postFix[j++] = p.pop();
	                }p.pop(); // Remove '('
	                i++;
	            }
			else{while(!p.isEmpty() && p.stackTop() != '(' && p.checkPrecedence(c[i]) <= p.checkPrecedence(p.stackTop())){
                 postFix[j++] = p.pop();
             }
             p.push(c[i++]);			
             }
		}
		while(!p.isEmpty()) {
			postFix[j++]=p.pop();
		}
		for(char ele : postFix) {
			System.out.print(ele);
		}
	}
}
