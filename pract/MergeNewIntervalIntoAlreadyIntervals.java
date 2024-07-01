package in.cdac.pract;
/*Given a set of non-overlapping intervals and a new interval.

Insert the new interval into the set of intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.
Note: Make sure the returned intervals are also sorted.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeNewIntervalIntoAlreadyIntervals {
	 public static class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		      @Overrride
		      public String toString()
		      {
//		    	 / System.out.println();
				return " start "+start +"   "+end;
		      }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(Interval inte:insert(new ArrayList<Interval>(Arrays.asList(new Interval(3,6),new Interval(9,13))),new Interval(11,18)))
		{
			System.out.println("in "+inte.start+" end "+inte.end);
		}
 
	}
	 public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		 if(newInterval.start> newInterval.end)
			 return  intervals;
		 
		
		 //check whether newInterval suits for the starting point 
		 if(newInterval.end<intervals.get(0).start)
		 {
			 System.out.println(" if");
			 intervals.add(0, newInterval);
			 return intervals;
		 }
		 else if(newInterval.start>intervals.get(intervals.size()-1).end)
		 {
			 System.out.println("else if");
			 intervals.add(newInterval);
			 return intervals;
		 }
		 
		 int prevStart=intervals.get(0).start;
		 int prevEnd=intervals.get(0).end;
		 ArrayList<Interval> res=new ArrayList<>();
		 for(int idx=0;idx<intervals.size();idx++)
		 {
			 System.out.println("new interval "+newInterval.toString());
			 System.out.println("currIndex "+intervals.get(idx).toString());
			 //below mentioned is the case for non overlapping 
			   if(newInterval.end<intervals.get(idx).start || intervals.get(idx).end<newInterval.start)
			   {
				   System.out.println("inside if");
				   res.add(intervals.get(idx));
			   }
			   else if(idx>0 && idx<intervals.size()-1)
			   {
				   if(newInterval.start> intervals.get(idx-1).end && newInterval.end< intervals.get(idx).start)
				   {
					   res.add(newInterval);
					   res.add(intervals.get(idx));
				   }
			   }
			   else
			   {
				   
				   System.out.println("inside else");
				   int start=Math.min(newInterval.start,intervals.get(idx).start);
				   int end=Math.max(newInterval.end,intervals.get(idx).end);
				   while(idx<intervals.size() && !(end<intervals.get(idx).start))
				   {
					   
					   end=Math.max(end,intervals.get(idx).end);
					   idx++;
					   
				   }
				   if(idx>=intervals.size())
				   {
					   res.add(new Interval(start,end));
					   return res;
				   }
				   else
				   {
					   res.add(new Interval(start,end));
					   res.add(intervals.get(idx));
				   }
			   }
			 System.out.println("idx "+idx+" res size "+res.size());
				/*
				 * if(newInterval.end<intervals.get(idx).start && newInterval.start>prevEnd) {
				 * System.out.println("for if"); res.add(newInterval); } else {
				 * System.out.println("elese "); int
				 * minStart=newInterval.start<intervals.get(idx).start?newInterval.start:
				 * intervals.get(idx).start; int
				 * maxEnd=newInterval.end>intervals.get(idx).end?newInterval.end:intervals.get(
				 * idx).end;
				 * System.out.println("idx "+idx+"   min Start "+minStart+"  maxEnd "+maxEnd);
				 * // int minStart=newInterval.start<
				 * if((newInterval.end<=intervals.get(idx).end &&
				 * newInterval.end>=intervals.get(idx).start)
				 * ||(newInterval.start<=intervals.get(idx).end &&
				 * newInterval.start>=intervals.get(idx).start)
				 * ||(newInterval.start<=intervals.get(idx).start &&
				 * newInterval.end>=intervals.get(idx).end)) { System.out.println("Yess "); int
				 * minTime=Math.min(newInterval.start, intervals.get(idx).start); int
				 * startIndex=idx; while(idx<intervals.size() && (
				 * (newInterval.end<=intervals.get(idx).end &&
				 * newInterval.end>=intervals.get(idx).start)
				 * ||(newInterval.start<=intervals.get(idx).end &&
				 * newInterval.start>=intervals.get(idx).start)
				 * ||(newInterval.start<=intervals.get(idx).start &&
				 * newInterval.end>=intervals.get(idx).end)) ) { System.out.println("Noooo");
				 * newInterval.end=Math.max(newInterval.end,intervals.get(idx).end); idx++; }
				 * int endTime=Math.max(newInterval.end,intervals.get(idx-1).end); res.add(new
				 * Interval(minTime,endTime)); //continue; } }
				 * 
				 * prevStart=intervals.get(idx).start; prevEnd=intervals.get(idx).end;
				 * if(idx<intervals.size()) res.add(intervals.get(idx));
				 */
		 }
		 res.sort(new Comparator<Interval> ()
				 {

				
					public int compare(Interval o1, Interval o2) {
						// TODO Auto-generated method stub
						return o1.start-o2.start;
					}
			 
				 });;
                return res;
	    }

}
