package in.cdac.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapsack {
	static class Pair
	{
		int val;
		int wt;
		Pair(int v,int w)
		{
			this.val=v;
			this.wt=w;
		}
		
		double perUnit()
		{
			double num=(double) val;
			double denom=(double) wt;
			return num/denom;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(new ArrayList<>(Arrays.asList(3)),new ArrayList<>(Arrays.asList(20)),17));
		
            //System.out.println(solve(new ArrayList<>(Arrays.asList(16,3,3,6,7,8,17,13,7)),new ArrayList<>(Arrays.asList(3,10,9,18,17,17,6,16,13)),11));
	}
	  public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
		  //double[] valuePerUnit=new double[A.size()];
		  ArrayList<Pair> items=new ArrayList<>();
		  double ans=0.0000;
		  for(int i=0;i<A.size();i++)
		  {
			 
			  items.add(new Pair(A.get(i),B.get(i)));
		  }
		  Collections.sort(items,new Comparator<Pair>() {
			  public int compare(Pair o1,Pair o2)
			  {
				  double v1=o1.perUnit();
				  double v2=o2.perUnit();
				  return Double.compare(v2, v1);
					/*
					 * if(v1==v2) { return o1.wt-o2.wt; }
					 * 
					 * return (int) (o2.perUnit()-o1.perUnit());
					 */
				 
					/*
					 * double v=o2.perUnit()-o1.perUnit(); if(v>0) return 1; else return 0;
					 */
					/*
					 * if(o2.perUnit()-o1.perUnit()==0) { System.out.println("yess"); return
					 * o1.wt-o2.wt; } return (int) ((int)o2.perUnit()-o1.perUnit());
					 */
					/*
					 * if(ans>0) return 0; else return 1;
					 */
			  }
		});
		  for(Pair p:items)
		  {
			  System.out.println(p.val +" -> "+p.wt);
		  }
		  
		 // double ans=0.0;
		  for(int i=0;i<items.size();i++)
		  {
			  System.out.println(" remaining C" +C);
			  if(C<=0)
				  break;
			  if(items.get(i).wt<=C)
			  {
				  ans+=items.get(i).val;
				  C-=items.get(i).wt;
				  System.out.println("ans added above "+ans);
			  }
			  else
			  {
				  System.out.println("per unit "+items.get(i).perUnit());
				  ans+=(items.get(i).perUnit()) *C;
				  C-=items.get(i).wt;
				  System.out.println("ans added "+ans);
			  }
		  }
		  ans*=1000;

		  ans /= 10;

		  return (int) ans;
		  //System.out.println(" remaining C" +C);
		 // return (int) Math.floor(ans*100);
		  
	    }

}
