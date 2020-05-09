package LeetCode.Array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumLC1 {
	 static int[] twoSum(int[] a, int target) {
		 	int [] copy=Arrays.copyOf(a, a.length);
		 	//need sorting of copy
		 	Arrays.sort(copy);
		  	int r[]=new int[2];
	        int left=0,n=a.length,right=n-1;
	        //using a two pointer approach where in if sum > target we decremnt the right so having a smaller value and if sum<target we increment left giving us a bigger value 
	        while(left<right){
	        if(copy[left]+copy[right]==target)break;
	        else if(copy[left]+copy[right]>target)right--;
	        else if(copy[left]+copy[right]<target)left++;
	        }
	        //done to get the index of the first element 
	        for(int i=0;i<n;i++)
	        if(a[i]==copy[left])r[0]=i;
	        //done to get the index of the second element
	        for(int i=a.length-1;i>=0;i--)
		    if(a[i]==copy[right])r[1]=i;
	        
	        return r;
	}
	 
	 static int[] MaptwoSum(int[] a, int target) {
		 //we take the target-value and check for it in the map if not there we put the element along with its index and when we do find it we rreturn it
		    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
				for (int i = 0; i < a.length; i++) {
					if(map.containsKey(target-a[i])){
						return new int[]{map.get(target-a[i]),i};
					}
					else map.put(a[i], i);
					
				}
				throw new IllegalArgumentException("nto found");


		}
	 
	 
	 
	 public static void main(String[] args) {
		 int[] p={3,2,4};
		long start = System.nanoTime(); 
		System.out.println(Arrays.toString(twoSum(p, 6)));
	    long end = System.nanoTime(); 
	    System.out.println("Two pointer apporoach " +(end - start) + " nano time"); 
	    
	    start = System.nanoTime(); 
		System.out.println(Arrays.toString(MaptwoSum(p, 6)));
		end = System.nanoTime(); 
	    System.out.println("HashMap apporoach " +(end - start) + " nano time"); 
	}
}
