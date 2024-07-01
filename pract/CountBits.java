package in.cdac.pract;

public class CountBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] res = countBits(15);
		// System.out.println(Math.pow(0, 2));
		for (int i : res) {
			System.out.print(i + " ");
		}

	}

	public static int[] countBits(int n) {
		int pwr = 0;
		int[] ans = new int[n + 1];
		int lastExpo = 0;
		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				ans[i] = 0;
			} else if (Math.pow(2, pwr) == i) {
				pwr++;
				ans[i] = 1;
				lastExpo = i;

			} else {
				ans[i] = ans[lastExpo] + ans[i - lastExpo];
			}

		}

		return ans;

	}

}
