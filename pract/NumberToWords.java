package in.cdac.pract;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberToWords {
	
      List<String> LengthName=Arrays.asList("Unit","Tens","Hundred","Thousand","TenThousand","Lakhs","TenLakhs");
      Map<String,String> valuesWhenDigitIsInTens=new HashMap<>();
      List<String> digitsName;
      
      public NumberToWords()
      {
    	  valuesWhenDigitIsInTens.put("11","Eleven");
          valuesWhenDigitIsInTens.put("12","Tweleve");
          valuesWhenDigitIsInTens.put("14","Forteen");
          valuesWhenDigitIsInTens.put("15","Fifteen");
          valuesWhenDigitIsInTens.put("16","Sixteen");
          valuesWhenDigitIsInTens.put("2","Twenty");
          valuesWhenDigitIsInTens.put("3","Thirty");
          valuesWhenDigitIsInTens.put("4","Forty");
          valuesWhenDigitIsInTens.put("5","Fifty");
          valuesWhenDigitIsInTens.put("6","Sixty");
          valuesWhenDigitIsInTens.put("7","Seventy");
          valuesWhenDigitIsInTens.put("8","Eighty");
          valuesWhenDigitIsInTens.put("9","Ninety");
          digitsName=Arrays.asList("One","Two","Three","Four","Five","Six","Seven","Eight","Nine");
      }
      
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberToWords obj=new NumberToWords();
		System.out.println(obj.numberToWord("324768"));

	}
        public  String numberToWord(String inputNumber)
        {
        	StringBuffer result=new StringBuffer();
        	int currentLengthOfString=inputNumber.length();
        	for(int i=0;i<inputNumber.length();i++)
        	{
        		System.out.println("Till now word is "+result);
        	       if(currentLengthOfString%2==1 && currentLengthOfString > 3)
        	       {
        	    	   char c=inputNumber.charAt(i);
        	    	   if(c=='1')
        	    	   {
        	    		        String getDigits=inputNumber.substring(i, i+2);
        	    		        result.append(valuesWhenDigitIsInTens.get(getDigits) +" "+ LengthName.get(currentLengthOfString-2)+ " ");
        	    		        currentLengthOfString-=2;
        	    		        i++;
        	    		        continue;
        	    		        
        	    		        
        	    	   }
        	    	   else
        	    	   {
        	    		   String getDigits=inputNumber.substring(i,i+1);
        	    		   result.append(valuesWhenDigitIsInTens.get(getDigits)+" ");
        	    		   currentLengthOfString-=1;
        	    		   continue;
        	    		   
        	    	   }
        	       }
        	       else if(currentLengthOfString==2)
        	       {
        	    	   char c=inputNumber.charAt(i);
        	    	   if(c=='1')
        	    	   {
        	    		        String getDigits=inputNumber.substring(i, i+2);
        	    		        result.append(valuesWhenDigitIsInTens.get(getDigits) +" ");
        	    		        currentLengthOfString-=2;
        	    		        i++;
        	    		        continue;
        	    		        
        	    		        
        	    	   }
        	    	   else
        	    	   {
        	    		   String getDigits=inputNumber.substring(i,i+1);
        	    		   result.append(valuesWhenDigitIsInTens.get(getDigits)+" ");
        	    		   currentLengthOfString-=1;
        	    		   continue;
        	    		   
        	    	   }
        	       }
        	       else if(currentLengthOfString==1)
        	       {
        	    	   String getDigits=inputNumber.substring(i,i+1);
    	    		   result.append(digitsName.get(Integer.parseInt(getDigits)-1)+" ");
    	    		   //result.append(LengthName.get(currentLengthOfString-1)+ " ");
    	    		   
    	    		   currentLengthOfString-=1;
        	       }
        	       else
        	       {
        	    	   String getDigits=inputNumber.substring(i,i+1);
    	    		   result.append(digitsName.get(Integer.parseInt(getDigits)-1)+" ");
    	    		   result.append(LengthName.get(currentLengthOfString-1)+ " ");
    	    		   
    	    		   currentLengthOfString-=1;
        	       }
        	       
        	}
        	
        	return result.toString();
        }
}
