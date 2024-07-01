package in.cdac.pract;

import java.util.Arrays;
import java.util.Collections;

public class FindRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(findRank("acb"));
		
		
		
		//System.out.println(findRank("AaBbCc"));
		System.out.println(findRank("gTFAMYjxCewRlftmGOKJHUuhSBVDZnbqyoPQadEkLrpNsv"));
		
		//System.out.println(findRank("aabaa"));
	}
	public static int findRank(String A) {
		long rank=1;
		int n=A.length();
		char tempArray[]=A.toCharArray();
		//A=A.toLowerCase();
		Arrays.sort(tempArray);
		String firstString=new String(tempArray);
		long[] fact=new long[n];
		fact[0]=1;
		for(int i=1;i<fact.length;i++)
		{
			fact[i]=(fact[i-1]*i)%1000003;
		}
		System.out.println(firstString.toString());
		for(int i=0;i<A.length();i++)
		{
			for(int j=i+1;j<A.length();j++)
			{
				if(A.charAt(i)-A.charAt(j)>0)
				{
					rank+=(fact[n-i-1])%1000003;
				}
			}
		}
		
		
		
		return (int)rank%1000003;
    }

}
