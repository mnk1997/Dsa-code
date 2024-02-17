package incub;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Calculator {

	@Test
	public void CalculatorAddTest()
	{
	    assertEquals(0,addNumber(""));
	    String testCaseTwo="1,1";
	    assertEquals(2,addNumber(testCaseTwo));
	    String testCaseThree="1,2,3,4";
	    assertEquals(10,addNumber(testCaseThree));
	   
	}
	
	public int addNumber(String input)
	{
		if(input.isEmpty())
		     return 0;
		String[] val=input.split(",");
		/*
		 * int firstNumber=Integer.parseInt(val[0]); int
		 * secondNumber=Integer.parseInt(val[1]);
		 */
		int sum=0;
		for(String s:val)
		{
			sum+=Integer.parseInt(s);
		}
		return sum;
	}
	

}
