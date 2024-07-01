package in.cdac.executables.callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClientOne {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		ExecutorService es=Executors.newFixedThreadPool(10);
		List<Future<Integer>> list=new ArrayList<>();
		for(int i=0;i<10;i++)
		{
			Future<Integer>res= es.submit(new CalculateSumCallabale(10*i+1, 10*(i+1)));
			list.add(res);
		}
		int sum=0;
		for(Future<Integer> f:list)
		{
			int gotSum=f.get();
			System.out.println("got Sum "+gotSum);
			sum+=gotSum;
		}
		System.out.println("sum "+sum);
		es.shutdown();

	}

}
