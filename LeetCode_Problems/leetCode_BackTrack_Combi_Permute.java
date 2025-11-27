/*
 * Title: Permutations and Combination Questions in Leetcode with solutions
 * Description: The code includes various permutations and combination questions like powersets, lettercase permutations, combinations,etc. solved using backtracking.
 * Author: Isha Shelke
 * Last Updated: November 2025
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//backtracking questions
public class leetCode_BackTrack_Combi_Permute {
	//This is the function for making power sets from a given array.
	//Input - Array to get its Power Set
	//Output - List of all Power Sets
	//Time Complexity - O(n * 2^n) and Space Complexity - O(n * 2^n)
	//There are 2*n subsets for each n element.
	static List<List<Integer>> subsets(int[] nums) {
	List<List<Integer>> res = new ArrayList<>();
	res.add(new ArrayList<>());
	for(int num : nums){
	    int size = res.size();
	    for (int i=0; i< size;i++){
	    	List<Integer> newSubset = new ArrayList<>(res.get(i));
	    	newSubset.add(num);
	    	res.add(newSubset);
	    }
	 }
	return res;
}
	
//This function gives all possible combinations of array elements changing only their positions
//Here, we use backtracking to make sure the code doesn't take same input in different positions like [1,2] and also [2,1]
//By incrementing start, we make sure that the further values remaining are strictly greater than the start number in the recursive call
//This makes sure every combination is unique
//Input - n- numbers upto which to use to make combinations i.e. it starts from 1 so n=4 makes 1,2,3,4 possible numbers for combinations.
//k - size of subsets to form like each subset should be of size 2
//Output - List of all possible combinations 
//Time Complexity - O(k * C(n,k)) and Space Complexity - O(k * C(n,k))
//There are 2*n subsets for each n element.
static List<List<Integer>> combine(int n, int k) {
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> newSubset = new ArrayList<>();//stores a subset of size k
	backtrack(1,n,k,newSubset,res);
	return res;
}

static void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> res) {
    if (current.size() == k) {
        res.add(new ArrayList<>(current));
        return;
    }    
    for (int i = start; i <= n; i++) {//from 1 to given n
        current.add(i);
        backtrack(i+1,n,k,current,res);//start gets incremented to only look at numbers greater than it but less than n for combinations
        current.remove(current.size() - 1);//resets to last start to get all combinations and i increments when all combinations with n are reached
    }  
}
	
//This is the function for returning an array res of length n + 1 such that for each i (0 <= i <= n),
//ans[i] is the number of 1's in the binary representation of i.
//Input - Total number of 1's present in the array
//Output - Array of numbers which represent the number of 1's present in the current number
//Time Complexity - O(n * 2^n) and Space Complexity - O(n * 2^n)
static int[] countBits(int n) {
    int[] res = new int[n+1];
    res[0] = 0;
    int offset = 1;
    for(int i=1; i<n+1;i++) {
    	if(offset*2 == i) {//updating offset for every current highest power of 2
    		offset = i;
    	}
    res[i] = 1 + res[i - offset];//removing the lead number
    /**
     * for i=1, res[1] = 1 + res[1-1] = 1
     * for i=2, offset = 2, res[2] = 1 + res[2-2] = 1+0 = 1
     * for i=3, offset = 2, res[2] = 1 + res[3-2] = 1+1 = 2
     * for i=4, offset = 4, res[2] = 1 + res[4-4] = 1+0 = 1
     * for i=5, offset = 4, res[2] = 1 + res[5-4] = 1+1 = 2 and so on
     * */
    }
    return res;
}

//This is the function for returning a list of strings with all different cases for different character in a given string
//We use backtracking for it and either swap the character's case or keep it the same and cover all those cases
//Input - String of letters to operate on
//Output - List of string with different cases
//Time Complexity - O(n * 2^n) and Space Complexity - O(n * 2^n)
static List<String> letterCasePermutation(String s) {
   List<String> res = new ArrayList<>();
   charBacktrack(s.toCharArray(), 0, res);
   return res;
}

static void charBacktrack(char[] chars, int index, List<String> res) {
	// If we've processed all characters, add the current permutation to the result
   if (index == chars.length) {
       res.add(new String(chars));
       return;//backtrack for other possibilities
   }
//Keep the current character as it is
   charBacktrack(chars, index + 1, res);

	//OR check if the char is a letter then change its case
   if (Character.isLetter(chars[index])) {
       chars[index] = Character.isUpperCase(chars[index]) 
                       ? Character.toLowerCase(chars[index]) 
                       : Character.toUpperCase(chars[index]);
       charBacktrack(chars, index + 1, res);// Recurse with flipped character
	// Undo the flip before returning to previous state
       chars[index] = Character.isUpperCase(chars[index])
                       ? Character.toLowerCase(chars[index]) 
                       : Character.toUpperCase(chars[index]);
   }
}

//This is a function to get all possible permutations of a array using backtracking
//Input - Array to operate on
//Output - All possible permutations of the array
//Time Complexity - O(n * n!) and Space Complexity - O(n * n!) for output and O(N) for recursion
static List<List<Integer>> permute(int[] nums) {
	List<List<Integer>> res = new ArrayList<>();
	permuteBacktrack(0,nums.length,nums,res);//start backtracking from index 0
	return res;
}

static void permuteBacktrack(int start, int end,int[] nums,List<List<Integer>> res) {
    if (start == end) {
    	List<Integer> perm = new ArrayList<>();
    	for (int n : nums) {
    	    perm.add(n);//add each number into the list in given positions
    	}
    	res.add(perm);//add permutation to result list        
    	return;
    }
    	for (int i = start; i < end; i++) {
    		swapPermute(i,start,nums);//choose a nums[i] to be placed into the (fixed) start position
            permuteBacktrack(start+1,end,nums,res);//recurse for to fix the next index
            swapPermute(i,start,nums);//return to original position(backtracking)
        }
}

//Just a swapping function
static void swapPermute(int i, int j, int[] nums) {
	int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

	public static void main(String[] args) {
		int n=4,k=2;
		System.out.println(combine(n,k));

		int[] bitCount = countBits(n);
		for(int b : bitCount) {
		System.out.println(b);}

		String str = "a1b2";
		System.out.println(letterCasePermutation(str));

		int[] nums = {1,2,3};
		List<List<Integer>> res = permute(nums);
		System.out.println(res);
	}
}
