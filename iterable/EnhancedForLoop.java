package in.cdac.iterable;

public class EnhancedForLoop {
   public static void main(String[] args)
   {
	    Node head=new Node(1,new Node(2,new Node(3,new Node(4,null))));
	    Node h=null;
	    for(int n:head )
	    {
	    	System.out.println("n data "+n);
	    }
	   
   }
}
