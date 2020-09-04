package practise;

public class LC459 {
    public static void main(String[] args) {
        String s="abac";
        System.out.println(repeatedSubstringPattern(s));
    }

    static  boolean repeatedSubstringPattern(String s) {
     /*
     Debug on paper to understand simple
       // 0 1 2 3 4 5 6 7 8 9 10 11
        // a b c a b c a b c a b c
        //         1 2 3 4 5 6 8 9
        // a b  a b a c
        //        1 2 3
        //"a b a a b a b a a b"
        //       1 1 2 3 2 3 4 5
     * */
     int i=0,j=1;
     int n=s.length();
     int dp[]=new int[n+1];

     while(j<n){
         if(s.charAt(i)==s.charAt(j)){
         i++;j++;
         dp[j]=i;
         }
         else if(i==0){
             j++;
         }
         else {
             //take the prefix which has been same before
             i=dp[i];
         }
     }
     //we reach the end so we get the repeated string and since we leave out one last we get the actual length of the repeated string if we mod it and get zero that means perfectly repeated
     return dp[n]!=0 && dp[n]%(n-dp[n])==0;


    }
}
