package in.cdac.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/*Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.

1 represents a wall in a matrix and 0 represents an empty location in a wall.

There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down,
left or right, but it won't stop rolling until hitting a wall 
(maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.

Given
 two array of integers of size B and C of 
 size 2 denoting the starting and destination position of the ball.

Find the shortest distance for the ball to stop at the destination. The distance is defined by the number
of empty spaces traveled by the ball from the starting position (excluded) to the destination (included).
If the ball cannot stop at the destination, return -1.*/

//challenges was to identify the direction in which ball is moving
//this is solved by maintaining the direction in Pair class 
/*  1-left
  2-right
  3-up
  4-down*/

public class ShortestDistanceInMaze {
	static class Pair {
		int x;
		int y;
		int direction;
		int distance;

		Pair(int x, int y, int direction, int dist) {
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.distance = dist;
			System.out.println(" x " + this.x + "   " + this.y + "   " + this.direction + "  dist " + dist);
		}
	}
	static class Coordinates {
		int x;
		int y;
		int direction;
		

		 Coordinates(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		//	this.distance = dist;
			System.out.println(" x " + this.x + "   " + this.y + "   " + this.direction );
		}


		@Override
		public int hashCode() {
			return Objects.hash(direction, x, y);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coordinates other = (Coordinates) obj;
			return direction == other.direction && x == other.x && y == other.y;
		}
		 
	}
	//[0,0,0],[0,0,0],[1,1,1],[0,0,1],[1,1,1],[1,0,0],[1,1,0],[0,0,1],[0,1,0],[0,1,0

	// [1,1,0,1],[0,0,0,1],[1,0,0,1],[0,0,1,0]
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		/*
		 * A.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0))); A.add(new
		 * ArrayList<>(Arrays.asList(0, 0, 1, 0))); A.add(new
		 * ArrayList<>(Arrays.asList(0, 0, 0, 0))); A.add(new
		 * ArrayList<>(Arrays.asList(0, 0, 1, 1))); A.add(new
		 * ArrayList<>(Arrays.asList(0, 0, 0, 0)));
		 */

		A.add(new ArrayList<>(Arrays.asList(0,0,0)));
		A.add(new ArrayList<>(Arrays.asList(0,0,0)));
		A.add(new ArrayList<>(Arrays.asList(1,1,1)));
		A.add(new ArrayList<>(Arrays.asList(0,0,1)));
		A.add(new ArrayList<>(Arrays.asList(1,1,1)));
		A.add(new ArrayList<>(Arrays.asList(1,0,0)));
		A.add(new ArrayList<>(Arrays.asList(1,1,0)));
		A.add(new ArrayList<>(Arrays.asList(0,0,1)));
		A.add(new ArrayList<>(Arrays.asList(0,1,0)));
		A.add(new ArrayList<>(Arrays.asList(0,1,0)));
    // A.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0)));

		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(5, 1));
		ArrayList<Integer> C = new ArrayList<>(Arrays.asList(9, 0));
		System.out.println(solve(A, B, C));
	}

	public static int solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C) {
		int N = A.size();
		int M = A.get(0).size();
		int[][] visited = new int[N][M];
		for (int[] e : visited) {
			Arrays.fill(e, Integer.MAX_VALUE);
		}
		int sx = B.get(0);
		int sy = B.get(1);
		int ex = C.get(0);
		int ey = C.get(1);
		Queue<Pair> q = new LinkedList<>();
		HashSet<Coordinates> hs=new HashSet<>();
		
		q.add(new Pair(sx, sy-1, 1, 0));
		hs.add(new Coordinates(sx, sy-1, 1));
		q.add(new Pair(sx, sy+1, 2, 0));
		hs.add(new Coordinates(sx, sy+1, 2));
		q.add(new Pair(sx-1, sy, 3, 0));
		hs.add(new Coordinates(sx-1, sy, 3));
		q.add(new Pair(sx+1, sy, 4, 0));
		hs.add(new Coordinates(sx+1, sy, 4));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int currX = p.x;
			int currY = p.y;
			int currDist = p.distance;
			int currDirecn = p.direction;
			if(currX<0 || currY<0 || currX >=A.size() || currY>=A.get(0).size() || A.get(currX).get(currY)==1)
			{
				continue;
			}
		
			switch (currDirecn) {
			case 1:
				//check for dest and whether ball will stop or not
				if(currX==ex && currY==ey && (currY==0 || A.get(currX).get(currY - 1)==1))
				{
					return (currDist+1);
				}
				else if (currY - 1 >= 0 && A.get(currX).get(currY - 1) != 1 && !hs.contains(new Coordinates(currX, currY - 1, currDirecn))) {
					q.offer(new Pair(currX, currY - 1, currDirecn, currDist + 1));
					hs.add(new Coordinates(currX, currY - 1, currDirecn));

				} 
				else if (currY-1 < 0 || A.get(currX).get(currY - 1) == 1) {
					// insert all the valid 3 direction if it is not visited
					/*
					 * if(!hs.contains(new Coordinates(currX, currY+1, 2))) { q.offer(new
					 * Pair(currX, currY+1, 2, currDist+1)); hs.add(new Coordinates(currX, currY+1,
					 * 2)); }
					 */
					if(!hs.contains(new Coordinates(currX-1, currY, 3)) )
					{
						q.offer(new Pair(currX-1, currY, 3, currDist+1));
						hs.add(new Coordinates(currX-1, currY, 3));
					}
					if(!hs.contains(new Coordinates(currX+1, currY, 4))) {
					
						q.offer(new Pair(currX+1, currY, 4, currDist+1));
						hs.add(new Coordinates(currX+1, currY, 4));
					}

				}

				break;
			case 2:
				if(currX==ex && currY==ey && (currY==A.get(0).size()-1 || A.get(currX).get(currY + 1)==1))
				{
					return (currDist+1);
				}
				else if (currY + 1 < A.get(0).size() && A.get(currX).get(currY + 1) != 1 && !hs.contains(new Coordinates(currX, currY + 1, currDirecn))) {
					q.offer(new Pair(currX, currY + 1, currDirecn, currDist + 1));
					hs.add(new Coordinates(currX, currY + 1, currDirecn));

				}
				else if (currY +1==A.get(0).size() || A.get(currX).get(currY+1) == 1) {
					// insert all the valid 3 direction if it is not visited
					/*
					 * if(!hs.contains(new Coordinates(currX, currY-1, 1))) { q.offer(new
					 * Pair(currX, currY-1, 1, currDist+1)); hs.add(new Coordinates(currX, currY-1,
					 * 1)); }
					 */
					if(!hs.contains(new Coordinates(currX-1, currY, 3)))
					{
						q.offer(new Pair(currX-1, currY, 3, currDist+1));
						hs.add(new Coordinates(currX-1, currY, 3));
					}
					if(!hs.contains(new Coordinates(currX+1, currY, 4))) {
					
						q.offer(new Pair(currX+1, currY, 4, currDist+1));
						hs.add(new Coordinates(currX+1, currY, 4));
					}

				}
				break;

			case 3:
				if(currX==ex && currY==ey && (currX==0 || A.get(currX-1).get(currY)==1))
				{
					return (currDist+1);
				}
				else if (currX - 1 >= 0 && A.get(currX-1).get(currY) != 1 && !hs.contains(new Coordinates(currX - 1, currY, currDirecn))) {
					q.offer(new Pair(currX - 1, currY, currDirecn, currDist + 1));
					hs.add(new Coordinates(currX - 1, currY, currDirecn));

				}
				else if (currX == 0 || A.get(currX-1).get(currY) == 1) {
					// insert all the valid 3 direction if it is not visited
					if(!hs.contains(new Coordinates(currX, currY+1, 2)))
					{
						q.offer(new Pair(currX, currY+1, 2, currDist+1));
						hs.add(new Coordinates(currX, currY+1, 2));
					}
					if(!hs.contains(new Coordinates(currX, currY-1, 1)))
					{
						q.offer(new Pair(currX, currY-1, 1, currDist+1));
						hs.add(new Coordinates(currX, currY-1, 1));
					}
					/*
					 * if(!hs.contains(new Coordinates(currX+1, currY, 4))) {
					 * 
					 * q.offer(new Pair(currX+1, currY, 4, currDist+1)); hs.add(new
					 * Coordinates(currX+1, currY, 4));
					 * 
					 * }
					 */

				}
				break;

			case 4:
				if(currX==ex && currY==ey && (currX==A.size()-1 || A.get(currX+1).get(currY)==1))
				{
					return (currDist+1);
				}
				else if (currX + 1 < A.size() && A.get(currX + 1).get(currY) != 1 && !hs.contains(new Coordinates(currX + 1, currY, currDirecn))) {
					q.offer(new Pair(currX + 1, currY, currDirecn, currDist + 1));
					hs.add(new Coordinates(currX + 1, currY, currDirecn));

				}
				else if (currX == A.size()-1 || A.get(currX+1).get(currY) == 1) {
					// insert all the valid 3 direction if it is not visited
					if(!hs.contains(new Coordinates(currX, currY+1, 2)))
					{
						q.offer(new Pair(currX, currY+1, 2, currDist+1));
						hs.add(new Coordinates(currX, currY+1, 2));
					}
					/*
					 * if(!hs.contains(new Coordinates(currX-1, currY, 3))) { q.offer(new
					 * Pair(currX-1, currY, 3, currDist+1)); hs.add(new Coordinates(currX-1, currY,
					 * 3)); }
					 */
					if(!hs.contains(new Coordinates(currX, currY-1, 1))) {
					
						q.offer(new Pair(currX, currY-1, 1, currDist+1));
						hs.add(new Coordinates(currX, currY-1, 1));
					}

				}
				break;

			default:

				break;
			}

		}
		
		return -1;

	}

	

}
