package in.cdac.pract;

public class MagicDoors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println(solve(10));
	}
	 public static int solve(int A) {
	        int[] stateOfDoor=new int[A+1];
	        //let 0 be the state denoting open door and 1 close
	        
	        for(int i=2;i<=A/2;i++)
	        {
	             for(int j=i;j<=A;j+=i)
	             {
	                 stateOfDoor[j]+=1;
	             }
	        }

	        int countOfOpenDoor=0;
	        for(int i=1;i<=A;i++)
	        {
	            if(stateOfDoor[i]%2==1)
	                countOfOpenDoor++;
	        }

     for(int ele:stateOfDoor)
     {
    	 System.out.print(" "+ele);
     }
	        return countOfOpenDoor;
	    }
}
