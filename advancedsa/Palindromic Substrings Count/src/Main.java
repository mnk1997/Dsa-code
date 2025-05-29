import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(solve("bbeaadcc"));

    }

    public static int solve(String A) {
        boolean[][] isPal = new boolean[A.length()][A.length()];
        for (boolean[] rows : isPal) {
            Arrays.fill(rows, true);
        }


        makeThePallindromeArray(isPal, A);

        int numberOfPal = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = i; j < A.length(); j++) {
                if (isPal[i][j]) {
                    numberOfPal++;
                }
            }
        }
        return numberOfPal;
    }


    private static void makeThePallindromeArray(boolean[][] isPal, String a) {
        // System.out.println("called for "+i +" "+j);
        for (int i = a.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < a.length(); j++) {
                isPal[i][j] = isPal[i + 1][j - 1] && a.charAt(i) == a.charAt(j);
            }
        }

    }
}