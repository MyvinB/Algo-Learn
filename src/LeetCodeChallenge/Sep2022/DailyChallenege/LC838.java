package LeetCodeChallenge.Sep2022.DailyChallenege;

import java.util.Arrays;

public class LC838 {

    public static void main(String[] args) {
        String t = ".L.R...LR..L..";
        String p = "RR.L";
        System.out.println(pushDominoes(p));
    }

    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int lpos = -1;int rpos = -1;
        //left forces
        for(int i =n-1;i>=0;i--){
            if(dominoes.charAt(i)=='R') lpos = -1;
            else if(dominoes.charAt(i)=='L') lpos = i;
            left[i] = lpos;
        }

        //right forces
        for(int i=0;i<n;i++){
            if(dominoes.charAt(i)=='L') rpos = -1;
            else if(dominoes.charAt(i)=='R') rpos = i;
            right[i] = rpos;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            //if both forces are -1 then append .
            if(left[i]== -1 && right[i]==-1){
                sb.append(".");
            }
            else if(left[i]==-1) sb.append("R");
            else if(right[i]==-1) sb.append("L");
            else {
                int dL = left[i]-i;
                int dR = i-right[i];
                if(dL==dR) sb.append(".");
                else if(dL<dR) sb.append("L");
                else sb.append("R");
            }
        }
        return sb.toString();
    }
}
