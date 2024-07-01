/*Given two strings s1 and s2, 
return the lowest ASCII sum of deleted characters to make two strings equal.*/

/*Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.*/
//delete and leet ==> dee and e 
package in.cdac.pract;

import java.util.HashMap;
import java.util.Map;

public class SolutionThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minimumDeleteSum("sea","eat"));

	}
public static int minimumDeleteSum(String s1, String s2) {
	
	Map<String,Integer> frequencyOfChar=new HashMap<>();
	for(int i=0;i<s1.length();i++)
	{
		if(frequencyOfChar.containsKey(s1.charAt(i)))
		{
			System.out.println("modifying "+s1.charAt(i));
			frequencyOfChar.put(String.valueOf(s1.charAt(i)),frequencyOfChar.get(String.valueOf(s1.charAt(i)))+1);
		}
		else
		{
			System.out.println("putting"+s1.charAt(i));
			frequencyOfChar.put(String.valueOf(s1.charAt(i)),1);
		}

	}
	int deleteSum=0;
	for(int i=0;i<s2.length();i++)
	{
		if(frequencyOfChar.containsKey(String.valueOf( s2.charAt(i))))
		{
			int value=frequencyOfChar.get(String.valueOf( s2.charAt(i)))-1;
			if(value==0)
			{
				System.out.println("removing"+s2.charAt(i));
				frequencyOfChar.remove(String.valueOf(s2.charAt(i)));
			}
				
			else
			     frequencyOfChar.put(String.valueOf(s1.charAt(i)),value);
		}
		else
		{
			System.out.println("adding to delte"+s2.charAt(i));
			deleteSum+=s2.charAt(i);
		}
		
	}
	//System.out.println("# of element left in map"+frequencyOfChar.size());
	 for (Map.Entry<String,Integer> mapElement : frequencyOfChar.entrySet()) {
        // String key = mapElement.getKey();
     //System.out.println("value found in map"+mapElement.getValue());
         // Adding some bonus marks to all the students
         deleteSum+= mapElement.getKey().charAt(0);

         // Printing above marks corresponding to
         // students names
         //System.out.println(key + " : " + value);
     }
	//frequencyOfChar.forEach((k,v) -> deleteSum+=v );
	return deleteSum;
        
    }

}
