package in.cdac.pract.backtracking;

/*Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.*/
public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     // char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
      char[][] board={{'a','b'},{'c','d'}};
       //["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]
    		   // char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    		   String word="abcd";
     // String word="ABCB";
       System.out.println(exist(board,word));
	}
	 public static boolean exist(char[][] board, String word) {
	        boolean result=false;
	        int maxRow=board.length;
	        int maxColumn=0;
	        for(int i=0;i<maxRow;i++)
	        {
	        	for(int j=0;j<board[i].length;j++)
	        	{
	        		maxColumn=board[i].length;
	        		result=checkWordExistOrNotFromThisIndex
	        				(board,word,i,j,result,maxRow,maxColumn);
	        		if(result)
	        		{
	        			break;
	        		}
	        	}
	        }
		 
		 
		 return result;
	    }
	 public static boolean checkWordExistOrNotFromThisIndex(char[][]board,String word,int currRow,int currCol,boolean result,int maxRow,int maxColumn)
	 {
		// System.out.println("called for "+board[currRow][currCol]);
		 if(word.length()==0) {
			 result=true;
			 return result;
		 }
		 if(result)
		 {
			 return true;
		 }
		 if(currCol==maxColumn)
		 {
			// System.out.println("modifiying row nad col for"+currRow+" ,"+currCol);
			return result;
		 }
		 if(currCol<0 || currRow <0)
		 {
			 return result;
		 }
		
		 if(currRow<maxRow&& currCol<maxColumn &&board[currRow][currCol]==word.charAt(0))
		 {
			// System.out.println("yes char found"+word.charAt(0));
			 char c=board[currRow][currCol];
			 board[currRow][currCol]='!';
			result=checkWordExistOrNotFromThisIndex(board,word.substring(1),currRow,currCol+1,result,maxRow,maxColumn);
			result=checkWordExistOrNotFromThisIndex(board,word.substring(1),currRow,currCol-1,result,maxRow,maxColumn);
			result=checkWordExistOrNotFromThisIndex(board,word.substring(1),currRow+1,currCol,result,maxRow,maxColumn); 
			result=checkWordExistOrNotFromThisIndex(board,word.substring(1),currRow-1,currCol,result,maxRow,maxColumn); 
			board[currRow][currCol]=c;
			
		 }
		 return result;
	 }

}
