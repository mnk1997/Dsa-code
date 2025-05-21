import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static  class Trie
    {
        boolean isEndOfWord;
        ArrayList<Trie> children;
        public Trie()
        {
            isEndOfWord = false;
            children = new ArrayList<>(Collections.nCopies(26,null));

        }
    }
    public static void main(String[] args) {
        ArrayList<String> A=new ArrayList<>(List.of("mayank","mihir","reena"));
        ArrayList<String> B=new ArrayList<>(List.of("mayankwa","mihir","rena","maya"));
        for(int i:solve(A,B))
        {
            System.out.println(i);
        }

    }
    public static  ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        ArrayList<Integer> res = new ArrayList<>();
        Trie root = new Trie();
        //create the trie for the dictionary A
        createTrieUsingList(A,root);
        //iterate each word and check whether spelling is okay or not
        spellChecker(B,root,res);
        return res;
    }

    private static void spellChecker(ArrayList<String> b, Trie root, ArrayList<Integer> res) {
        for(String word : b)
        {
            Trie current = root;
            boolean found = true;
            for(char c : word.toCharArray())
            {
                int index = c - 'a';
                current = current.children.get(index);
                if(current == null)
                {
                    found = false;
                    break;
                }
            }
            if(!found || !current.isEndOfWord)
                res.add(0);
            else
                res.add(1);
        }
    }

    private static void createTrieUsingList(ArrayList<String> a, Trie root) {
        Trie cur ;
        for(String word : a)
        {
            cur= root;
            for(char c : word.toCharArray())
            {
                int index = c - 'a';
                if(cur.children.get(index) == null)
                {
                    Trie child = new Trie();
                    cur.children.set(index,child);
                }
                cur = cur.children.get(index);
            }
            cur.isEndOfWord = true;

        }
    }
}