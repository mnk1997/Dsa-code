package in.cdac.LinkedList;

import java.util.HashMap;

//import org.jsoup.nodes.Node;

//7 2 G 2 S 2 6 G 1 S 1 5 S 1 2 G 1 G 2
/* 6 1 S 2 1 S 2 2 G 2 S 1 1 S 4 1 G 2 */

/*7 S 2 1 S 1 10 S 8 13 G 12 S 2 8 G 11 G 7 S 14 7 S 12 9 S 7 10 G 11 S 9 3 S 14 15 G 15 G 9 S 4 13 G 3 S 13 7 G 2 S 5 9 G 6 G 13 S 4 5 S 3 2 S 4 12 G 13 G 7 S 9 7 G 3 G 6 G 2 S 8 4 S 8 9 S 1 4 S 2 9 S 8 8 G 13 G 3 G 13 G 6 S 3 8 G 14 G 4 S 5 6 
S 10 15 G 12 S 13 5 S 10 9 S 3 12 S 14 15 G 4 S 10 5 G 5 G 15 S 7 6 G 1 S 5 12 S 1 6 S 11 8*/
public class LRU {
	public static void main(String[] args)
	{
		LRU imp=new LRU(2);
		//System.out.println(imp.get(2));
		System.out.println();
		imp.set(2, 1);
		imp.set(1, 1);
		imp.set(2, 3);
		imp.set(4, 1);
		System.out.println(imp.get(1));
		System.out.println(imp.get(2));
		
		
		
		
		/*
		 * System.out.println("capacity "+imp.getCapacity());
		 * System.out.println(imp.get(2)); imp.set(1, 1); imp.set(4, 1);
		 * System.out.println("capacity"+imp.getCapacity());
		 * System.out.println(imp.get(2));
		 */
	}

	 int capacity;
	  HashMap<Integer,cache> hm;
	    public class cache<T>
	    {
	    	public int key;
	        public int data;
	        public cache next;
	        public cache prev;
	        public cache(int data,int key)
	        {
	        	this.key=key;
	            this.data=data;
	            this.next=null;
	            this.prev=null;
	        }
	    }
	    cache head=null;
	    cache tail=null;
	    public int getCapacity()
	    {
	    	return this.capacity;
	    }
	    public LRU(int capacity) {
	        this.capacity=capacity;
	        hm=new HashMap<>(capacity);
	        
	    }
	    
	    public <? super Integer> int get(int key) {
	    	System.out.println("hm size"+hm.size()+"   capacity"+capacity);
	    	
	        if(hm.size()==0)
	        {
	            return -1;
	        }
	        else if(hm.containsKey(key))
	        {
	                return hm.get(key).data;
	        }
	        else{
	            return -1;
	        }
	        
	    }
	    
	    public void set(int key, int value) {
	    	System.out.println("called set ");
	        if(hm.containsKey(key))
	        {
	        	
	        	System.out.println("called IF set ");
	               cache nodeToDelete=hm.get(key);
	               nodeToDelete.data=value;
	               if(nodeToDelete==head && nodeToDelete==tail)
	               {
	            	   //only 1 node present
	            	   nodeToDelete.data=value;
	               }
	               //checking for first node
	               else if(nodeToDelete.prev==null)
	               {
	                   //if first node 
	            	   head=head.next;
	            	   head.prev=null;
	            	   nodeToDelete.next=null;
	            	   nodeToDelete.prev=tail;
	            	   tail.next=nodeToDelete;
	            	   tail=nodeToDelete;
	               }
	               else if(nodeToDelete.next==null)
	               {
	            	   
	               }
	               else{
	                   //for any node in between 
	                  nodeToDelete.prev.next=nodeToDelete.next;
	                  nodeToDelete.next.prev=nodeToDelete.prev;
	                  nodeToDelete.prev=tail;
	                  nodeToDelete.next=null;
	                  tail.next=nodeToDelete;
	                  tail=tail.next;
	               }
	              
	        }
	        else{
	        	System.out.println("called ELSE set ");
	            //creating new node 
	            cache newNode=new cache(value,key);
                 if(hm.size()==0)
                 {
                	 hm.put(key, newNode);
                	 head=newNode;
                	 tail=newNode;
                	 return;
                 }
	            //check whether it is first element
	            if(hm.size()<capacity)
	            {
	                tail.next=newNode;
	                newNode.prev=tail;
	                tail=tail.next;
	                hm.put(key, newNode);
	            }
	            //first check whether capacity is full or nodeToDelete
	            else if(hm.size()==capacity)
                {
                	if(capacity==1)
                	{
                		hm.remove(head.key);
                		hm.put(key, newNode);
                		head=newNode;
                		tail=newNode;
                		
                	}
                	else
                	{
                		hm.remove(head.key);
                		head.next.prev=null;
                		head=head.next;
                		head.prev=null;
                		tail.next=newNode;
                		newNode.prev=tail;
                		tail=tail.next;
                		hm.put(key, newNode);
                	}
                	 
                
                }
             
                else
                {
                	System.out.println("PROBLEMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
                }
	                

	        }
	        
	    }

}



