package in.cdac.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
You are given a 2-D matrix C of size A × B.
You need to build a new 1-D array of size A by taking one element from each row of the 2-D
 matrix in such a way that the cost of the newly built array is minimized.

The cost of an array is the minimum possible value 
of the absolute difference between any two adjacent elements of the array.

So if the newly built array is X, the element picked from row 1 will become X[1],
 element picked from row 2 will become X[2], and so on.

Determine the minimum cost of the newly built array.*/

/*Input 1:

	 A = 2
	 B = 2
	 C = [ [8, 4]
	      [6, 8] ]
	Input 2:

	 A = 3
	 B = 2
	 C = [ [7, 3]
	       [2, 1]
	       [4, 9] ]


	Example Output
	Output 1:

	 0
	Output 2:

	 1


	Example Explanation
	Explanation 1:

	 Newly build array : [8, 8]. The minimum cost will be 0 since the absolute difference will be 0(8-8).
	Explanation 2:

	 Newly build array : [3, 2, 4]. The minimum cost will be 1 since the minimum absolute difference will be 1(3 - 2).*/

public class MinimumDifference {
	// break the problem for smaller part
	// consider only 2 array then min possible diff can be 0 and max possible can be
	// MAX(a[n-1]-b[0],b[0]-a[n-1])
	// 5,8,9,2,7,15,25,6 ===> 2,5,6,7,8,9,15,25
	// 24,100,90,11,34,40 ===> 11,24,34,40,90,100

	// sort each row
	// find the difference between the adjacent arrays usign 2 pointer
          //for the first row we need to find the element having minimum difference using brute force 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * ArrayList<ArrayList<Integer>> list = new ArrayList<>( Arrays.asList(new
		 * ArrayList<>(Arrays.asList(8, 4)), new ArrayList<>(Arrays.asList(6, 8))));
		 */
		ArrayList<ArrayList<Integer>> list = new ArrayList<>(
				Arrays.asList(new ArrayList<>(Arrays.asList(5,8,9,2,7,15,25,6)), new ArrayList<>(Arrays.asList(24,100,90,11,34,40))));
		// new ArrayList<>(Arrays.asList(27,25)))

		System.out.println("Differnce " + minDifference(list));
	}

	public static int minDifference(ArrayList<ArrayList<Integer>> list) {
		// sort each row of array N Tc:N2logN
		for (ArrayList<Integer> row : list) {
			Collections.sort(row);
		}
		int minDiff = Integer.MAX_VALUE;
		//
		/*
		 * for (int i = 0; i < list.size() - 1; i++) { int firstPtr = 0; int secondPtr =
		 * 0; int currDif = Integer.MAX_VALUE; while (firstPtr < list.get(i).size() &&
		 * secondPtr < list.get(i + 1).size()) { currDif =
		 * Math.abs(list.get(i).get(firstPtr) - list.get(i + 1).get(secondPtr)); if
		 * (minDiff > currDif) minDiff = currDif; if (list.get(i).get(firstPtr) <
		 * list.get(i + 1).get(secondPtr)) firstPtr++; else secondPtr++; } }
		 */
		
	//	int diff=usingBruteForce(list);
        int bDiff=usingBinarySearch(list);
		return bDiff;

	}

	private static int usingBinarySearch(ArrayList<ArrayList<Integer>> list) {
		// TODO Auto-generated method stub
		//what are observation using brute force is we will try to find the number nearest to the 
		//ele of row 1
		//so that it will result in min Diff. TC -O(NlogN)
		
		int bDiff=Integer.MAX_VALUE;
		int i=0;
		while(i<list.get(0).size())
		{
			//int mid=l+(r-l)/2;
			int currDiff=findEleNearToGivenVal(list.get(0).get(i),list);
			System.out.println("for val "+list.get(0).get(i)+" min possible diff possible is "+currDiff);
			i++;
			if(bDiff>currDiff)
				bDiff=currDiff;
			
		}
		return bDiff;
	}

	private static int findEleNearToGivenVal(Integer val, ArrayList<ArrayList<Integer>> list) {
		int l=0;
		int r=list.get(1).size();
		int minDiff=Integer.MAX_VALUE;
		while(l<=r)
		{
			int mid=l+(r-l)/2;
			int sameDiff=Math.abs(list.get(1).get(mid)-val);
			int leftDiff=mid!=0?Math.abs(list.get(1).get(mid-1)-val):Integer.MAX_VALUE;
			int rightDiff=mid!=list.get(1).size()-1?Math.abs(list.get(1).get(mid+1)-val):Integer.MAX_VALUE;
			if(sameDiff<=minDiff && sameDiff<=leftDiff && sameDiff<=rightDiff)
			{
				minDiff=sameDiff;
				return minDiff;
			}
			else if(leftDiff<=minDiff && leftDiff<=sameDiff && leftDiff<=rightDiff)
			{
				minDiff=leftDiff;
				r=mid-1;
			}
			else if (rightDiff<=minDiff && rightDiff<=leftDiff && rightDiff<=sameDiff)
			{
				minDiff=rightDiff;
				l=mid+1;
			}
			else
			{
				System.out.println("can never be here!!!!!!!!!!");
				break;
			}
		}
		return minDiff;
	}

	private static int usingBruteForce(ArrayList<ArrayList<Integer>> list) {
		// TODO Auto-generated method stub
		//here for each ele of row 1 compare with each value of row 2
		//TC . - O(N2*N2)=>O(N4)
		return Integer.MAX_VALUE;
	}
	
	

}
