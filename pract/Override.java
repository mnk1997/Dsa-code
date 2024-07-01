package in.cdac.pract;


import java.util.ArrayList;

import java.util.Arrays;

import java.util.Comparator;

import java.util.PriorityQueue;

public class Override {

	static int[] dx = new int[] { -1, 1, 0, 0 };

	static int[] dy = new int[] { 0, 0, -1, 1 };

	public int solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C) {

		return findMinDist(A, new int[] { B.get(0), B.get(1) }, new int[] { C.get(0), C.get(1) });

	}

	public static int findMinDist(ArrayList<ArrayList<Integer>> maze, int[] start, int[] destination) {

		int n = maze.size();

		int m = maze.get(0).size();

		int sx = start[0];

		int sy = start[1];

		int ex = destination[0];

		int ey = destination[1];

		int[][] v = new int[n][m];

		for (int[] row : v)

			Arrays.fill(row, Integer.MAX_VALUE);

		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.a));

		int i, d, d1, x, y, x1, y1, x2, y2;

		pq.offer(new Pair(0, sx, sy));

		while (!pq.isEmpty() && v[ex][ey] == Integer.MAX_VALUE) {

			Pair temp = pq.poll();

			x = temp.b;

			y = temp.c;

			d = temp.a;

			if (v[x][y] != Integer.MAX_VALUE) {

				continue;

			} else {

				v[x][y] = d;

			}

			for (i = 0; i < 4; ++i) {

				x1 = x;

				y1 = y;

				d1 = 0;

				while (true) {

					x2 = x1 + dx[i];

					y2 = y1 + dy[i];

					if (inside(x2, y2, n, m) && maze.get(x2).get(y2) == 0) {

						x1 = x2;

						y1 = y2;

						++d1;

					} else {

						break;

					}

				}

				if (d1 > 0 && v[x1][y1] == Integer.MAX_VALUE) {

					pq.offer(new Pair(d + d1, x1, y1));

				}

			}

		}

		return v[ex][ey] != Integer.MAX_VALUE ? v[ex][ey] : -1;

	}

	static boolean inside(int x, int y, int n, int m) {

		return (x >= 0 && x <= n - 1 && y >= 0 && y <= m - 1);

	}

}

class Pair {

	int a, b, c;

	public Pair(int u, int v, int w) {

		this.a = u;

		this.b = v;

		this.c = w;

	}

}