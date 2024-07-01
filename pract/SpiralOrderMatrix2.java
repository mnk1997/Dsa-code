package in.cdac.pract;

public class SpiralOrderMatrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A=10;
         int[][] res=generateMatrix(A);
         for(int i=0;i<A;i++)
         {
        	 for(int j=0;j<A;j++)
        	 {
        		 System.out.print(res[i][j]+" ");
        	 }
        	 System.out.println();
         }
	}
	  public static int[][] generateMatrix(int A) {
	        if(A==1)
	        {
	            int[][] res=new int[1][1];
	            res[0][0]=1;
	            return res;
	        }
	        int row=0;
	        int col=0;
	        int N=A;
	        int val=1;
	        int startRow=-1;
	        int startCol=-1;
	        int[][] res=new int[A][A];
	        while(N>=1)
	        {
	            startRow=row;
	            startCol=col;
	            for(int k=1;k<=N-1;k++)
	            {
	                res[startRow][startCol]=val++;
	                startCol++;
	            }
	             for(int k=1;k<=N-1;k++)
	            {
	                res[startRow][startCol]=val++;
	                startRow++;
	            }
	               for(int k=1;k<=N-1;k++)
	            {
	                res[startRow][startCol]=val++;
	                startCol--;
	            }
	             for(int k=1;k<=N-1;k++)
	            {
	                res[startRow][startCol]=val++;
	                startRow--;
	            }
	            row++;
	            col++;
	            N-=2;
	        }
                 System.out.println("row "+row+"  col"+col +"  val"+val + " value at row col"+res[row][col]);
            	  if(A%2==1)
                     res[row-1][col-1]=val;
            
	        
	        return res;
	    }
}
