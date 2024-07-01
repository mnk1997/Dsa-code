package in.cdac.pract;

public class NumsArray {
int array[];
public NumsArray(int[] nums) {
	//array = new int[nums];
	//array= new int[]{1,2,3,4};
	//method 1
	/*
	 * int i = 0; array = new int[nums.length]; for(int num: nums) { array[i]= num;
	 * i++; }
	 */
	//method 2 :just to optimize memoruy
	array=nums;
	System.out.println("array size "+array.length);
}	

}
