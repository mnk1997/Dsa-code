package in.cdac.executables.callables;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<ArrayList<Integer>>{
	public int n;
	public ArrayList<Integer> list;
	public ArrayCreator(int i)
	{
		this.n=i;
		list=new ArrayList<>(n);
	}

	@Override
	public ArrayList<Integer> call() throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++)
		{
			//System.out.println("#######################################"+i);
			list.add(i+1);
		}
		return list;
	}

}
