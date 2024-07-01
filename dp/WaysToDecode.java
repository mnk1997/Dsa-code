package in.cdac.dp;

import java.util.HashMap;
import java.util.List;

/* A message containing letters from A-Z is being
encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message denoted by string A
containing digits, determine the total number of ways to decode it modulo 109 + 7.*/
public class WaysToDecode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodingsAfterUnderstandingQuestion("2163"));

	}
	  public static int numDecodings(String s) {
		 
		  int[] dp=new int[s.length()+1];
		  dp[0]=1;
		  dp[1]=1;
		  dp[s.length()]=1;
		  for(int i=2;i<=s.length();i++)
		  {
			    int tempCount=0;
			    int currSelection=1;
			    System.out.println("curr i "+i);
			    dp[i]=1;
			    while(currSelection<=i)
			    {
			    	//System.out.println("curr selection "+dp[currSelection]+"    ---> "+dp[i-currSelection]);
			    
			    	tempCount+=dp[currSelection]*dp[i-currSelection];
			    	currSelection+=1;
			    }
			    dp[i]=tempCount;
			   
		  }
		  
		  return dp[s.length()];
	    }
	  
	  public static int numDecodingsAfterUnderstandingQuestion(String s) {
		    if(s.length()==0)
		    	return 0;
		    if(s.charAt(0)==0)
		    	return 0;
		    
		    HashMap<String,Character> values=new HashMap<>();
		    int counter=1;
		    for(char c='A';c<='Z';c++)
		    {
		    	values.put(String.valueOf(counter++), c);
		    }
		   // System.out.println("present 12 "+values.get("12"));
		    HashMap<String,Integer> hm=new HashMap<>();
		    return findDecodeWays(s,0,hm,values);
		 
	    }
	private static int findDecodeWays(String s, int currIdx, HashMap<String, Integer> hm, HashMap<String, Character> values) {
		    if(currIdx>=s.length() || s.substring(currIdx).isBlank())
		    {
		    	//System.out.println(" returning 1");
		    	return 1;
		    }
		    	
		   
		    int countOne=0;
		    int countTwo=0;
		    if(hm.containsKey(s.substring(currIdx, currIdx+1)))
		    {
		    	countOne=hm.get(s.substring(currIdx, currIdx+1));
		    }else
		    {
		    	countOne=findDecodeWays(s, currIdx+1, hm, values);
		    	//hm.put(s.substring(currIdx, currIdx+1), countOne);
		    }
		    
	        if(currIdx+1<s.length() && values.containsKey(s.substring(currIdx,currIdx+2)))
	        		{
	        	            //   System.out.println(" two param found "+s.substring(currIdx, currIdx+2));
	        	            if(hm.containsKey(s.substring(currIdx, currIdx+2)))
	        	            	countTwo=hm.get(s.substring(currIdx, currIdx+2));
	        	            else
	        	            {
	        	            	countTwo=findDecodeWays(s,currIdx+2,hm,values);
	        	            	//hm.put(s.substring(currIdx, currIdx+2), countTwo);
	        	            }
	        	            	
	        		}
	      // hm.put(s.substring(currIdx),countOne+countTwo);
	        
	        return countOne+countTwo;
	             
	}

}
