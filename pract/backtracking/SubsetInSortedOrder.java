package in.cdac.pract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*[1,2,3,4] : [1] [1,2] [1,2,3][1,2,3,4] [1,3] [1,3,4] [1,4] [2] [2,3] .........*/
public class SubsetInSortedOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    ArrayList<Integer> A=new ArrayList<>(Arrays.asList(9,-20,-11,-8,-4,2,-12,14,1,-18));
    //ArrayList<Integer> A=new ArrayList<>(Arrays.asList(1,2,3,4));
    subsets(A);
	}

	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

		Collections.sort(A);
		// Collections.reverse(A);
		ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		output.add(new ArrayList<Integer>());
		int size = A.size();
		System.out.println("size"+size);
		for (int i = 0; i < size; i++) {
			//output.add(new ArrayList<>(A.get(i)));
			ArrayList<Integer> result = new ArrayList<>();
			result.add(A.get(i));
			System.out.println("Calling for "+A.get(i));
			generateSubsetOne(A, output, result, i + 1, i+1,size);
		}
            for(ArrayList<Integer> singleList:output)
            {
            	for(int ele:singleList)
            	{
            		System.out.print(ele+" ");
            	}
            	System.out.println();
            }
		return output;
	}


	public static void generateSubsetOne(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> output,
			ArrayList<Integer> result, int currIndex,int fetchIndex, int n) {
		ArrayList<Integer> res=new ArrayList<>(result);
		output.add(res);
		if(fetchIndex>=n)
		{
			return;
		}
		for(int i=fetchIndex;i<n;i++)
		{
			result.add(A.get(i));
			generateSubsetOne(A,output,result,i+1,i+1,n);
			result.remove(result.size()-1);
		}
	
		

	}
	
	
	public static void generateSubset(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> output,
			ArrayList<Integer> result, int currIndex,int fetchIndex, int n) {
		
		if (currIndex >= A.size())

		{
			if(output.contains(result))
			{
				System.out.println("already have ");
				for(int i=0;i<result.size();i++)
				{
					System.out.print(result.get(i)+"v");
				}
				return ;
			}
			ArrayList<Integer> res=new ArrayList<>(result);
			for(int i=0;i<res.size();i++)
			{
				System.out.print(result.get(i)+"--->");
			}
			System.out.println();
			output.add(res);
			return;
		}
		generateSubset(A,output,result,currIndex+1,fetchIndex,n);
		//result.add(A.get(fetchIndex));
		for(int i=fetchIndex;i<A.size();i++)
		
		{
			
			result.add(A.get(i));
			generateSubset(A, output, result, currIndex+1,i+1, n);
			result.remove(result.size()-1);
		}
		

	}

}
