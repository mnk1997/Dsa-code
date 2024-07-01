package in.cdac.executables.callables;

import java.util.concurrent.Callable;

public class CallablePrinter implements Callable<Output> {

	
	int i;
	public CallablePrinter(int i)
	{
		this.i=i;
	}
	@Override
	public Output call() throws Exception {
	
		return new Output(i,Thread.currentThread().getName());
	}

}
