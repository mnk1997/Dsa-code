package in.cdac.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*Given an array A of positive elements, you have 
 * to flip the sign of some of its elements such that
 *  the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).

Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.*/

/*A = [15, 10, 6]
Input 2:

A = [14, 10, 4]


Example Output

Output 1:

1
Output 2:

1*/
public class FlipArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(solveOne(Arrays.asList(15,8,4,2)));
		// System.out.println(solveOne(Arrays.asList(5,4,6,8,7,2,3)));
		 System.out.println(solveTwo(Arrays.asList(8,4,5,7,6,2)));
		
		/*
		 * System.out.println(solveOne(Arrays.asList(11, 10, 8, 6, 8, 11, 1, 10, 2, 3,
		 * 8, 3, 8, 12, 11, 1, 7, 5, 5, 12, 9, 4, 10, 3, 3, 3, 8, 8, 8, 6, 7, 7, 7, 6,
		 * 4, 2, 5, 8, 11, 10, 10, 10, 12, 9, 2, 3, 9, 12, 7, 6, 11, 8, 9, 9, 10, 3, 3,
		 * 5, 2, 10, 10, 9, 4, 9, 6, 11, 10, 2, 6, 1, 4, 7, 10, 3, 4, 3, 9, 4, 3, 8, 1,
		 * 1, 3)));
		 */
		 
		// System.out.println(solveOne(Arrays.asList(11,10,8,6,8,11,1,10,2,3,8,3,8,12,11,1,7,5,5,12,9,4,10,3,3,3,8,8,8,6,7,7,7,6,4,2,5,8,11,10,10,10,12,9,2,3,9,12,7,6,11,8,9,9,10,3,3,5,2,10,10,9,4,9,6,11,10,2,6,1,4,7,10,3,4,3,9,4,3,8,1,1,3)));
	}

	public static int solve(final List<Integer> A) {

		int totalSum = 0;
		int maxEle = 0;
		for (int i = 0; i < A.size(); i++) {
			totalSum += A.get(i);
			if (A.get(i) > maxEle) {
				maxEle = A.get(i);
			}
			// dp[i]=Integer.MAX_VALUE;
		}

		int requiredSum = totalSum / 2;
		int[][] dp = new int[A.size() + 1][requiredSum + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = A.size()+2;
			}
		}

		for (int idx = 1; idx <=A.size(); idx++) {
			for (int sum = 0; sum <= requiredSum; sum++) {
				if (sum == A.get(idx-1)) {
					dp[idx][sum] = 1;
				} else if (A.get(idx-1) > sum) {
					dp[idx][sum] = dp[idx- 1][sum];
				}
				else
				{
					dp[idx][sum]=Math.min(dp[idx-1][sum], 1+dp[idx-1][sum-A.get(idx-1)]);
				}
			}

		}

		for (int i = requiredSum; i >= 0; i--) {
			if (dp[A.size()][i] < (A.size()+2)) {
				return dp[A.size()][i];
			}

		}
		return 0;

	}

	public static int solveOne(final List<Integer> A) {

		int totalSum = 0;
		int maxEle = 0;
		for (int i = 0; i < A.size(); i++) {
			totalSum += A.get(i);
			if (A.get(i) > maxEle) {
				maxEle = A.get(i);
			}
			// dp[i]=Integer.MAX_VALUE;
		}

		int requiredSum = totalSum / 2;
		int[][] dp = new int[A.size() + 1][requiredSum + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = A.size()+2;
			}
		}

		for (int idx = 1; idx <=A.size(); idx++) {
			for (int sum = 0; sum <= requiredSum; sum++) {
				if (sum == A.get(idx-1)) {
					dp[idx][sum] = 1;
				} else if (A.get(idx-1) > sum) {
					dp[idx][sum] = dp[idx- 1][sum];
				}
				else
				{
					dp[idx][sum]=Math.min(dp[idx-1][sum], 1+dp[idx-1][sum-A.get(idx-1)]);
				}
			}

		}

		for (int i = requiredSum; i >= 0; i--) {
			if (dp[A.size()][i] < (A.size()+2)) {
				return dp[A.size()][i];
			}

		}
		return 0;

	}
	//optimizing space complexity from N*M to only M of dp array as it is using only last row
	public static int solveTwo(final List<Integer> A) {

		int totalSum = 0;
		int maxEle = 0;
		for (int i = 0; i < A.size(); i++) {
			totalSum += A.get(i);
			if (A.get(i) > maxEle) {
				maxEle = A.get(i);
			}
			// dp[i]=Integer.MAX_VALUE;
		}

		int requiredSum = totalSum / 2;
		int[][] dp = new int[2][requiredSum + 1];
		
			for (int j = 0; j < dp.length; j++) {
				dp[j] = A.size()+2;
			}
		

		for (int idx = 0; idx <A.size(); idx++) {
			for (int sum = 0; sum <= requiredSum; sum++) {
				if (sum == A.get(idx)) {
					dp[sum] = 1;
				} 
				else if(A.get(idx)>sum)
				{
					dp[sum]=dp[sum];
				}
				else
				{
					dp[sum]=Math.min(dp[sum], 1+dp[sum-A.get(idx)]);
				}
			}

		}

		for (int i = requiredSum; i >= 0; i--) {
			if (dp[i] < (A.size()+2)) {
				return dp[i];
			}

		}
		return 0;

	}

}
