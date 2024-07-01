package in.cdac.pract;

import java.util.HashMap;

public class SolutionTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("abba"));

	}
public static int lengthOfLongestSubstring(String s) {
	if(s.isEmpty())
	{
		return 0;
	}
	int lengthOfString=s.length();
	int currMax=0;
	int[] maxSubstringForEachIndex=new int[lengthOfString];
	for(int i=0;i<lengthOfString;i++)
	{
		maxSubstringForEachIndex[i]=lengthOfString-i;
	}
	HashMap<String,Integer> repeatedCharacterWithTheirIndex=new HashMap<>();
	repeatedCharacterWithTheirIndex.put(String.valueOf(s.charAt(lengthOfString-1)),lengthOfString-1);
	for(int i=lengthOfString-2;i>=0;i--)
	{
		if(repeatedCharacterWithTheirIndex.containsKey(String.valueOf(s.charAt(i))))
		{
			int indexOfRepeatedCharacter=repeatedCharacterWithTheirIndex.get(String.valueOf(s.charAt(i)));
			maxSubstringForEachIndex[i]=indexOfRepeatedCharacter-i<maxSubstringForEachIndex[i+1]+1?indexOfRepeatedCharacter-i:maxSubstringForEachIndex[i+1]+1;
		}
		else
		{
			maxSubstringForEachIndex[i]=maxSubstringForEachIndex[i+1]+1;
		}
		repeatedCharacterWithTheirIndex.put(String.valueOf(s.charAt(i)),i);
	}
	
	
	
	for(int i=0;i<s.length();i++)
	{
		if(maxSubstringForEachIndex[i]>currMax)
		{
			currMax=maxSubstringForEachIndex[i];
		}
	}
	
	return currMax;
        
    }
}
