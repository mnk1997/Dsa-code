//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(boringSubstring("bcbc"));
    }
    public static int boringSubstring(String s)
    {
        int[] count = new int[26];
        for(char c : s.toCharArray())
        {
            count[c - 'a']++;
        }
        int oddmin,oddmax,evenmin,evenmax;
        oddmin =oddmax= -1;
        evenmin =evenmax= -1;
        for(int i = 0;i < 26;i++)
        {
            if(count[i] != 0)
            {
                if(i%2==0)
                {
                    if(evenmin == -1)
                        evenmin=i;

                    evenmax=i;
                }
                else {
                    if(oddmin == -1)
                        oddmin=i;
                    oddmax=i;
                }
            }
        }
        System.out.println("odd min "+oddmin);
        System.out.println(" odd max "+oddmax);
        System.out.println("even min "+evenmin);
        System.out.println("even max "+evenmax);
        if(Math.abs(evenmax-oddmin)== 1
                && Math.abs(evenmax -oddmax)== 1
                && Math.abs(evenmin -oddmin)== 1
                && Math.abs(evenmin - oddmax)== 1
        )
        {
            return 0;
        }
        return 1;
    }
}