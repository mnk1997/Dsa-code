package in.cdac.test;

public class ExceptionTest {
  public static void main(String[] args)
  {
	  System.out.println(callCheck());
  }
  @SuppressWarnings("finally")
public static int callCheck()
  {
	  try
	  {
		  return 10;
		  
	  }catch(Exception e)
	  {
		  return 1;
	  }finally
	  {
		  System.out.println("finally ");
		  return 2;
		 
	  }
  }
}
