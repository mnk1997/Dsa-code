package in.cdac.stack;

import java.util.ArrayDeque;

public class HotelServiceSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;this.y=y;
        }
    }
    public int[] nearestHotel(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int inf = Integer.MAX_VALUE;
        int[][] dis = new int[n + 2][m + 2];
        ArrayDeque < Node > q = new ArrayDeque < > ();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0) {
                    dis[i + 1][j + 1] = inf;
                } else {
                    dis[i + 1][j + 1] = 0;
                    q.add(new Node(i + 1, j + 1));
                }
            }
        }
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            if (dis[x][y + 1] == inf) {
                dis[x][y + 1] = dis[x][y] + 1;
                q.add(new Node(x, y + 1));
            }
            if (dis[x][y - 1] == inf) {
                dis[x][y - 1] = dis[x][y] + 1;
                q.add(new Node(x, y - 1));
            }
            if (dis[x + 1][y] == inf) {
                dis[x + 1][y] = dis[x][y] + 1;
                q.add(new Node(x + 1, y));
            }
            if (dis[x - 1][y] == inf) {
                dis[x - 1][y] = dis[x][y] + 1;
                q.add(new Node(x - 1, y));
            }
        }
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            ans[i] = dis[B[i][0]][B[i][1]];
        }
        return ans;
    }
}
}
