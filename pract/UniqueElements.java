package in.cdac.pract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class UniqueElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> A=new ArrayList<>(Arrays.asList(51,6,10,8,22,61,56,48,88,85,21,98,81,76,71,68,18,6,14,23,72,18,56,30,97,100,81,5,99,2,85,67,46,32,66,51,76,53,36,31,81,56,26,75,69,54,54,54,83,41,86,48,7,32,85,23,47,23,18,45,79,95,73,15,55,16,66,73,13,85,14,80,39,92,66,20,22,25,34,14,51,14,17,10,100,35,9,83,31,60,24,37,69,62));
          solve(A);
	}
    public static int solve(ArrayList<Integer> A) {
        //first I will find does the list have all the distinct or equal elements
        HashSet<Integer> elements=new HashSet<Integer>();
        int maxEle=0;
        for(int ele:A)
        {
            elements.add(ele);
            if(ele>maxEle)
            {
                maxEle=ele;
            }
        }
        if(elements.size() == A.size())
        {
            return 0;
        }
        if(elements.size()==1 && A.size() > 1)
        {
            //return if all the elements are equal....
            int n=A.size();
            return (n*(n-1))/2;
        }
       int minCount=0;
       Collections.sort(A);
       for(int ele:A)
       {
    	   System.out.print(ele +" ");
       }
       for(int i=1;i<A.size();i++)
       {
            if(A.get(i)==A.get(i-1))
            {
            	int x=A.get(i);
            	x=x+1;
            	int j=i+1;
                while(j<A.size() && A.get(j)==x && A.get(j)!=A.get(j-1))
                {
                	j++;
                	x=x+1;
                	minCount+=1;
                }
                if(j==A.size())
                {
                	A.add(x);
                }
                else
                {
                	A.add(j+1, x);
                }
                

            }
       }
       System.out.println();
       for(int ele:A)
       {
    	   System.out.print(ele +" ");
       }
       return minCount;
        
    }

}
