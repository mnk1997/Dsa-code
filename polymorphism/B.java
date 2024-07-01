package in.cdac.polymorphism;

public class B extends A{
	private int z;
	
	public B(int x,int y,int z)
	{
	
		super(x,y);
		this.z=z;
	}
	
	@Override
	public void display()
	{
		System.out.println("[<<"+x+">>,<<"+y+">>,<<"+z+">>]");
	}
	public void whyNot()
	{
		System.out.println("Why not");
	}

}
