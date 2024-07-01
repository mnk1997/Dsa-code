package in.cdac.pract;

import java.util.ArrayList;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public String largestNumber(ArrayList<Integer> A) {
		    A.set
		  A.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1*10+o2 - o2*10+o1;
				
			}
		});
		return null;
	    }

}
