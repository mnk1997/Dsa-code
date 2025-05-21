import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static class TrieNode
    {
        boolean isEnd;
        ArrayList<TrieNode> children;
        int allWord;
        public TrieNode()
        {
            isEnd = false;

            children = new ArrayList<>(Collections.nCopies(26, null));
            allWord = 0;
            //Arrays.fi
        }

    }
    public static void main(String[] args) {

        ArrayList<String> A=new ArrayList<>(List.of("zebra","dog","duck","dot"));
        for(String prefixUnique:prefix(A))
        {
            System.out.println(prefixUnique);
        }

    }
    public static    ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> B = new ArrayList<>();
        //create trie for the inputs .
       TrieNode root= createTrie(A);
        TrieNode cur;
        for(String word : A)
        {
            cur = root;
            StringBuilder builder = new StringBuilder("-");
            for(char ch : word.toCharArray())
            {
                builder.append(ch);
                int idx=getIndexOfCurrentCharacter(ch);
                cur=cur.children.get(idx);
                if(cur.allWord==1)
                {
                    B.add(builder.toString());
                    break;
                }
            }
            if(cur.isEnd)
            {
                builder.delete(1, builder.length());
                B.add(builder.toString());
            }

        }

        return B;
    }

    //assuming each char is in small letter
    private static TrieNode createTrie(ArrayList<String> a) {
        TrieNode root = new TrieNode();
        TrieNode currNode;
        for(String s : a)
        {
            //System.out.println("Current word: ------------------------------------"+s);
            currNode = root;
            currNode.allWord+=1;
            for(char c : s.toCharArray())
            {

               // System.out.println("currNode size "+currNode.children.size());
                //get the node of current character
                int idx= getIndexOfCurrentCharacter(c);
              //  currNode=currNode.children.get(idx);
                if(currNode.children.get(idx)==null)
                {
                    TrieNode newNode = new TrieNode();
                    currNode.children.set(idx,newNode);

                }
                    currNode = currNode.children.get(idx);
                    currNode.allWord+=1;

               // System.out.println(currNode.allWord);


            }
            currNode.isEnd = true;
        }
        return root;
    }

    private static int getIndexOfCurrentCharacter(char c) {
        return c - 'a';
    }

}