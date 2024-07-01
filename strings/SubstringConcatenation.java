package in.cdac.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
 * given string A and list of words b in which all the words are of same length
 * Find all the starting indices of substrings(A) which has all the concatenated words exactly once without any intervening characters
 */
public class SubstringConcatenation {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println("are two hashmaps equal " + hm.equals(hmOne));
		/*
		 * for(int ele:findStartingIndices("mabefcdktcefcdabbc",new
		 * ArrayList<String>(Arrays.asList("ab","cd","ef")) )) {
		 * System.out.print(ele+" "); }
		 */
		/*
		 * for(int ele:findStartingIndices("wordgoodgoodgoodbestword",new
		 * ArrayList<String>(Arrays.asList("word","good","best","good")) )) {
		 * System.out.print(ele+" "); }
		 */

		String[] words = { "word", "good", "best", "good" };
		for (int ele : findSubstringOptimized("wordgoodgoodgoodbestword", words)) {
			System.out.print(ele + " ans  ");
		}

		/*
		 * String[] words= {"a"}; for(int ele:findSubstringOptimized("a",words)) {
		 * System.out.print(ele+" "); }
		 */

	}

	public static ArrayList<Integer> findStartingIndices(String A, ArrayList<String> words) {
		ArrayList<Integer> indices = new ArrayList<>();
		HashSet<String> wordsSetOne = new HashSet<>(words);
		HashSet<String> wordsSetTwo = new HashSet<>();
		int len = words.get(0).length();
		int startIdx = Integer.MAX_VALUE;
		for (int idx = 0; idx < A.length(); idx++) {
			if (wordsSetOne.size() > 0 && idx + len < A.length() && wordsSetOne.contains(A.substring(idx, idx + len))) {
				if (startIdx > idx) {
					startIdx = idx;

				}
				System.out.println("start idx " + A.substring(startIdx, startIdx + len));

				wordsSetTwo.add(A.substring(idx, idx + len));
				wordsSetOne.remove(A.substring(idx, idx + len));
				int tempItr = idx + len;
				while ((tempItr + len) < A.length() && wordsSetOne.size() != 0
						&& wordsSetOne.contains(A.substring(tempItr, tempItr + len))) {
					wordsSetTwo.add(A.substring(tempItr, tempItr + len));
					wordsSetOne.remove(A.substring(tempItr, tempItr + len));
					tempItr += len;
				}

				if (wordsSetOne.size() == 0) {
					indices.add(startIdx);
					System.out.println("words start " + A.substring(startIdx, startIdx + len));

				}
				startIdx = Integer.MAX_VALUE;
				wordsSetOne.addAll(wordsSetTwo);
			}
		}

		return indices;
	}

	// below mehtod was giving me TLE

	public static List<Integer> findSubstring(String A, String[] words) {
		HashSet<Character> hs = new HashSet<>();

		ArrayList<Integer> indices = new ArrayList<>();
		HashMap<String, Integer> wordsSetOne = new HashMap<>();
		for (String w : words) {
			if (wordsSetOne.containsKey(w))
				wordsSetOne.put(w, wordsSetOne.get(w) + 1);
			else
				wordsSetOne.put(w, 1);
		}
		for (Map.Entry<String, Integer> val : wordsSetOne.entrySet()) {
			System.out.println(" val key " + val.getKey() + " val valuee " + val.getValue());
		}
            
		
	
		int len = words[0].length();
		int startIdx = Integer.MAX_VALUE;
		int windowLen=len*words.length;
		for (int idx = 0; idx+windowLen <= A.length(); idx++) {
			// System.out.println("wordsSetOne size "+wordsSetOne.size());
			HashMap<String, Integer> wordsSetTwo = new HashMap<>(wordsSetOne);
			if (wordsSetTwo.size() > 0 && idx + len <= A.length()
					&& wordsSetTwo.containsKey(A.substring(idx, idx + len))) {
				if (startIdx > idx) {
					startIdx = idx;

				}
				System.out.println("start idx " + A.substring(startIdx, startIdx + len));

				if (wordsSetTwo.get(A.substring(idx, idx + len)) > 1)
					wordsSetTwo.put(A.substring(idx, idx + len), wordsSetTwo.get(A.substring(idx, idx + len)) - 1);
				else
					wordsSetTwo.remove(A.substring(idx, idx + len));

				for (Map.Entry<String, Integer> val : wordsSetTwo.entrySet()) {
					System.out.println(" val key " + val.getKey() + " val valuee " + val.getValue());
				}
 
				
				int windowSize=words.length*words[0].length();
				int tempItr = idx + len;
				while (((tempItr + len) <= A.length()) && wordsSetTwo.size() > 0
						&& wordsSetTwo.containsKey(A.substring(tempItr, tempItr + len))) {
					if (wordsSetTwo.containsKey(A.substring(tempItr, tempItr + len))
							&& wordsSetTwo.get(A.substring(tempItr, tempItr + len)) > 1) {
						wordsSetTwo.put(A.substring(tempItr, tempItr + len),
								wordsSetTwo.get(A.substring(tempItr, tempItr + len)) - 1);
						System.out.println("decreased count of string " + A.substring(tempItr, tempItr + len));

					}
					// wordsSetTwo.put(A.substring(tempItr,tempItr+
					// len),wordsSetTwo.get(A.substring(tempItr,tempItr+ len))-1);
					else {
						wordsSetTwo.remove(A.substring(tempItr, tempItr + len));
						System.out.println("removed from map " + A.substring(tempItr, tempItr + len));
					}

					tempItr += len;
				}

				if (wordsSetTwo.size() == 0) {
					indices.add(startIdx);
					System.out.println("words start " + A.substring(startIdx, startIdx + len));

				}

				startIdx = Integer.MAX_VALUE;
				// wordsSetOne.addAll(wordsSetTwo);
				System.out.println("---------------------------------------------------------------------------------");
			}

		}

		return indices;

	}

//using sliding window concept 
	public static List<Integer> findSubstringOptimized(String A, String[] words) {
		ArrayList<Integer> indices = new ArrayList<>();
		//store the freq of all the words in hashmap
		HashMap<String, Integer> wordsCount = new HashMap<>();
		for (String w : words) {
			if (wordsCount.containsKey(w))
				wordsCount.put(w, wordsCount.get(w) + 1);
			else
				wordsCount.put(w, 1);
		}	
	 //-------------------------------
		//find the window length
		int windowLen=words.length*words[0].length();
		int wordLen=words[0].length();
		int left=0;
		int right=windowLen-1;
		while(right<A.length())
		{
			String presentWord=A.substring(left,left+wordLen);
			if(wordsCount.containsKey(presentWord))
			{
				HashMap<String,Integer> presentCount=new HashMap<>();
				presentCount.put(presentWord,1);
				int temp=left+wordLen;
				System.out.println(presentWord+" ");
				while(temp<=right)
				{
				       if(wordsCount.containsKey( A.substring(temp, temp+wordLen)))
				       {
				    	   System.out.print(A.substring(temp, temp+wordLen)+" ");
				    	   if(presentCount.containsKey(A.substring(temp, temp+wordLen)))
				    	   {
				    		   presentCount.put(A.substring(temp, temp+wordLen),presentCount.get(A.substring(temp, temp+wordLen))+1);
				    	   }
				    	   else
				    	   {
				    		   presentCount.put(A.substring(temp, temp+wordLen),1);
				    	   }
				       }
				       else
				       {
				    	   break;
				       }
				       temp+=wordLen;
				}
				System.out.println("---------------------------");
				if(presentCount.equals(wordsCount))
					indices.add(left);
				
			}
			
				left++;
				right++;
			
		}
		
			
		
		
	

		return indices;

	}

}
