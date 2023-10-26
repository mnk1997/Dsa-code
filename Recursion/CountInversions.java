package in.cdac.pract;

public class CountInversions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 2, 4, 1, 3, 5 };
		System.out.println("Answer"+getInvCount(arr, 5));
	}

    public static int getInvCount(int[] arr,int n) {
        //int n=A.length;
     	int count = 0;
		count = mergeSort(arr, 0, n - 1, count);
		return count;
 }
 
 public static int mergeSort(int[] arr, int start, int end, int count) {
		
		if (start < end) {

			int mid = (end + start) / 2;
			 count=mergeSort(arr,start,mid,count);
			count = mergeSort(arr, mid + 1, end, count);
			int leftPtr = start;
			int rightPtr = mid + 1;
         int[] tempArray=new int[end-start+1];
         int tempCounter=0;
			while (leftPtr <= mid && rightPtr <= end) {
				
				if (arr[leftPtr] > arr[rightPtr]) {
					//System.out.println("Increse the count for in left"+arr[leftPtr]+"   in right"+arr[rightPtr]);
					count += mid - leftPtr + 1;
					tempArray[tempCounter++]=arr[rightPtr];
					rightPtr++;
				} else {
                 tempArray[tempCounter++]=arr[leftPtr];
					leftPtr++;
				}
			}
         while(leftPtr<=mid)
         {
             tempArray[tempCounter++]=arr[leftPtr];
					leftPtr++;
         }
          while(rightPtr<=end)
         {
             tempArray[tempCounter++]=arr[rightPtr];
					rightPtr++;
         }
         int k=0;
         for(int i=start;i<=end;i++)
         {
             arr[i]=tempArray[k++];
         }
			return count;
		}
		return count;

	}
}
