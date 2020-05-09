package LeetCode.DP;

/*DP implementation of longest Palindromic subtring*/
public class DPLongestPalindrome {

	static String longestPalindrome(String str){
		int n=str.length();
		Boolean A[][]=new Boolean[n][n];
		int start=0;
		int max=Integer.MIN_VALUE;		
		//to make all the single characters palindrome
	
		for(int i=0;i<n;i++){
			A[i][i]=true;
		}
		//for more than two 
		for(int k=2;k<=n;k++){
			for(int i=0;i<=n-k;i++){
				int j=i+k-1;
				//for two characters
				
				if(str.charAt(i)==str.charAt(j)&&k==2){
					A[i][j]=true;
					if(k>max){
						start=i;
						max=k;
					}
				}
				else if(str.charAt(i)==str.charAt(j)&&A[i+1][j-1]){
				
					
					A[i][j]=true;
					if(k>max){
						start=i;
						max=k;
					}
				
				}
				else{
					A[i][j]=false;
				}
			}
		}
	return str.substring(start,start+max);
	}
	
	
	public static void main(String[] args) {
	String str="abaabc";
	System.out.println(longestPalindrome(str));
	

	}
}
