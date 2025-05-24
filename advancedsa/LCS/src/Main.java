import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println(solve("bebdeeedaddecebbbbbabebedc","abaaddaabbedeedeacbcdcaaed"));
    }
    public static int solve(String A, String B) {
        int[][] dp=new int[A.length()+1][B.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,0);
        }
        for(int row=1;row<=A.length();row++){

            for(int col=1;col<=B.length();col++){
                if(A.charAt(row-1)==B.charAt(col-1)){
                    dp[row][col]=1+dp[row-1][col-1];
                }
                else {
                    dp[row][col]=Math.max(dp[row-1][col],dp[row][col-1]);
                }
            }
        }
        return dp[A.length()][B.length()];
    }
}