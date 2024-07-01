package in.cdac.executables.callables;

public class Output {
	int i;
	String threadName;
	public Output(int i,String name)
	{
		this.i=i;
		this.threadName=name;
	}
	@Override
	public String toString() {
		return "Output [i=" + i + ", threadName=" + threadName + "]";
	}

}
