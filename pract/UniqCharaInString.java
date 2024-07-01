package in.cdac.pract;

public class UniqCharaInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstUniqChar("leetcode"));

	}
	
	public static int firstUniqChar(String s) {
        //int cntr=0;
        int[] charactersIndex=new int[26];
        for(int i=0;i<26;i++)
        {
        	//initialized with -1 : character was not present in string till now
        	charactersIndex[i]=-1;
        }
       for(int idx = 0; idx < s.length(); idx++){
              int currChar=s.charAt(idx);
              System.out.println("char "+s.charAt(idx)+"   val : "+currChar);
              if(charactersIndex[currChar-97]==-1)
            	  charactersIndex[currChar-97]=idx;
              else if(charactersIndex[currChar-97]>=0)
            	  charactersIndex[currChar-97]=-100;//this shows that character has already been present so mark it as -100;
              
    	   
           }
     
            int ansIndex=-1;
            for(int i=0;i<26;i++)
            {
            
           if(charactersIndex[i]>-1)
           {
        	   if(ansIndex==-1)
        		   ansIndex=charactersIndex[i];
        	   else if(ansIndex>charactersIndex[i])
        		   ansIndex=charactersIndex[i];
        		   
           }
       }

       return ansIndex;
       
   }

}
