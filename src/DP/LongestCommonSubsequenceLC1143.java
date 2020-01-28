import java.util.Arrays;

public class LongestCommonSubsequenceLC1143 {
		//recursion way dynaimc programming uses the same logic
	  static int longestCommonSubsequence(String text1, String text2) {
		  int n1=text1.length();
		  int n2=text2.length();
		  if(text1.length()==0||text2.length()==0)return 0;
		  else if(text1.charAt(n1-1)==text2.charAt(n2-1))return 1+longestCommonSubsequence(text1.substring(0,n1-1), text2.substring(0,n2-1));
		  else return Math.max(longestCommonSubsequence(text1.substring(0,n1-1), text2.substring(0,n2)),longestCommonSubsequence(text1.substring(0,n1), text2.substring(0,n2-1)));
	  }
	  static int dpLongestCommonSubsequence(String text1, String text2) {
		  int n1=text1.length();
		  int n2=text2.length();
		  int A[][]=new int[n1+1][n2+1];
		  for(int i=0;i<=n1;i++){
			  for(int j=0;j<=n2;j++){
				if(i==0||j==0)
					A[i][j]=0;
				else if(text1.charAt(i-1)==text2.charAt(j-1)){
					A[i][j]=A[i-1][j-1]+1;
				}
				else{
					A[i][j]=Math.max(A[i-1][j], A[i][j-1]);
				}
			  }
		  }
       
		  System.out.println(Arrays.toString(A)+"d");                                                                                                                                                                                                                                                                                                                                              
		  
		  return A[n1][n2];
		  
	  }
	  
	public static void main(String[] args) {
	System.out.println(longestCommonSubsequence("acbdaf", "acbcf"));
		
	}
}
