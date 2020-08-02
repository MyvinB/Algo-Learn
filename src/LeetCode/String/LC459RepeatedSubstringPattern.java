package LeetCode.String;/*
 @author Myvin Barboza
 31/07/20 5:25 PM 
 */

public class LC459RepeatedSubstringPattern {

    //using a kmp algo n time awesome can implement in other videos
    public boolean repeatedSubstringPatternKMP(String s) {
        //help:https://www.youtube.com/watch?time_continue=466&v=GTJr8OvyEVQ&feature=emb_logo
        int i=0,j=1;
        int n=s.length();
        int dp[]=new int[n+1];
        while(j<n){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j++;
                dp[j]=i;
            }
            else if(i==0){
                j++;
            }
            else {
                i = dp[i];
            }

        }
        return dp[n]!=0 && dp[n]%(s.length()-dp[n])==0;
        // 0 1 2 3 4 5 6 7 8 9 10 11
        // a b c a b c a b c a b c
        //         1 2 3 4 5 6 8 9
        // a b  a b a c
        //        1 2 3
        //"a b a a b a b a a b"
        //       1 1 2 3 2 3 4 5
    }




    static boolean repeatedSubstringPattern(String s) {





/*
NOt so fast 106ms
   String str=s+s;
        return str.substring(1,str.length()-1).contains(s);
* */
        int len=s.length();
        for(int i=len/2;i>=1;i--){
            if(len%i==0){
                int num_repeats=len/i;
                String t=s.substring(0,i);
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<num_repeats;j++){
                    sb.append(t);
                }
                if(sb.toString().equals(s))return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
    }


}
