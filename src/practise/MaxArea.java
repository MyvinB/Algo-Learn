package practise;

class MaxArea {
    static int maxArea(int[] height) {
        
    int n=height.length;
	

	int max=Integer.MIN_VALUE;
    for(int j=n;j>0;j--){
        for(int i=0;i<n;i++){
		
		int l=j-(i+1);
		int b=Math.min(height[i], height[j-1]);
		int temp=l*b;
		
		
		if(temp>max)max=temp;
		temp=1;
	}
    }    
        
	
        return max;
    }
    
    public static void main(String args[]){
    	/*Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.Note: You may not slant the container and n is at least 2.
Input: [1,8,6,2,5,4,8,3,7]
Output: 49 */
    	int[] a={1,8,6,2,5,4,8,3,7};
    	System.out.println(maxArea(a));
    	
    }
}
