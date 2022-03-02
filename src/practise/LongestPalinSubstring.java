package practise;

/*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"*/
public class LongestPalinSubstring {
    static String longestPalSubstr(String str) {
        String longPal="";
        int start=0;
        //all substrings of single letter max length is 1
        int maxLength=1;
        int max=Integer.MIN_VALUE;
        int n=str.length();
        boolean table[][]=new boolean[n][n];
        //for filling the single elements
        for (int i = 0; i <n ; i++) {
            table[i][i]=true;

        }

        //for two character
        for (int i = 0; i <n-1 ; i++) {
            if(str.charAt(i)==str.charAt(i+1)){
                table[i][i+1]=true;
                start=i;
                maxLength=2;
                longPal=str.substring(start,start+maxLength);
            }
        }
        //for two or more character
        for (int k = 3; k <=n ; k++) {

            for (int i = 0; i <n-k+1 ; i++) {
                int j=i+k-1;
                if(table[i+1][j-1]&&str.charAt(i)==str.charAt(j)){
                    table[i][j]=true;
                    if(k>max){
                        start=i;
                        maxLength=k;
                        longPal=str.substring(start,start+maxLength);
                    }
                }
            }

        }

        return longPal;
    }

        public static void main(String[] args) {
            System.out.println(longestPalSubstr(""));

    }
}
