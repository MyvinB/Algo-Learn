package LeetCodeChallenge.JAN2022.practise;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 10:39 AM 1/27/2022
 */
public class LC697 {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(num));
    }

    public static int findShortestSubArray(int[] A) {
        HashMap<Integer,Integer> count = new HashMap<>();
        HashMap<Integer,Integer> first = new HashMap<>();
        int degree =0;
        int res = 0;
        for(int i=0;i<A.length;i++){
            first.putIfAbsent(A[i],i);
            count.put(A[i],count.getOrDefault(A[i],0)+1);
            if(count.get(A[i])>degree){
                degree=count.get(A[i]);
                res= i-first.get(A[i])+1;
            }else if(count.get(A[i])==degree){
                res = Math.min(res, i-first.get(A[i])+1);
            }
        }
        return res;
    }
}
