package in.cdac.lld;

import java.util.List;
import java.util.Optional;

public class Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		findLongestStringInListUsingStreamReduce(List.of( "GFG", "Geeks", "for","GeeksQuiz", "GeeksforGeeks"));
//		Implementation of reduce method 
//		// to get the combined String 
		findTheCombinedStringFromList(List.of("Mayank","Raj","Srivastava"));
		/*
		 * Implementation of reduce method // to get the sum of all elements
		 */
		findSumOfAllElementsOfList(List.of(1,2,3,4,5,6,7));
	}

	private static void findSumOfAllElementsOfList(List<Integer> of) {
		// TODO Auto-generated method stub
		Integer sum=of 
				              .stream()
				              .reduce(0,(prev,curr)->prev+curr);
		
		System.out.println("sum "+sum);
		
	}

	private static void findTheCombinedStringFromList(List<String> of) {
		// TODO Auto-generated method stub
		
		Optional<String> stringConcat=of
				                      .stream()
				                      .reduce((prev,curr)->prev.concat(curr));
		
		if(stringConcat.isPresent())
		 System.out.println("Concatted String "+stringConcat.get());
		
	}

	private static void findLongestStringInListUsingStreamReduce(List<String> of) {
		// TODO Auto-generated method stub
		Optional<String> longestString=of
				             .stream()
				             .reduce((prev,curr) -> {
				            	 if(prev.length()>=curr.length())
				            		 return prev;
				            	 else
				            		 return curr;
				             });
		//in the absence of default value reduce uses its first value as default in accum.
		
		 Optional<String> longestStringTwo = of.stream() 
                 .reduce((word1, word2) 
           -> word1.length() > word2.length() 
                         ? word1 : word2);
		
		System.out.println("longest string "+longestString.get());
	}
	
	

}
