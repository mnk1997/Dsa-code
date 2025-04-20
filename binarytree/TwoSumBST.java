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

        TreeNode A = TreeNode.setTreeNode(new ArrayList<>(List.of(10,9,20,-1,-1,-1,-1)));
        System.out.println("head node val"+A.val +"left chile "+A.left.val+" right chile "+A.right.val);
        int B=19;

        //find the node which is just lesser than the current value of B
        TreeNode node=findNodeJustLessThanB(A,B);

        if(node==null) {
            System.out.println("Ans is " + 0);
            return;
        }
        System.out.println("Node vale "+node.val);
        ArrayList<Integer> ele=new ArrayList<>();
        inOrderTraversalFromGivenNode(node,ele);
        System.out.println("Answer is "+ findSumEqualToB(ele,B));
    }
    public static TreeNode findNodeJustLessThanB(TreeNode A, int B)
    {
        TreeNode temp=A;

        while(temp!=null)
        {
            if(B>temp.val)
            {
                break;
            }
            else
            {
                temp=temp.left;
            }
        }
        return temp;
    }
    public  static void inOrderTraversalFromGivenNode(TreeNode node, ArrayList<Integer> list)
    {
        TreeNode currNode=node;
        TreeNode temp=currNode;
        while(currNode!=null)
        {
            temp=currNode.left;
            if(temp==null)
            {
                list.add(currNode.val);
                currNode=currNode.right;

            }
            else{
                //check for whether this node is already visited  :make null
                //or first time visit : then assign predecessor
                while(temp.right !=null && temp.right!=currNode)
                {
                    temp=temp.right;
                }
                if(temp.right==null)
                {
                    //this is the case which means still not explored
                    temp.right=currNode;
                    currNode=currNode.left;
                }
                else{
                    //this is the case which means node is already visited
                    temp.right=null;
                    list.add(currNode.val);
                    currNode=currNode.right;
                }
            }
        }
    }
    public static int findSumEqualToB(ArrayList<Integer>list,int B)
    {
        //using two pointer approach we can simply find the sum equal to B or not
        int firstPtr=0;
        int secondPtr=list.size()-1;
        while(firstPtr<secondPtr)
        {
            if(list.get(firstPtr)+list.get(secondPtr)==B)
                return 1;
            else if(list.get(firstPtr)+list.get(secondPtr)>B)
            {
                secondPtr-=1;
            }
            else{
                firstPtr+=1;
            }
        }
        return 0;
    }

}