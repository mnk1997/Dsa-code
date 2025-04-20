import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
        public static TreeNode setTreeNode(ArrayList<Integer> list) {
            System.out.println("list size" + list.size());
            TreeNode head = null;
            Queue<TreeNode> q = new LinkedList<>();
            for (int i = 0; i < list.size(); i += 2) {

                if (i == 0) {
                    head = new TreeNode(list.get(0));
                    if (list.get(i + 1) == -1)
                        head.left = null;
                    else {
                        head.left = new TreeNode(list.get(i + 1));
                        q.add(head.left);
                    }
                    if (list.get(i + 2) == -1)
                        head.right = null;
                    else {
                        head.right = new TreeNode(list.get(i + 2));
                        q.add(head.right);
                    }

                } else {
                    if (q.isEmpty()) {
                        break;
                    }
                    TreeNode curr = q.poll();
                    if (i + 1 >= list.size()) {
                        curr.left = null;
                        curr.right = null;
                        continue;
                    }
                    if (i + 1 < list.size() && list.get(i + 1) == -1)
                        curr.left = null;
                    else {
                        curr.left = new TreeNode(list.get(i + 1));
                        q.add(curr.left);
                    }
                    if (i + 2 >= list.size()) {
                        curr.right = null;
                        continue;
                    }
                    if (i + 2 < list.size() && list.get(i + 2) == -1)
                        curr.right = null;
                    else {
                        curr.right = new TreeNode(list.get(i + 2));
                        q.add(curr.right);
                    }

                }
            }
            return head;
        }

    }
    public static void main(String[] args) {

        TreeNode A = TreeNode.setTreeNode(new ArrayList<>(List.of(6 ,2 ,7 ,1, 5, -1, -1, -1, -1, -1, -1)));
        System.out.println("answer "+solve(A,7,18));

        }

    public static int solve(Main.TreeNode A, int B, int C) {

         int count = 0;
         //Inorder traversal of TreeNode
        ArrayList<Integer> inorder = new ArrayList<>();
        findInOrderTraversalOfGivenBst(A,inorder);

        //find index of B using Binary search
         int idxOne= findIndexOrJustSmallerNumberUsingBinarySearch(inorder,B);
        System.out.println("indexOne "+idxOne);
         if(idxOne<0)
         {
             idxOne=0;
         }
         else if(idxOne>=inorder.size())
         {
             idxOne=inorder.size()-1;
         }

        //find index of C using Binary sEarch
         int idxTwo = findIndexOrJustSmallerNumberUsingBinarySearch(inorder,C);
        System.out.println("index two "+idxTwo);

            if(idxTwo<0)
            {
                idxTwo=0;
            }
            else if(inorder.get(idxTwo)!=C)
            {
                idxTwo-=1;
            }

        //retur the difference
//        count=idxTwo-idxOne;
//            if(count==0)
//                return 0;
//         return count+1;


         return countNumberUsingLinearSearch(inorder,B,C);
    }
    private static int countNumberUsingLinearSearch(ArrayList<Integer> list, int B,int C) {
        int count = 0;
        for(int ele:list)
        {
            if(ele>=B && ele<=C)
                count+=1;
        }
        return count;
    }

    private static int findIndexOrJustSmallerNumberUsingBinarySearch(ArrayList<Integer> inorder, int b) {
        int left = 0;
        int right = inorder.size() - 1;


        while (left <=right) {
            int mid = (left + right) / 2;
            if (mid<=0 ||inorder.get(mid) == b || (inorder.get(mid-1) < b && inorder.get(mid) > b)) {
                return mid;
            }
            else if(inorder.get(mid) > b) {
                right=mid-1;

            }
            else
            {
                left=mid+1;
            }
        }
        return left;
    }

    //inorder using morris algo
    private static void findInOrderTraversalOfGivenBst(TreeNode curr, ArrayList<Integer> inorder) {
        TreeNode temp;
        while(curr!=null)
        {
            temp=curr.left;
            if(temp==null)
            {
                inorder.add(curr.val);
                curr=curr.right;
            }
            else {
                while(temp.right!=null && temp.right!=curr)
                {
                    temp=temp.right;
                }
                //this node is still unexplored need to add predecessor
                if(temp.right==null)
                {
                    temp.right=curr;
                    curr=curr.left;
                }else{
                    temp.right=null;
                    inorder.add(curr.val);
                    curr=curr.right;
                }
            }
        }
    }
}