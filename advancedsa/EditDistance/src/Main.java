//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println( minDistance("Nidhi","Mayank"));
    }
    public static  int minDistance(String A, String B) {
       return minDistanceUsingDp(A,B,A.length()-1,B.length()-1);
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
}