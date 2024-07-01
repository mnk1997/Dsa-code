package in.cdac.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HotelService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	ArrayList<ArrayList<Integer>> A=new ArrayList<>();
	/*
	 * A.add(new ArrayList<>(Arrays.asList(0,0))); A.add(new
	 * ArrayList<>(Arrays.asList(1,0))); ArrayList<ArrayList<Integer>> B=new
	 * ArrayList<>(); A.add(new ArrayList<>(Arrays.asList(1,1))); A.add(new
	 * ArrayList<>(Arrays.asList(2,1))); A.add(new ArrayList<>(Arrays.asList(1,2)));
	 */
		int[][] A = {
				{0,0},
				{1,0}
		};
		int[][] B= {
				{1,1},
				{2,1},
				{1,2}
		};
		
		for(int ele:nearestHotel(A,B))
		{
			System.out.println(ele);
		}
		

	}
	static class Pair
	    {
	        int x;
	        int y;
	        Pair(int x,int y)
	        {
	            this.x=x;
	            this.y=y;
	        }
	        public int getX()
	        {
	            return x;
	        }
	        public int getY()
	        {
	            return y;
	        }
	        
	    }
	    public static ArrayList<Integer> nearestHotel(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
	        
	        Queue<Pair> q=new LinkedList<>();
	        q.add(new Pair(0,0));
	        ArrayList<ArrayList<Integer>> buff=new ArrayList<>();
	        for(int i=0;i<A.size();i++)
	        {
	        	buff.add(new ArrayList<Integer>());
	        }
	        ArrayList<Integer> res=new ArrayList<>();
	        findNearestHotelForEachIndexes(q,A,buff);
	        for(int i=0;i<buff.size();i++)
	        {
	        	for(int j=0;j<buff.get(i).size();j++)
	        	{
	        		System.out.print("  "+buff.get(i).get(j));
	        	}
	        	System.out.println();
	        }
	        for(int i=0;i<B.size();i++)
	        {
	        	int x=B.get(i).get(0);
	        	int y=B.get(i).get(1);
	            res.add(buff.get(x-1).get(y-1));
	        }
	        return res;
	        
	    }
	    public static void findNearestHotelForEachIndexes(Queue<Pair> q,ArrayList<ArrayList<Integer>> A,ArrayList<ArrayList<Integer>> buff)
	    {
	        if(q.isEmpty())
	        {
	            return;
	        }
	        Pair p=q.poll();
	        int x=p.getX();
	        int y=p.getY();
	        if(x>A.size()-1 ||y>A.get(x).size()-1)
	        {
	            return ;
	        }
	        if(A.get(x).get(y)==1)
	        {
	        	ArrayList<Integer> val=new ArrayList<>();
	        	val.add(y,0);
	            buff.get(x);
	            return ;
	        }
	        else
	        {
	            q.add(new Pair(x+1,y));
	            q.add(new Pair(x,y+1));
	            q.add(new Pair(x,y));
	            buff.get(x-1).add(y,Math.min(buff.get(x+1).get(y),buff.get(x).get(y+1)));
	        }
	    }
	    public static void initializingAllTheNeighbours(Queue<Pair> q,int[][] A,int[][] buff,int[][] visited)
	    {
	       while(!q.isEmpty())
	       {
	    	   
	       
	        Pair p=q.poll();
	        int x=p.getX();
	        int y=p.getY();
	        if(x>A.length-1 ||y>A[x].length-1)
	        {
	            return ;
	        }
	        if(A[x][y]==1)
	        {
	        	System.out.println("A[][]y==1");
	        	ArrayList<Integer> val=new ArrayList<>();
	        	buff[x][y]=0;
	        	if(x+1<A.length)
	        	{
	        		buff[x+1][y]=1;
	        		if(visited[x+1][y]==0)
	        		{
	        			q.add(new Pair(x+1,y));
	        			visited[x+1][y]=1;
	        		}
	        		
	        	}
	        		
	        	if(y+1<A[x].length)
	        	{
	        		buff[x][y+1]=1;
	        		if(visited[x][y+1]==0)
	        		{
	        			q.add(new Pair(x,y+1));
	        			visited[x][y+1]=1;
	        		}
	        		
	        	}
	        	
	        	if(x-1 >=0)
	        	{
	        		buff[x-1][y]=1;
	        		if(visited[x-1][y]==0) {
	        			visited[x-1][y]=1;
	        			q.add(new Pair(x-1,y));
	        		}
	        		
	        	}
	        		
	        	if(y-1>=0)
	        	{
	        		buff[x][y-1]=1;
	        		if(visited[x][y-1]==0)
	        		{
	        			q.add(new Pair(x,y-1));
	        			visited[x][y-1]=1;
	        		}
	        		
	        	}
	        	
	           // return ;
	        }
	        if(buff[x][y]>0)
	        {
	        	if()
	        }
	     
	       }
	    }
	    public static int[] nearestHotel(int[][] A, int[][] B) {
	    	 
	        Queue<Pair> q=new LinkedList<>();
	        int[][] visited=new int[A.length][A[0].length];
	        for(int i=0;i<A.length;i++)
	        {
	        	for(int j=0;j<A[i].length;j++)
	        	{
	        		if(A[i][j]==1 && visited[i][j]==0)
	        			
	        		{
	        			q.add(new Pair(i,j));
	        			visited[i][j]=1;
	        		}
	        	}
	        }
	        int[][] buff=new int[A.length][A[0].length];
	        int[] res=new int[B.length];
	
	     //   ArrayList<Integer> res=new ArrayList<>();
	        initializingAllTheNeighbours(q,A,buff,visited);
	        System.out.println("check buff-------------");
	        for(int i=0;i<buff.length;i++)
	        {
	        	for(int j=0;j<buff[i].length;j++)
	        	{
	        		System.out.println(" i,j "+buff[i][j]);
	        	}
	        }
	      System.out.println("-------------------------------------");
	        for(int i=0;i<B.length;i++)
	        {
	        	int x=B[i][0];
	        	int y=B[i][1];
	            res[i]=buff[x-1][y-1];
	        }
	        return res;
			//return null;
	    }

}
