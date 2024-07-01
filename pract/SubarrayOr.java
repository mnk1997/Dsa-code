package in.cdac.pract;

/*You are given an array of integers A of size N.

The value of a subarray is defined as BITWISE OR of all elements in it.

Return the sum of value of all subarrays of A % 109 + 7.*/

/*Input 1:

	 A = [1, 2, 3, 4, 5]
	Input 2:

	 A = [7, 8, 9, 10]


	Example Output
	Output 1:

	 71
	Output 2:

	 110


	Example Explanation
	Explanation 1:

	 Value([1]) = 1
	 Value([1, 2]) = 3
	 Value([1, 2, 3]) = 3
	 Value([1, 2, 3, 4]) = 7
	 Value([1, 2, 3, 4, 5]) = 7
	 Value([2]) = 2
	 Value([2, 3]) = 3
	 Value([2, 3, 4]) = 7
	 Value([2, 3, 4, 5]) = 7
	 Value([3]) = 3
	 Value([3, 4]) = 7
	 Value([3, 4, 5]) = 7
	 Value([4]) = 4
	 Value([4, 5]) = 5
	 Value([5]) = 5
	 Sum of all these values = 71
	Explanation 2:

	 Sum of value of all subarray is 110.*/

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayOr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
		System.out.println(solveOne(list));

	}

	public static int solve(ArrayList<Integer> A) {
		long ans = 0;
		long n = A.size();
		//n=n%1000000007;
		
		//long totalSubArrayCount=(n*(n+1))/2;
		long totalSubArrayCount=((n*(n+1))/2);
       // System.out.println("total subAarrat  count "+totalSubArrayCount);
		long totalCount = 0;
		for (int bit = 0; bit < 32; bit++) {
			long currCount = 0;
			for (int i = 0; i < n; i++) {
				// ans=(ans+(long)A.get(i))%1000000007;

				if ((A.get(i) & 1 << bit) == 0) {
					//currCount += 1;
					currCount = (currCount + 1) % 1000000007;
					// storing only that bit which will be used later..
					// currSum=(long) (currSum+(long)(n-i)*(Math.pow(2, bit))%1000000007);
					// count[bit]-=(n-i);
				} else {
					totalCount = (totalCount + ((currCount * (currCount + 1)) / 2) % 1000000007) % 1000000007;
					currCount = 0;
				}

			}
			totalCount = (totalCount+(currCount * (currCount + 1)) / 2)%1000000007;
		  long currAns=((totalSubArrayCount-totalCount)*(long)(Math.pow(2, bit)%1000000007))%1000000007;

         // System.out.println("curr Ans "+currAns);
		  ans=(ans+currAns)%1000000007;
		  totalCount=0;
			

		}

		return (int) (ans % 1000000007);
	}

	public static int solveOne(ArrayList<Integer> A) {
		long ans = 0;
		long n = A.size();
		n=n%1000000007;
		
		//long totalSubArrayCount=(n*(n+1))/2;
		long totalSubArrayCount=((n*(n+1))/2)%1000000007;
		long totalCount = 0;
		for (int bit = 0; bit < 32; bit++) {
			long currCount = 0;
			for (int i = 0; i < n; i++) {
				// ans=(ans+(long)A.get(i))%1000000007;

				if ((A.get(i) & 1 << bit) == 0) {
					//currCount += 1;
					currCount = (currCount +1)%1000000007;
					// storing only that bit which will be used later..
					// currSum=(long) (currSum+(long)(n-i)*(Math.pow(2, bit))%1000000007);
					// count[bit]-=(n-i);
				} else {
					totalCount += ((currCount * (currCount + 1)) / 2)%1000000007;
					currCount = 0;
				}

			}
			totalCount += ((currCount * (currCount + 1)) / 2)%1000000007;
		  long currAns=((totalSubArrayCount-totalCount)*(long)Math.pow(2, bit))%1000000007;
		  ans=(ans+currAns)%1000000007;
		  totalCount=0;
			

		}

		return (int) (ans % 1000000007);
	}

}
