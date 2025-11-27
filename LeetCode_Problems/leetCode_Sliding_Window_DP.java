/*
 * Title: More Array Questions in Leetcode with solutions
 * Description: The code includes more array questions like BFS, DFS, and Two-pointer sliding window problems like longest mountain, minimum absolute sum, etc.
 * Also, Two pointer and Dynamic Programming questions
 * Author: Isha Shelke
 * Last Updated: November 2025
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class NumArray {
	//This is the function to make a preSum array.
	//It uses a preSum approach in which we use a preSum array to store sum upto that number in that position
	//Input - Array of integers
	//Output - PreSum Array with sum of each number at given index
	int[] preSum;
    public NumArray(int[] nums) {
    	 preSum = new int[nums.length+1];
    	   preSum[0] = 0;
    	   for(int i=1; i<preSum.length;i++) {
    		   preSum[i] = nums[i-1] + preSum[i-1];//sum every number upto current number
    	   }
    }
    	//This is the function returns sum of numbers in an array in a given range.
    	//Input - left - start index and right - end index of the range
    	//Output - Sum of numbers in that range
    	//Time Complexity - O(M * N) and Space Complexity - O(M * N) where
    public int sumRange(int left, int right) {
        //Return sum using the prefix sum
    	 int val;
    	    val = preSum[right+1]-preSum[left];
    	 return val;
    }
}

public class leetCode_Sliding_Window_DP {
	//This is the function for counting the number of islands in a matrix i.e. number of continuous connected 1s are one island and there can be multiple.
	//Input - Two-Dimensional matrix containing islands
	//Output - Number of islands in the matrix
	//Time Complexity - O(M * N) and Space Complexity - O(M * N) where M is the number of rows in the matrix and N is the number of columns.
	//Space Complexity is more from maintaining a boolean visited matrix.
//	static int numIslands(char[][] grid) {
//		int count = 0, rows= grid.length,cols = grid[0].length;
//		boolean[][] visited = new boolean[rows][cols];//to check if each vertex is visited or not
//      for(int i=0; i<rows; i++) {
//		for(int j = 0; j<cols;j++){
//			if(grid[i][j] == '1' && visited[i][j]!=true) {
//				BFS(grid,visited,i,j);//call for function to search all its neighbours
//				count++;
//			}
//		}
//	}
//   return count;
//    }	
//Helper function for numIslands to check each index
//static void BFS(char[][] grid, boolean[][] visited,int i,int j) {
//	int rows = grid.length;
//    int cols = grid[0].length;
//    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};//all directions near the vertex up-down-left-right
//	Queue<int[]> q = new LinkedList<>();//To add vertices from all directions and check if they're visited
//	q.add(new int[]{i, j});//add given vertex
//	visited[i][j] = true;
//	while(!q.isEmpty()) {
//		int[] cell = q.poll();//remove from queue, add the cell array
//        int r = cell[0], c = cell[1];//add row and column indices to it
//        for(int[] d: directions) {
//        	//check all directions of the element 1 and not visited
//        	int nr = r + d[0];
//        	int nc = c + d[1];
//        	//check for nr and nc being within matrix limits and simply add to queue if unvisited and being 1
//        	if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1' && !visited[nr][nc])
//        	{
//                    visited[nr][nc] = true;
//                    q.add(new int[]{nr, nc});//add new index to queue
//                }
//        }
//	}	
//}

//Quicker solution for number of islands using DFS
//Space Complexity becomes O(1) because no need to maintain visited matrix
static int numIslands(char[][] grid) {
    int count=0;
  for (int i =0;i<grid.length;i++){
      for (int j =0; j<grid[0].length;j++){
          if(grid[i][j]=='1'){
              count++;
              dfs(grid,i,j);
          }
      }
  }
  return count;
}
 static void dfs(char[][] grid, int i , int j){
   if(i<0|| j < 0 || i>= grid.length|| j>=grid[0].length|| grid[i][j]=='0'){
      return;//skip all 0 elements or out of range ones
  }
  grid[i][j]='0';//set as zero so next iteration ignores it
  //check all its neighbours
  dfs(grid, i+1,j);
  dfs(grid, i,j+1);
  dfs(grid, i-1,j);
  dfs(grid, i,j-1);
}

//This is the function to know the best time to buy and sell stocks.
//This uses a two pointer approach and gives us the biggest positive difference between the numbers i.e. low start price, high end price.
//Input - Array containing prices
//Output - Maximum profit price
//Time Complexity - O(N) and Space Complexity - O(1)
static int maxProfit(int[] prices) {
    int maxP = 0;
    int left=0,right = 1,profit;//start with left in the first position and right in the second so we can search all possible iterations
    while(right!=prices.length) {
    	//check lower buying and greater selling price
    	if(prices[left]<prices[right]){
    		profit = prices[right] - prices[left];
    		maxP= Math.max(maxP,profit);//update max profit if true
    	}//move forward otherwise
    	else{
    		left=right;
    	}right+=1;
    }
    return maxP;
}

//This is the function to square each element in an array and also sort it
//Input - An Array
//Output - Resulting Array with squared and sorted elements
//Time Complexity - O(N) and Space Complexity - O(N) for resulting array but still eliminates the need for extra sort space by using in-place sort
static int[] sortedSquares(int[] nums) {
	int l=0, r = nums.length-1,j = nums.length-1;
	int[] res = new int[nums.length];
	while(l<=r) {
		int left = nums[l]*nums[l], right = nums[r]*nums[r];
		if(left>right) {
			res[j--] = left;//put left at the right end i.e the higher end of array
			l++;
		}else {
			res[j--]=right;//put right at the right end i.e the higher end of array
			r--;
		}
	}
    return res;
}

//This is the function to know the longest mountain in an array i.e every number before peak is increasing towards it and every number after is decreasing from it.
//Input - Array with a mountain
//Output - Range of the mountain
//Time Complexity - O(N) and Space Complexity - O(1)
static int longestMountain(int[] arr) {
	int range=0;
	for(int i=1;i<arr.length-1;i++) {
		//check for peak
		if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
			int l=i,r=i;
			//move to left if its strictly increasing
			while(l>0 && arr[l-1]<arr[l]) {
				l--;
			}
			//move to right if its strictly decreasing
			while(r<arr.length-1 && arr[r]>arr[r+1]) {
				r++;
			}
			range = Math.max(range,r-l+1);
		}
	}
    return range;
}

//This is the function to know if the array has duplicates but their absolute index difference should be less than or equal to k.
//Input - Array and k variable 
//Output - True if index difference is less than k
//Time Complexity - O(N) and Space Complexity - O(N)
static boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> seen = new HashSet<>();
    for(int i=0; i<nums.length;i++) {
    	if(seen.contains(nums[i])) {
    		return true;//duplicate exists within the k window
    	}
    	seen.add(nums[i]);//add current number to set
    	if(seen.size()>k) {
    		seen.remove(nums[i-k]);//maintain k elements window size
    	}
    }
    return false;
}

//This is the function to know minimum absolute difference.
//Input - Array  
//Output - List of elements with differences equal to minimum Absolute Difference
//Time Complexity - O(N) and Space Complexity - O(N) for number of absolute pairs found
static List<List<Integer>> minimumAbsDifference(int[] arr) {
	List<List<Integer>> res = new ArrayList<>();
	int minAbsolute = Integer.MAX_VALUE;//set to find minimum difference
	Arrays.sort(arr);//sort to find different pairs
	for(int i=0; i<arr.length-1; i++){
		if(Math.abs(arr[i+1]-arr[i])<minAbsolute) {
			minAbsolute = Math.abs(arr[i+1]-arr[i]);//get the minAbsolute difference from the array
		}
	}
	
    for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i + 1] - arr[i] == minAbsolute) {
            res.add(Arrays.asList(arr[i], arr[i + 1]));//add all pairs with the min difference to list
        }
    }	return res;
}

//This is the function to get minimum length of elements required to make the target sum or higher.
//Input - Array  
//Output - Size of the minimum element subarray required to get the target sum
//Time Complexity - O(N) and Space Complexity - O(1)
static int minSubArrayLen(int target, int[] nums) {
  int count = Integer.MAX_VALUE; //set to max to find the minimum count
  int total = 0;
  int l=0;
  for(int r=0; r<nums.length;r++) {
	  total += nums[r];//keep adding numbers to total till it becomes greater than or equal to target
	  while(total>=target) {
	//try to shrink the window while total is greater than target because we need the minimum subarray
	  count = Math.min(count,r-l+1);//update count from distance between right and left
	  total-=nums[l];
	  l++;//removing till sum<target
  	}
  }
  if(count == Integer.MAX_VALUE) {
	  return 0;//subarray not found
  }
  else {
	  return count;
  }
}

//This is the function to find the only number that occurs once in the array, all the rest occur twice.
//Bit Manipulation - The Solution uses XOR.It cancels if same numbers occur.
//Input - Array  
//Output - Returns the only single number
//Time Complexity - O(N) and Space Complexity - O(1)
static int singleNumber(int[] arr) {
	    int no = 0;
	    for (int n : arr) {
	        no ^= n;
	        //0 XOR n will give us n, but if the next number is n, n XOR n gives us 0 again. So the number left behind is always the single one
	    }
	    return no;
	}

//static int coinChange(int[] coins, int amount) {
//	int[] memo = new int[amount + 1];
//    Arrays.fill(memo, -2); // -2 = uncalculated
//    return helper(coins, amount, memo);
//}
//
//static int helper(int[] coins, int amount, int[] memo1) {
//    // your current logic, but replace coinChange(...) calls with helper(...)
//	int min_count=Integer.MAX_VALUE;
//	if(amount == 0) {return 0;}
//	if(amount < 0) {return -1;}
//	if (memo1[amount] != -2) {
//	    return memo1[amount];
//	}
//	for (int coin : coins) {
//        int res = helper(coins, amount - coin,memo1);
//        // If a solution exists for the subproblem
//        if (res >= 0 && res < min_count) {
//            min_count = 1 + res;
//        }
//    }    
//	memo1[amount] = (min_count == Integer.MAX_VALUE) ? -1 : min_count;
//	return memo1[amount];
//}

//This is the function to find the minimum number of coins required to make the amount exactly.
//This is a bottom-up Dynamic Programming Approach in which, we first find dp[i-c] which are the smaller amounts and then work our way up
//It is always important to know the first few or the zeroth element or to establish it when using dp[] to build up on operations
//Input - Available Coins Array and the amount to make
//Output - Minimum number of coins required
//Time Complexity - O(amount * number of coins) and Space Complexity - O(amount)
static int coinChange(int[] coins, int amount) {
	int[] dp = new int[amount+1];
	Arrays.fill(dp, amount+1);//fill all at amount+1
	dp[0]=0;
	for(int i=1;i<dp.length;i++) {
		for(int c : coins){
			if(i-c>=0) {
				//Example - For case 1 : i=1 and c=1, so i-c = 1-1 =0.
				//Inside loop, dp[1] is already 12 and dp[0] = 0+1 for using a coin. So, it goes up 11 coins of 1 and then it checks for coin 2
				dp[i] = Math.min(dp[i],1+dp[i-c]);//dp[i-c] for the amount remaining and +1 for using one coin
				//dp already holds the optimal combination for each number and then builds up the required amount
				/*
				 * dp[1] = 1
				 * dp[2] = 2
				 * dp[5] = 1
				 * dp[6] = dp[5] +1 = 2
				 * dp[11] = dp[6] +1 = 2+1 and that's 3 the answer*/
			}
		}
	}
	return (dp[amount] != 1+amount) ? dp[amount] : -1;//if dp[amount] is equal to amount+1, it means the amount was never updated and so return -1, dp[amount] otherwise
}

//This is the function to climb the stairs.
//It takes n steps to reach the top, and you can only take 1 or 2 steps
//This is a bottom-up Dynamic Programming Approach.
//Input - Number of stairs
//Output - All number of ways to reach the top
//Time Complexity - O(N) where N is the number of stairs and Space Complexity - O(1)
static int climbStairs(int n) {
	//We already know that if its till 3 steps, 1 stair has only 1 way to reach it, 2 stairs have 2 ways 2 and 1+1
	//And 3 stairs have 3 ways 1+1+1,1+2, and 2+1, so till n<=3, we have fixed results
	if(n <= 3) {return n;}
	int prev1=3,prev2=2,curr=0;
	//Therefore, we use dynamic approach to climb the stairs starting from 3 upto n and return the number of ways.
	for(int i=3;i<n;i++){
		curr = prev1+prev2;
		prev2 = prev1;
	    prev1 = curr;
	}
	return curr;
	//Same solution written in dp using an extra array. It uses more space.
	//Space Complexity - O(number of stairs)
//	int[] dp = new int[n+1];
//	dp[0]= 0;
//	dp[1] = 1;
//	dp[2] = 2;
//	for(int i=3; i<n+1 ; i++) {
//	dp[i] = dp[i-1] + dp[i-2];
//	}
//	return dp[n];
}

//This is the function to find the maximum subarray in the given array which gives us the maximum sum value
//This is a Top-Down Dynamic Programming Approach.
//Input - Array of Integers
//Output - Maximum sum possible
//Time Complexity - O(N) and Space Complexity - O(N)
static int maxSubArray(int[] nums) {
    int maxArray = 0;
    int[] dp = new int[nums.length];//make new array the same size as nums array
    dp[0] = nums[0];//initialize the first element
    for(int i=1; i<nums.length;i++){
    	dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);//find the sum upto that point in nums
    	/*
    	 * [-2,1,-3,4,-1,2,1,-5,4]
    	 * dp[1] = 1
    	 * dp[2] = -2
    	 * dp[3] = 4
    	 * dp[4] = 3
    	 * dp[5] = 5
    	 * dp[6] = 6
    	 * dp[7] = 1
    	 * dp[8] = 5
    	 * */
    }
    for(int d : dp) {
    	if(d>maxArray) {
    		maxArray = d;//find the maximum in dp[] array and that's the max sum 
    	}
    }
    return maxArray;
}

public static void main(String[] args) {
		char[][] grid = {
	            {'1','1','0','0','0'},
	            {'1','1','0','0','0'},
	            {'0','0','1','0','0'},
	            {'0','0','0','1','1'}
	        };
	        System.out.println(numIslands(grid));
	        
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
		
		int[] sqrArr = {-4,-1,0,3,10};
		int[] res = sortedSquares(sqrArr);
		for(int x : res) {
			System.out.print(x + " ");
		}System.out.println();
		
		int[] longMount = {2,1,4,7,3,2,5};
		System.out.println(longestMountain(longMount));
		
		int[] conDupli = {1,2,3,1};
		int k = 2;
		System.out.println(containsNearbyDuplicate(conDupli,k));
		
		int[] arr = {4,2,6,0};
		System.out.println(minimumAbsDifference(arr));
		
		int[] minSubArr = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7,minSubArr));
		
		int[] singleNo = {2,1,2,1,4};
		System.out.println(singleNumber(singleNo));
		
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println(coinChange(coins,amount));
		
		int n = 6;
		System.out.println(climbStairs(n));
		
	int[] maxSub = {-2,1,-3,4,-1,2,1,-5,4};
	System.out.println(maxSubArray(maxSub));
	
	int[] nums = {-2, 0, 3, -5, 2, -1};
	NumArray obj = new NumArray(nums);
	System.out.println(obj.sumRange(0, 2));
	System.out.println(obj.sumRange(2, 5)); 
	System.out.println(obj.sumRange(0, 5));	
	}
}
