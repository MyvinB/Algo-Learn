package Array;

import java.util.Arrays;
///finding subarray problem the most efficient way is kadenge algo
public class MaximumSubarrayLC38 {
	
	///n2 complexity of finding subarray 
	static int[] subArray(int[] A){
		int sum=0;
		int max=0;
		int s=0,e=0;
		for (int i = 0; i < A.length; i++) {
			sum=A[i];
			if(sum>max){
				max=sum;
				s=i;e=i;
			}
			for (int j = i+1; j < A.length; j++) {
				
			sum=sum+A[j];	
			
			if(sum>max){
				s=i;
				e=j;
				max=sum;
			}
			}
			sum=0;
		}
//		System.out.println(max);
//		System.out.println(s+"start end"+e);
		return Arrays.copyOfRange(A, s, e+1);
	}
	
	//---------------------------------------------------------------------------------------------------------------------------
	///nlogn complexity using divide and conquer approach
	static int maxSubArray(int ar[],int l,int m,int h){
		int sum=0;
		int left_Sum=Integer.MIN_VALUE;
		int right_Sum=Integer.MIN_VALUE;
		for(int i=m;i>=l;i--){
			sum=sum+ar[i];
			if(sum>left_Sum)left_Sum=sum;
		}
		sum=0;
		for(int i=m+1;i<=h;i++){
			sum=sum+ar[i];
			if(sum>right_Sum)right_Sum=sum;
		}
		return left_Sum+right_Sum;
	}
	static int maxSubArray(int ar[],int l,int h){
		if(l==h){
			return ar[l];
		}
		int m=(l+h)/2;
		return Math.max(Math.max(maxSubArray(ar,l,m), maxSubArray(ar,m+1,h)),
				maxSubArray(ar,l,m,h));
	}
	//---------------------------------------------------------------------------------------------------------------------------
	//According to wiki it needs atleast one positive number Kadane Algorithm to find a contigiuos sum
	//If the array contains all non-positive numbers, 
	//then the solution is the number in the array with the smallest absolute value (or the empty subarray, if it is permitted).
	static int maxSubKadane(int ar[]){
		int max_so_far=0,max_so_end=0;
		for (int i = 0; i < ar.length; i++) {
			max_so_end=max_so_end+ar[i];
			if(max_so_far<max_so_end){
				max_so_far=max_so_end;
			}
			if(max_so_end<0){
				max_so_end=0;
			}
			
		}
		return max_so_far;
		
	}
	public static void main(String[] args) {
	int A[]={-1,-1,-1};
	int p[]={-2,4};
	System.out.println(Arrays.toString(subArray(A)));
	System.out.println(maxSubArray(A, 0, A.length-1)+"anss");
	System.out.println(maxSubKadane(A));
	}
}
