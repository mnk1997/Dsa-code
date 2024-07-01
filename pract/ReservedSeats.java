package in.cdac.pract;

import java.util.ArrayList;

public class ReservedSeats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] reservedSeats= {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
		System.out.println(maxNumberOfFamilies(3, reservedSeats));

	}
	   public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
	        int count=0;
	        int[][] rowArrangement=new int[n][10];
	        ArrayList<Integer> arr=new ArrayList<>();
	        arr.set
	        for(int i=0;i<reservedSeats.length;i++)
	        {
	        	System.out.println("row"+(reservedSeats[i][0]-1)+"  col"+(reservedSeats[i][1]-1));
	        	rowArrangement[reservedSeats[i][0]-1][reservedSeats[i][1]-1]=1;
	        }
	        int col=1;
        	int seatVacant=0;
	        for(int row=0;row<n;row++)
	        {
	        	seatVacant=0;
	        	col=1;
	        	if(col==1) {
	        	seatVacant=0;
	        	while(col<col+4 && col+4<10)
	        	{
	        		if(rowArrangement[row][col]==1)
	        		     seatVacant=1;
	        		col++;
	        		
	        	}
	        	if(seatVacant==0)
	        	{
	        		System.out.println(row+",1] ->["+row+",4]");
	        		count+=1;
	        		//rowArrangement[row][col-1]=1;
	        	}
	        }
	        	if(seatVacant==1) {
	        		col=3;
	        	seatVacant=0;
	        	while(col<col+4 && col+4<10)
	        	{
	        		if(rowArrangement[row][col]==1)
       		              seatVacant=1;
	        		col++;
	        		
	        	}
	        	if(seatVacant==0)
	        	{
	        		System.out.println(row+",3] ->["+row+",6]");
	        		count+=1;
	        		//rowArrangement[row][col-1]=1;
	        		
	        	}
	        } 
	        	if(seatVacant==1)
	        	{
	        		col=5;
	        	
	        	seatVacant=0;
	        	while(col<col+4 && col+4<10)
	        	{
	        		if(rowArrangement[row][col]==1)
       		              seatVacant=1;
	        		col++;
	        		
	        	}
	        	if(seatVacant==0)
	        	{
	        		System.out.println(row+",5] ->["+row+",8]");
	        		count+=1;
	        		//rowArrangement[row][col-1]=1;
	        	}
	        	}
	        }
	        
	        
	        
	        
	        
	        return count;
	    }

}
