package LeetCodeChallenge.December;/*
 @author Myvin Barboza
 17/12/20 6:11 PM 
 */

import java.util.HashMap;

public class LC4544SumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n=A.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = A[i]+B[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = C[i]+D[j];
                count+= map.getOrDefault(-sum,0);
            }
        }
        return count;

    }
}
