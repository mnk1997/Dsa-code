package in.cdac.pract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList {
	static class Pair implements Comparable<Pair>
	{
		int level;
		int val;
		Pair(int l,int v)
		{
			this.level=l;
			this.val=v;
		}
		//0-1=-1  ==>ascending order 
		public int compareTo(Pair o) {
			   
			   
			    if (this.level==o.level)
			   {
				   return this.val-o.val;
			   }
			    else
			    	return this.level-o.level;
					  
		 
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// List<Integer> listOFInteger=List.of(1,2,3,4,5);

 ArrayList<Pair> listOfPairs=new ArrayList<>();
 listOfPairs.add(new Pair(1,6));
 listOfPairs.add(new Pair(0,8));
 
 listOfPairs.add(new Pair(1,3));
 listOfPairs.add(new Pair(0,9));
    for(Pair p:listOfPairs)
    {
    	System.out.println("("+p.level+","+p.val+")");
    }
 Collections.sort(listOfPairs);
 
 System.out.println("aAFTER SORTINGGGGGGGGGGGGG     ");
 System.out.println();
 for(Pair p:listOfPairs)
 {
 	System.out.println("("+p.level+","+p.val+")");
 }
	
	}
	

}
