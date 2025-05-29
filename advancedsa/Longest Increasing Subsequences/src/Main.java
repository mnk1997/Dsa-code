import java.util.Arrays;
import java.util.List;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        }


public static int lis(final List<Integer> A) {
    int[] lis=new int[A.size()];

    Arrays.fill(lis,1);

    for(int i=1;i<A.size();i++){
        for(int j=0;j<i;j++){
            if(A.get(j)<A.get(i)){
                int currLongestSubsequencePossible=lis[j]+1;
                if(lis[i]<currLongestSubsequencePossible){
                    lis[i]=currLongestSubsequencePossible;
                }
            }
        }
    }

    //iterate the complete lis and find max
    int currMax=lis[0];
    for(int i:lis)
    {
        if(currMax<i)
            currMax=i;
    }
    return currMax;
}
}