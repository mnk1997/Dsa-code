package in.cdac.executables;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import in.cdac.executables.Runnable.PrinterClass;
import in.cdac.executables.callables.CallablePrinter;
import in.cdac.executables.callables.Output;

public class Client {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		
		ExecutorService es=Executors.newCachedThreadPool();
		for(int i=1;i<1001;i++)
		{
			es.submit(new PrinterClass(i));
		}
	  es.shutdown();
		ExecutorService esCallable=Executors.newCachedThreadPool();
		for(int i=1;i<=1000;i++)
		{
			Future<Output> res=esCallable.submit(new CallablePrinter(i));
			System.out.println (res.get());
		}
		
		
	  

	}

}
