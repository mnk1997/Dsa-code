package in.cdac.polymorphism;

public class A {
	int x;
	int y;
	protected A(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public void display()
	{
		 System.out.println("[<<"+x+">>,<<"+y+">>]");
	}

}
