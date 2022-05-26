package LeetCodeChallenge.MAY2022;

import java.util.Arrays;

public class LC354 {

    public static void main(String[] args) {

    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]!=b[0]) return a[0] - b[0];
            return a[1]-b[1];
        });
        int[] tails = new int[n];
        int size = 0;
        for(int[] x:envelopes){
            int i=0,j=size;
            while(i!=j){
                int m = i+(j-i)/2;
                if(tails[m]<x[1]) i = m+1;
                else j = m;
            }
            tails[i] = x[1];
            if(i==size) size++;
        }
        return size;
    }
}
