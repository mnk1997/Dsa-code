package in.cdac.pract;

import java.util.HashSet;

public class SortedPermutationWithRepeats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findRank("bca"));

	}
	
	public static int findRank(String A) {
		
		long fact[]=new long[A.length()];
		char[] charactersFreq=new char[26];
		fact[0]=1;
		for(int i=1;i<fact.length;i++)
		{
			fact[i]=fact[i-1]*i;
		}
		
		for(char c:A.toCharArray())
		{
			  
			  charactersFreq[c-'a']++;
		}
		long rank=1;
		int n=A.length();
		for(int i=0;i<A.length();i++)
		{
			char currCh=A.charAt(i);
			int count=0;
			System.out.println("current character "+currCh+ "   for index "+i);
			for(char ch:charactersFreq)
			{
				System.out.println("current ch"+ch);
				if(charactersFreq[ch]>0 &&   ch<currCh && charactersFreq[ch -'a']>0)
				{
					count++;
				}
			}
		
			rank+=count*fact[n-(i+1)];
			charactersFreq[currCh-'a']--;
			System.out.println ("   count "+count+"   Rnak"+rank);
		}
		
		return (int) rank%1000003;
		
		
	
    }

}
