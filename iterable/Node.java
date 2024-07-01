package in.cdac.iterable;

import java.util.Iterator;

public class Node implements Iterable<Integer> {
    private int data;
    private Node next;
  private Node temp;
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
        temp=this;
    }



	@Override
	public Iterator<Integer> iterator() {
		Iterator<Integer>itr=new Iterator<Integer>() {
			
			@Override
			public Integer next() {
			
			    int data=temp.data;
			    temp=temp.next;
			    return data;
				
			 
			}
			
			@Override
			public boolean hasNext() {
			
		     	 if(temp!=null)
		     		 return true;
		     	 else
		     		 return false;
			}
		};
		return itr;
	}

	
}