import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("answer : "+wordBreak("aababaaabaaababbbabbbaabababaaabbaabaabbabbaabbbbbbbabbbbabaaabaabaabbaaaaabbabaababbbabbbbbbaaaabbbaaaaaabaaaaaabbbbbbbabbbbbbbbaaabaaababbbaaaabaaaabaaaabbabbbabaabbabbabaaaabbabaaabbabbabbbabbabbaabbbabaabaabbbbbbbaabababbbbbbababbbaabaabbbabababbbbbaaaababbbabaaabaabbaababbbabbbbbaabbaaaaabbbbbaaaaaaaaaaaabbabbbabbaaabaaaaaabaabababaabaaaabaaabbbbbaaabbaabbababbabbbbaabaabaabaaaabbbaababbaabbbbbabaaababbabbbabbbbbabaababbbbbaabbbbabaabbabbababaaaabbbbabbbaaaabaabbbbaaaaababaaabaabbabaababbabbbababaaababbaabbbaaabaabbbaabbbbbbaaabaabbbbbabaaababaaabbbbbbaaaabababaaabbbbbbaabbaaabbbabaabbabababbabaabbaaabbaaabbaabbbbbababbaabbabbb",
                new ArrayList<>(List.of("baaaaaabba","babbaababb","abb","bababaabab","baaa","ab","ab","bb","abbaaaa","bbababa","bbbbbbab","abbaaabba","aaaabbab","abaaab","babab","aabaaab","aabaabbabb","aa","bb","ab","a","a","bbaaab","aba","ba","bbabbaabab","aaabbbbbb","abbaaaabbb","aabaabbaa","bbba","abbabbba","abbbbabb","bbaaba","abbbbaab","bba","bbbbaabba","ababbabaab","baabba","ababbaabb","bbaab","a","bbba","aaaa","aaabbbabba","bab","baaaabaa","ab","aaabbaab","bab","aa","ababababab","aabbaaaba","abbaaba","bbaabaa"))));

    }

    public static int wordBreak(String A, ArrayList<String> B)
    {
        HashSet<String> set = new HashSet<>(B);
        boolean[] isTrue = new boolean[A.length()+1];
        Arrays.fill(isTrue, true);
        if(checkSubWord(0,A.length(),set,A,isTrue))
            return 1;
        else
            return 0;
    }

    public static boolean checkSubWord(int currIdx, int length, HashSet<String> set, String b,boolean[] isTrue) {
        if(currIdx >= length)
            return true;

        System.out.println("curr Idx "+currIdx);
        StringBuilder tempWord=new StringBuilder("");
        for(int itr = currIdx; itr < length; itr++)
        {
           tempWord.append(b.substring(currIdx, itr+1));
            //System.out.println("tempWord "+tempWord);
           if(set.contains(tempWord.toString()))
           {
               if(isTrue[currIdx] && checkSubWord(itr+1,length,set,b,isTrue))
               {
                   return true;
               }


           }
            tempWord.delete(0,tempWord.length());
        }
        isTrue[currIdx] = false;
        return false;

    }
}