package LeetCode.DP;/*
 @author Myvin Barboza
 28/07/20 11:57 PM
 help
 */

public class LC5LongestPalindromicSubstring {
    public static void main(String[] args) {

    }

    //time -o(n2) and space -o(n2)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public String longestPalindromeDp(String s) {
    int n=s.length();
    if(n==0 ) return "";
    int start=0;
    int max=1;
    int dp[][]=new int[n][n];
    for(int i=0;i<n;i++)dp[i][i]=1;
    for(int k=2;k<=n;k++){
        for(int i=0;i<=n-k;i++){
            int j=i+k-1;
            if(s.charAt(i)==s.charAt(j) && k==2){
                dp[i][j]=1;
                if(k>max){
                    max=k;
                    start=i;
                }
            }
            else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                dp[i][j]=1;
                if(k>max){
                    max=k;
                    start=i;
                }
            }
        }
    }
    return s.substring(start,start+max);
}




    //time -o(n2) and space -o(1)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String longestPalindrome(String s) {
        if(s==null|| s.length()<1 ) return "";
        //o(n2) time and 0(1) space
        int start=0;
        int end=0;
        int n=s.length()-1;
        int len=0;
        for(int i=0;i<n;i++){
            //odd palindrome
            int len1=helper(s,i,i);
            //even palindrome
            int len2=helper(s,i,i+1);
            len=Math.max(len1,len2);

            if(len>end-start){
                //cbbd
                //for h
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    int helper(String s,int left,int right){
        if(s==null) return 0;

        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;
    }


}
