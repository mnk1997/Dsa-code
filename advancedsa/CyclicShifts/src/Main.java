//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      //  System.out.println(solve("0011000010","0101000001"));


        System.out.println(solve("01010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010","10101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101"));
    }
    public static int solve(String A, String B) {
        System.out.println("a length "+A.length());
        if(A.length()!=B.length()){
            System.out.println("no equal length");
            return 0;
        }
        if(A.contentEquals(B))
        {
            int[] idx=new int[2];
            for(char c:A.toCharArray())
            {
                if(c== '0')
                {
                    idx[0]+=1;
                }
                else
                {
                    idx[1]+=1;
                }
            }

            if((idx[0]!=0 && idx[1]==0 ) || (idx[0]==0 && idx[1]!=0))
            {
                //System.out.println("111111111");
                // case like 1111 11111
                return A.length();
            }
        }
        int aPtr=0;
        int bPtr=0;
        int[] z=new int[B.length()];

        while(bPtr<B.length() && aPtr<A.length()) {
            if(A.charAt(aPtr)==B.charAt(bPtr)) {
                int k=0;
                int itr=bPtr;
                while(aPtr<A.length() && A.charAt(aPtr)==B.charAt(itr))
                {
                    k++;
                    itr=(itr+1)%B.length();
                    aPtr++;
                }
                z[bPtr]=k;
               bPtr=itr<=bPtr?B.length():bPtr+1;
            }
            else {
                z[bPtr]=0;
                bPtr+=1;
            }

            aPtr=0;

        }

        int count=0;
        for(int i:z)
        {
            System.out.println(i);
            if(i==A.length())
            {
                count+=1;
            }
        }
        return count;
    }
}