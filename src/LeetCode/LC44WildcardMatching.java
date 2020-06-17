package LeetCode;/*
 @author Myvin Barboza
 17/06/20 4:13 PM
 help:tushar roy
 */

import java.util.Arrays;

public class LC44WildcardMatching {

    static boolean isMatch(String s, String p) {
       //code for doing a**b**c to a*b*c

        //ho **ho we make the first asterics true but what about the rest thats why this is code is there makes it a bit
        //faster also

        StringBuilder sb=new StringBuilder();
        boolean isFirst=true;
        for(int i=0;i<p.length();i++){
        if(p.charAt(i)=='*'){
            if(isFirst) {
                sb.append('*');
                isFirst=false;
            }

        }
        else {
            sb.append(p.charAt(i));
            isFirst=true;
        }
        }
        //updating the value of p
        p=sb.toString();
        //inital conditions
        boolean dp[][]=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;

        //if first chracter is asterics then we need to make the choice wit asterics true in comparison with no string
        if ( p.length()!=0 && p.charAt(0) == '*') {
            dp[0][1] = true;
        }


        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 1; j <=p.length() ; j++) {
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    //if both are equal we remove both of them and look at the soln without them
                    //in case of question mark its the same as the given char so it's there
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    //taking into accoutn wiht or without an asterics
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
                else dp[i][j]=false;
            }
        }
        return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {

        System.out.println(isMatch("ho","**ho"));


    }
}
