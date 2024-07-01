package in.cdac.executables.callables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TreeSizeCalculator implements Callable<Integer> {
	Lock lock=new ReentrantLock();
	Node head;
	ExecutorService es;
	public TreeSizeCalculator(Node head,ExecutorService es)
	{
		this.head=head;
		this.es=es;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("THread name "+Thread.currentThread().getName());
		if(head==null)
			return 0;
		
		
		Future<Integer> leftSize=es.submit(new TreeSizeCalculator(head.left, es));
		Future<Integer> rightSize=es.submit(new TreeSizeCalculator(head.right, es));
		return 1+leftSize.get()+rightSize.get();
		
	}

	

}
