import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(isMatch("bcacabcbba'","c*??c*?**c*?'"));
    }
    public static int isMatch(final String A, final String B) {
        int[][] dp=new int[A.length()+1][B.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        boolean match= dpMatch(A,B,A.length(),B.length(),dp);
        if(match)
            return 1;
        else return 0;
    }

    private static  boolean dpMatch(String a, String b, int i, int j,int[][] dp) {
        if(dp[i][j]!=-1)
        {
            return dp[i][j] != 0;
        }
        if(i<=0) {
            //iterate the remainig j
           // System.out.println("j remain "+j);
            int k=j;
            while(k>0)
            {
                if(b.charAt(k-1)=='*')
                {
                    k-=1;
                }else
                {
                    System.out.println("false");
                    dp[i][j]=0;
                    return false;
                }
            }
            System.out.println("true");
            dp[i][j]=1;
            return true;
        }
        if(j<=0){
            dp[i][j]=0;
            return false;
        }

        //as both will have the same recurrence call
        if(a.charAt(i-1)==b.charAt(j-1) || b.charAt(j-1)=='?')
        {
            boolean result=dpMatch(a,b,i-1,j-1,dp);
            dp[i][j]=result?1:0;
            return result;
        }else if(b.charAt(j-1)=='*')
        {
            boolean result=dpMatch(a,b,i,j-1,dp) || dpMatch(a,b,i-1,j,dp) || dpMatch(a,b,i-1,j-1,dp);

            dp[i][j]=result?1:0;
            return result;

        }else {
           // System.out.println("char "+a.substring(0,i+1)+" B "+b.substring(0,j+1));
            dp[i][j]=0;
            return false;
        }

    }
}