package in.cdac.executables.Runnable;

public class PrinterClass implements Runnable{
	int i;
	public PrinterClass(int i)
	{
		this.i=i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("val: "+this.i+" Thread "+Thread.currentThread().getName());
		
	}

}
