package in.cdac.pract;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	 static class Pair 
	{
		int i;
		int j;
		Pair(int i,int j)
		{
			this.i=i;
			this.j=j;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] grid=
			{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
	         maxAreaOfIsland(grid);
	
	}
	        
	  /*      [["O","X","X","O","X"],
	         ["X","X","X","X","O"],
	         ["X","X","X","X","X"],
	         ["O","X","O","O","O"],
	         ["X","X","O","X","O"]]
	}*/
	
	
	 public static int maxAreaOfIsland(int[][] grid) {
		 int maxArea=0;
		 int[][] visited=new int[grid.length][grid[0].length];
		 for(int i=0;i<grid.length;i++)
		 {
			 for(int j=0;j<grid[0].length;j++)
			 {
				 if(grid[i][j]==1 && visited[i][j]==0)
				 {
					 //visited[i][j]=1;
					 int areaOfConnectedIsland=findConnectedIslandArea(grid,i,j,visited);
					 if(maxArea<areaOfConnectedIsland)
						 maxArea=areaOfConnectedIsland;
				 }
			 }
		 }
		 
		 return maxArea;
	        
	    }

	private static int findConnectedIslandArea(int[][] grid, int i, int j, int[][] visited) {
		System.out.println("called ");
		if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
			return 0;
		else if(grid[i][j]==1 && visited[i][j]==1)
			return 0;
		else
		{
			System.out.println("converted ");
			
			visited[i][j]=1;
			return 1+findConnectedIslandArea(grid, i-1, j, visited) 
			        +findConnectedIslandArea(grid, i+1, j, visited)
			        +findConnectedIslandArea(grid, i, j-1, visited)
			        +findConnectedIslandArea(grid, i, j+1, visited);
		}
		
		
		
		
	}

}
