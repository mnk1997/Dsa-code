import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        System.out.println();
        ArrayList<Integer> list = new ArrayList<>(List.of(11,-32,34,11,-5,-3,-28,18,31,29));

        int ans=solve(list,-28,-15,0);
        System.out.println(ans);
    }

    public static int solve(ArrayList<Integer> A, int B, int C, int D) {

        int[][] dp=new int[4][A.size()+1];
        int ans=0;
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[i].length;j++)
            {
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        for(int col=1;col<dp[1].length;col++)
        {
            dp[1][col]=Math.max(dp[1][col-1],A.get(col-1)*B);
        }
        for(int row=0;row<dp.length;row++)
        {
            for(int col=0;col<dp[row].length;col++)
            {
                System.out.print(dp[row][col]+" ");
            }
            System.out.println();
        }
        int[] val={B,C,D};
        for(int i=2;i<dp.length;i++)
        {
            for(int j=1;j<dp[i].length;j++)
            {
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]+(val[i-1]*A.get(j-1)));
            }
        }
        ans=dp[3][A.size()];
        return ans;
    }
}