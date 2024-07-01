package in.cdac.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


/*Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent 
(Left, Right, Top, or Bottom) to a rotten orange becomes rotten.
 Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.*/
public class RottenOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		 list.add(new ArrayList(Arrays.asList(1,2)));
		
		/*
		 * list.add(new ArrayList(Arrays.asList(1,1,0))); list.add(new
		 * ArrayList(Arrays.asList(0,1,1)));
		 */
		 

		/*list.add(new ArrayList(Arrays.asList(1, 1, 1, 2, 1, 2)));
		list.add(new ArrayList(Arrays.asList(1, 2, 0, 0, 0, 1)));
		list.add(new ArrayList(Arrays.asList(1, 2, 0, 1, 1, 2)));
		list.add(new ArrayList(Arrays.asList(1, 0, 1, 2, 2, 2)));
		list.add(new ArrayList(Arrays.asList(1, 1, 2, 1, 1, 2)));
		list.add(new ArrayList(Arrays.asList(2, 2, 2, 2, 2, 0)));
		list.add(new ArrayList(Arrays.asList(1, 1, 0, 1, 2, 1)));
		list.add(new ArrayList(Arrays.asList(0, 2, 0, 0, 1, 0)));
		list.add(new ArrayList(Arrays.asList(0, 0, 2, 1, 2, 2)));
*/		
		/*
		 * list.add(new ArrayList(Arrays.asList(2,0,2,2,2,0,2,1,1,0))); list.add(new
		 * ArrayList(Arrays.asList(0,1,2,0,2,0,0,1,0,1))); list.add(new
		 * ArrayList(Arrays.asList(0,1,1,1,2,0,1,1,2,1))); list.add(new
		 * ArrayList(Arrays.asList(2,0,2,0,1,1,2,1,0,1))); list.add(new
		 * ArrayList(Arrays.asList(1,0,1,1,0,1,2,0,2,2))); list.add(new
		 * ArrayList(Arrays.asList(0,2,1,1,2,2,0,2,1,2))); list.add(new
		 * ArrayList(Arrays.asList(2,1,0,2,0,0,0,0,1,1))); list.add(new
		 * ArrayList(Arrays.asList(2,2,0,2,2,1,1,1,2,2)));
		 */
		//list.add(new ArrayList(Arrays.asList(0, 0, 2, 1, 2, 2)));

		System.out.println(solve(list));

	}

	public static int solveUsingDFS(ArrayList<ArrayList<Integer>> A) {
		int[][] time = new int[A.size()][A.get(0).size()];
		boolean[][] visited = new boolean[A.size()][A.get(0).size()];
		// intialize curretnTime to Integer .MAx_VAlue
		for (int i = 0; i < time.length; i++) {
			for (int j = 0; j < A.get(0).size(); j++) {
				if (A.get(i).get(j) == 0 || A.get(i).get(j) == 2) {
					time[i][j] = 0;
				} else {
					time[i][j] = Integer.MAX_VALUE;
				}

			}
		}
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(i).size(); j++) {
				if (A.get(i).get(j) == 2) {
					time[i][j] = 0;
					useDFSToMakeFreshOrangesRotten(i, j, time, A, 0, visited);
				}
			}
		}

		System.out.println();
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(0).size(); j++) {
				System.out.print(time[i][j] + "  ");
			}
			System.out.println();
		}

		int minTime = 0;
		for (int i = 0; i < time.length; i++) {
			for (int j = 0; j < time[i].length; j++) {
				if (time[i][j] == Integer.MAX_VALUE) {
					return -1;
				} else {
					if (time[i][j] > minTime) {
						minTime = time[i][j];
					}
				}
			}
		}
		return minTime;

	}
	// this code was giving me TLE

	private static void useDFSToMakeFreshOrangesRotten(int i, int j, int[][] time, ArrayList<ArrayList<Integer>> a,
			int counter, boolean[][] visited) {
		// TODO Auto-generated method stub
		if (i < 0 || j < 0 || i >= a.size() || j >= a.get(i).size() || visited[i][j])
			return;
		else if (a.get(i).get(j) == 0) {
			time[i][j] = 0;
			return;
		}

		else {

			int[] dx = { 0, -1, 0, 1 };
			int[] dy = { -1, 0, 1, 0 };
			time[i][j] = Math.min(time[i][j], counter);
			visited[i][j] = true;
			for (int k = 0; k < dx.length; k++) {

				useDFSToMakeFreshOrangesRotten(i + dx[k], j + dy[k], time, a, counter + 1, visited);
			}
			visited[i][j] = false;
		}

	}

	static class Pair {
		int i;
		int j;
		int min;

		Pair(int i, int j,int m) {
			System.out.println("m wis "+m);
			this.i = i;
			this.j = j;
			this.min=m;
		}
	}

	public static int solve(ArrayList<ArrayList<Integer>> A) {
		Deque<Pair> q = new LinkedList<>();
		int numberOfRottenOranges = 0;
		int numberOfFreshOranges = 0;
		int minutes = 1;
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(0).size(); j++) {
				if (A.get(i).get(j) == 2) {
					q.push(new Pair(i, j,0));
					numberOfRottenOranges++;
				} else if (A.get(i).get(j) == 1) {
					numberOfFreshOranges++;
				}
			}
		}
		System.out.println("number of fresh oranges"+numberOfFreshOranges);
		if (numberOfFreshOranges == 0)
			return 0;
		if (numberOfRottenOranges == 0)
			return -1;
		while (!q.isEmpty()) {
			int size=q.size();
			while(size>0)
			{
				
			
            boolean updated=false;
			int row = q.peek().i;
			int col = q.peek().j;
			// for up cell
			if (row - 1 >= 0 && A.get(row - 1).get(col) == 1) {
				//q.offer(null)
				q.add(new Pair(row - 1, col,(q.peek().min+1)));
				numberOfFreshOranges -= 1;
				A.get(row-1).set(col,2);
				updated=true;
			}
			// for left cell
			if (col - 1 >= 0 && A.get(row).get(col - 1) == 1) {
				q.add(new Pair(row, col - 1,(q.peek().min+1)));
				numberOfFreshOranges -= 1;
				A.get(row).set(col-1,2);
				updated=true;
			}
			// for down cell
			if (row + 1 < A.size() && A.get(row + 1).get(col) == 1) {
				q.add(new Pair(row + 1, col,(q.peek().min+1)));
				numberOfFreshOranges -= 1;
				A.get(row+1).set(col,2);
				updated=true;
			}
			// for right cell
			if (col + 1 < A.get(0).size() && A.get(row).get(col + 1) == 1) {
				q.add(new Pair(row, col + 1,(q.peek().min+1)));
				numberOfFreshOranges -= 1;
				A.get(row).set(col+1,2);
				updated=true;
			}
			q.poll();
			size-=1;
			}
			if (numberOfFreshOranges == 0)
			{
				
				return minutes;
			}
			
			   minutes++;
			//System.out.println("minutes --> "+minutes);
			
		}
		//System.out.println("number of fresh left ans q size "+numberOfFreshOranges+" "+q.size());
		if (numberOfFreshOranges <= 0)
		{
			
			return minutes;
		}
			
		else
			return -1;
		// return 0;

	}

}
