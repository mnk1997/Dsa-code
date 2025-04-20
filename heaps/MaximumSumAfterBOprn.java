import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ArrayList<Integer> list = new ArrayList<>(List.of(52,35));
        System.out.println("answer "+solve(list,10));
    }
    public static int solve(ArrayList<Integer> A, int B) {
        //convert min heap from array A only B element and put
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(A.size());

        for(int ele:A)
        {
            minHeap.add(ele);
        }
        int sum=0;
        while(B>0)
        {
            int ele= minHeap.poll()*-1;
            minHeap.add(ele);
            B-=1;
        }
        while(!minHeap.isEmpty())
        {
            sum+=minHeap.poll();
        }

        return sum;

    }
}