package LeetCodeChallenge.Sep2022.DailyChallenege;

import java.util.Arrays;

public class LC984 {

    public static void main(String[] args) {

    }

    public int bagOfTokensScore(int[] A, int P) {
        Arrays.sort(A);
        int i=0,j=A.length-1,score = 0,res = 0;
        while(i<=j){
            if(P>=A[i]){
                P -=A[i++];
                res = Math.max(res,++score);
            }else if(score>0){
                P+=A[j++];
                score--;
            }
            else break;
        }
        return res;
    }
}
