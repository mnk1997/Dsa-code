//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println(  periodOfString("abcaabcaab"));
    }
    public static  int periodOfString(String str) {
        int[] z=new int[str.length()];
        z[0]=-1;
        int l=0;
        int r=1;
        int ans=str.length();
        while(r<str.length()){
            //System.out.println(" loop "+r);
            int k=0;
            if(str.charAt(r)==str.charAt(l)) {
                int itr = r;
                while (itr < str.length() && str.charAt(itr) == str.charAt(l)) {
                    k++;
                    itr++;
                    l++;

                }
                z[r]=k;
                r=itr;
            }else {
                z[r]=0;
                r++;
            }
            l=0;
        }
        for(int i=0;i<z.length;i++){
            if(i+z[i]==str.length()){
                return i;
            }
        }
        System.out.println("from ans");
    return ans;
    }
}