package LeetCode.Array;

import java.util.Arrays;

public class LC948BagofTokens {
    public static void main(String[] args) {
        int a[]= {100,200,300,400};
        System.out.println(bagOfTokensScore(a,200));
    }

    static int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int i=0,j=tokens.length-1;
        int points=0;
        int res=0;
        while(i<=j){
            if(P>=tokens[i]){
                points++;
                P-=tokens[i++];
                res=Math.max(points,res);
            }else if(points>0){
                points--;
                P+=tokens[j--];
            }
            else
                break;
        }
        return res;
    }

}
