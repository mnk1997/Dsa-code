package incub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class Calculator {

	@Test
	public void CalculatorAddTest()
	{
		try
		{
			
		
	    assertEquals(0,addNumber(""));
	    String testCaseTwo="1,1";
	    assertEquals(2,addNumber(testCaseTwo));
	    String testCaseThree="1,2,3,4";
	    assertEquals(10,addNumber(testCaseThree));
	    String testCaseFour="//5;6\n7,\\";  
	    
			assertEquals(18,addNumber(testCaseFour));
		
	    String testCaseFive="-1;1,2,3,-4";
	   assertThrows("Negative number found",Exception.class,() ->
	    {
	    	
	    addNumber(testCaseFive);
	    });
		}catch(Exception ex)
		{
			String[] freqOfNegativeNumber=ex.getMessage().split(";");
			int count=0;
			if(!freqOfNegativeNumber[0].isEmpty())
				count=Integer.parseInt(freqOfNegativeNumber[0]);
			
			for(int c=1;c<=count;c++)
			{
				System.out.println("Negative number Not allowed");
			}
		}
	    
	}
	
	public int addNumber(String input) throws Exception
	{
		if(input.isEmpty())
		     return 0;
		
		//String[] val=input.split(",");
		//\\ represent \ in string regex as it is an escape character . Thus I have supported delimeter like \ \\ \n ; , / //
		String[] val=input.split("[;\\n,//\\\\]+");
	
		/*
		 * int firstNumber=Integer.parseInt(val[0]); int
		 * secondNumber=Integer.parseInt(val[1]);
		 */
		int count=0;
		int sum=0;
		for(String s:val)
		{
			if(!s.isEmpty())
			{
				int num=Integer.parseInt(s);
				if(num<0)
				{
					count++;
				}
				else
				{
					sum+=num;
				}
				
			}
			    
		}
		if(count>0)
		{
			throw new Exception("Negative number found;"+count);
		}
		return sum;
	}
	

}
