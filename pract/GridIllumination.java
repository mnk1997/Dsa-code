package in.cdac.pract;

public class GridIllumination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] lamps = { { 0, 0 }, { 0, 4 } };
		int[][] query = { { 1, 1 }, { 1, 1 } };
		for (int ele : gridIllumination(n, lamps, query)) {
			System.out.print(ele + " ");
		}
	}

	public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {

		// create 2d matrix of size n
		int[][] matrix = new int[n][n];
		for (int i = 0; i < lamps.length; i++) {
			int rowIndexToIgnite = lamps[i][0];
			int colIndexToIgntie = lamps[i][1];
			matrix[rowIndexToIgnite][colIndexToIgntie] += 1;
			igniteAlltheNeighbouring(rowIndexToIgnite, colIndexToIgntie, matrix);

		}
		int[] ans = new int[queries.length];
		int k = 0;
		// searching queries
		for (int i = 0; i < queries.length; i++) {
			int r = queries[i][0];
			int c = queries[i][1];
			if (matrix[r][c] == 0)
				ans[k++] = 0;
			else
				ans[k++] = 1;

			matrix[r][c] -= 1;
			turnOffAllTheLampsEightAdjacent(r, c, matrix);
		}
		return ans;

	}

	private static void turnOffAllTheLampsEightAdjacent(int r, int c, int[][] matrix) {
		// TODO Auto-generated method stub

		int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int n = matrix.length;
		//matrix[r][c] = 0;
		for (int i = 0; i < dx.length; i++) {
			if (checkValidCorrdinates(r + dx[i], c + dy[i], n)) {

				matrix[r + dx[i]][c + dy[i]] -= 1;
			}
		}

	}

	private static boolean checkValidCorrdinates(int i, int j, int n) {
		if (i < 0 || j < 0 || i >= n || j >= n)
			return false;
		return true;
	}

	private static void igniteAlltheNeighbouring(int rowIndexToIgnite, int colIndexToIgntie, int[][] matrix) {
		// TODO Auto-generated method stub
		igniteTheEntireRow(rowIndexToIgnite, matrix);
		igniteTheEntireColumn(colIndexToIgntie, matrix);
		igniteTheEntireLeftDiagnoal(rowIndexToIgnite, colIndexToIgntie, matrix);
		igniteTheEntireRightDiagnoal(rowIndexToIgnite, colIndexToIgntie, matrix);

	}

	private static void igniteTheEntireRightDiagnoal(int rowIndexToIgnite, int colIndexToIgntie, int[][] matrix) {
		// TODO Auto-generated method stub
		igniteRightTop(rowIndexToIgnite - 1, colIndexToIgntie + 1, matrix);
		igniteRightDown(rowIndexToIgnite + 1, colIndexToIgntie - 1, matrix);

	}

	private static void igniteRightDown(int i, int j, int[][] matrix) {
		// TODO Auto-generated method stub
		if (!checkValidCorrdinates(i, j, matrix.length))
			return;
		matrix[i][j] += 1;
		igniteRightDown(i + 1, j - 1, matrix);

	}

	private static void igniteRightTop(int i, int j, int[][] matrix) {
		// TODO Auto-generated method stub
		if (!checkValidCorrdinates(i, j, matrix.length))
			return;
		matrix[i][j] += 1;
		igniteRightTop(i - 1, j + 1, matrix);

	}

	private static void igniteTheEntireLeftDiagnoal(int rowIndexToIgnite, int colIndexToIgntie, int[][] matrix) {
		// TODO Auto-generated method stub
		igniteLeftTop(rowIndexToIgnite - 1, colIndexToIgntie - 1, matrix);
		igniteLeftDown(rowIndexToIgnite + 1, colIndexToIgntie + 1, matrix);

	}

	private static void igniteLeftDown(int i, int j, int[][] matrix) {
		// TODO Auto-generated method stub
		if (!checkValidCorrdinates(i, j, matrix.length))
			return;
		matrix[i][j] += 1;
		igniteLeftDown(i + 1, j + 1, matrix);

	}

	private static void igniteLeftTop(int i, int j, int[][] matrix) {
		// TODO Auto-generated method stub
		if (!checkValidCorrdinates(i, j, matrix.length))
			return;
		matrix[i][j] += 1;
		igniteLeftDown(i - 1, j - 1, matrix);

	}

	private static void igniteTheEntireColumn(int colIndexToIgntie, int[][] matrix) {
		// TODO Auto-generated method stub
		for (int row = 0; row < matrix.length; row++) {
			matrix[row][colIndexToIgntie] += 1;
		}

	}

	private static void igniteTheEntireRow(int rowIndexToIgnite, int[][] matrix) {
		// TODO Auto-generated method stub
		for (int col = 0; col < matrix.length; col++) {
			// System.out.println("Turning off "+(rowIndexToIgnite)+" "+(col));
			matrix[rowIndexToIgnite][col] += 1;
		}

	}

}
