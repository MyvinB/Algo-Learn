package Array;/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.*/
import java.util.Arrays;

public class MoveZeroesLC238 {
public static void main(String[] args) {
	int a[]={0,1,0,3,12};
	int j=0;
	for(int i=0;i<a.length;i++){
		if(a[i]!=0){
			int temp=a[j];
			a[j]=a[i];
			a[i]=temp;
			j++;
		}

       
    }
    
	System.out.println(Arrays.toString(a));

}
}

