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
	    String testCaseFour="//5;6\n7,\\";  
	    assertEquals(18,addNumber(testCaseFour));
	}
	
	public int addNumber(String input)
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
		int sum=0;
		for(String s:val)
		{
			if(!s.isEmpty())
			    sum+=Integer.parseInt(s);
		}
		return sum;
	}
	

}
