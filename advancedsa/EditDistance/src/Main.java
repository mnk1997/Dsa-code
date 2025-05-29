import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println( minDistance("Mayank","Nidhi"));
    }
    public static  int minDistance(String A, String B) {
        int[][] dp=new int[A.length()+1][B.length()+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
       return minDistanceUsingDpUsingArray(A,B,A.length()-1,B.length()-1,dp);
    }

    private static  int minDistanceUsingDp(String a, String b, int i, int j) {
        if(i<0 && j<0)
            return 0;
        if(i<0)
        {
            return j+1;
        }
        if(j<0)
        {
            return i+1;
        }

        if(a.charAt(i)==b.charAt(j))
            return minDistanceUsingDp(a, b, i - 1, j - 1);
        else return  1 + Math.min(minDistanceUsingDp(a,b,i-1,j),Math.min(minDistanceUsingDp(a,b,i,j-1),minDistanceUsingDp(a,b,i-1,j-1)));

    }

    private static  int minDistanceUsingDpUsingArray(String a, String b, int i, int j,int[][] dp) {
        if(i<0 && j<0)
            return 0;
        if(i<0)
        {
            return j+1;
        }
        if(j<0)
        {
            return i+1;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(a.charAt(i)==b.charAt(j))
        {
            dp[i][j]=minDistanceUsingDpUsingArray(a, b, i - 1, j - 1,dp);
            return dp[i][j];
        }
        else dp[i][j]=  1 + Math.min(minDistanceUsingDpUsingArray(a,b,i-1,j,dp),Math.min(minDistanceUsingDpUsingArray(a,b,i,j-1,dp),minDistanceUsingDpUsingArray(a,b,i-1,j-1,dp)));
        return dp[i][j];

    }
}