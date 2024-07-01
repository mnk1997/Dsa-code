package in.cdac.executables.callables;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * ExecutorService es=Executors.newCachedThreadPool(); Node root=new Node(2);
	 * Node leftFirst=new Node(3); Node rightFirst=new Node(4); Node rightSecond=new
	 * Node(5); Node leftSecond=new Node(6); root.left=leftFirst;
	 * root.right=rightFirst; leftFirst.right=rightSecond;
	 * rightFirst.left=leftSecond;
	 * 
	 * Future<Integer> res=es.submit(new TreeSizeCalculator(root, es));
	 * 
	 * while(!res.isDone()) { System.out.println(" waititng for getting response ");
	 * } try { System.out.println("Size "+res.get()); } catch (InterruptedException
	 * | ExecutionException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		ExecutorService es=Executors.newCachedThreadPool();
		Future<ArrayList<Integer>> res=es.submit(new ArrayCreator(1000));
		while(!res.isDone())
		{
			System.out.println("wating ");
		}
	 synchronized	ArrayList<Integer> list=new ArrayList<>();
		try {
			list = res.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int ele:list)
		{
			System.out.println(ele);
		}
		es.shutdown();
		
		

	}

}
