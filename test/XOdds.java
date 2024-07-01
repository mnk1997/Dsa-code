package in.cdac.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class XOdds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(XoodsDecrement("in 57947.33  55 i have something for your"));
	}
	
	public static String XoodsDecrement(String input)
	{
		//String[] arr={"mayankkkk"};
		
		String regex="[0-9]+[3759]";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(input);
		
	
		 
		 String replacedString = matcher.replaceAll(match -> {
	            int number = Integer.parseInt(match.group());
	            number -= 1;
	            return String.valueOf(number);
	        });
		return replacedString;
		
		
	}

}
