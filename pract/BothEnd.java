package in.cdac.pract;

public class BothEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] A = { 5, 6, 3, 1, 2 };

		int[] A = { -533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173,
				436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701,
				35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277,
				741, 529, -222, -684, 35 };

		// int[] A = { 5, -2, 3, 1, 2 };
		System.out.println("ANSWER " + solve(A, 48));

	}

	public static int solve(int[] A, int B) {
		int sum = 0;
		int[] prefix = new int[A.length];
		int[] suffix = new int[A.length];
		int totalLength = A.length;
		for (int i = 0; i <= totalLength - 1; i++) {
			if (i == 0) {
				prefix[i] = A[i];
			} else {
				prefix[i] = A[i] + prefix[i - 1];
			}
		}

		for (int i = totalLength - 1; i >= 0; i--) {
			if (i == totalLength - 1) {
				suffix[i] = A[i];
			} else {
				suffix[i] = A[i] + suffix[i + 1];
			}
		}

		int start = totalLength - B;
		int end;
		while (start != 0) {
			end = start + B - 1;
			if (start == 0) {
				System.out.println("Can never reach here");
				// =prefix[end];
			}
			if (end == totalLength - 1)
				sum = suffix[start] - suffix[end] > sum ? suffix[start] - suffix[end] : sum;
			if (end < totalLength - 1)
				sum = suffix[start] - suffix[end + 1] > sum ? suffix[start] - suffix[end + 1] : sum;
			if (end >= totalLength) {
				end = end % (totalLength);
				sum = suffix[start] + prefix[end] > sum ? suffix[start] + prefix[end] : sum;
			}

			start = (start + 1) % totalLength;
		}
		// when start 0 moving forward
		/*
		 * sum=prefix[B-1]>sum?prefix[B-1]:sum; //when start n-1 moving forward
		 * sum=suffix[totalLength-1]+prefix[B-2]>sum?suffix[totalLength-1]+prefix[B-2]:
		 * sum; //when end to backward
		 * sum=suffix[totalLength-B]>sum?suffix[totalLength-B]:sum; //when start to
		 * backward
		 * sum=prefix[0]+suffix[totalLength-B-2]>sum?prefix[0]+suffix[totalLength-2]:
		 * sum;
		 */

		sum = prefix[B - 1] > sum ? prefix[B - 1] : sum;

		return sum;
	}

	/*
	 * public static int solve(int[] A, int B) { int n = A.length; int sum =
	 * Integer.MIN_VALUE;
	 * 
	 * int[] prefix = new int[n]; int[] suffix = new int[n]; prefix[n - B - 1] = A[n
	 * - B - 1]; for (int i = n - B; i <= n - 1; i++) { prefix[i] = prefix[i - 1] +
	 * A[i]; if (prefix[i] > sum && i == n - 1)
	 * 
	 * { System.out.println("prefix[i] last " + prefix[i] + "    i:" + i); sum =
	 * prefix[i]; } } prefix[0] = A[0] + prefix[n - 1] - prefix[n - B]; if
	 * (prefix[0] > sum) { sum = prefix[0]; } for (int i = 1; i <= B - 1; i++) { if
	 * (prefix[i] == 6253) { System.out.println("found 6253" + i); } //
	 * System.out.println("Else part for " + i + " suffix of i-1" + suffix[i - 1]);
	 * prefix[i] = prefix[i - 1] + A[i] - prefix[(n - (B - i)) % n];
	 * 
	 * if (prefix[i] > sum)
	 * 
	 * { System.out.println("suffix[i] " + prefix[i] + "    i:" + i); sum =
	 * prefix[i]; } } suffix[B - 1] = A[B - 1]; for (int i = B - 2; i >= 0; i--) {
	 * 
	 * // System.out.println("Else part for "+i+" suffix of i-1"+suffix[i+1] );
	 * suffix[i] = suffix[i + 1] + A[i]; if (suffix[i] == 6253) {
	 * System.out.println("found 6253" + i); }
	 * 
	 * if (suffix[i] > sum && i == 0)
	 * 
	 * { System.out.println("suffix[i] " + suffix[i] + "    i:" + i); sum =
	 * suffix[i]; } } int c = 1; suffix[n - 1] = suffix[0] + A[n - 1] - suffix[B -
	 * c++]; if (suffix[n - 1] > sum)
	 * 
	 * { System.out.println("suffix[i] last " + suffix[n - 1] + "    i:" + (n - 1));
	 * sum = suffix[n - 1]; } for (int i = n - 2; i >= n - B + 1; i--) { suffix[i] =
	 * suffix[i + 1] + A[i] - suffix[B - c++]; if (suffix[i] == 6253) {
	 * System.out.println("found 6253" + i); }
	 * 
	 * if (suffix[i] > sum)
	 * 
	 * { System.out.println("suffix[i] last " + suffix[i] + "    i:" + i); sum =
	 * suffix[i]; } } for (int i = 0; i < n - 1; i++) { if (prefix[i] == 6253) {
	 * System.out.println("found  prefix" + i); sum = 6253; return sum; }
	 * 
	 * } for (int i = 0; i < n - 1; i++) { if (suffix[i] == 6253) {
	 * System.out.println("found  suffix" + i); sum = 6253; return sum; }
	 * 
	 * }
	 * 
	 * sum=
	 * 
	 * return sum; }
	 */

}
