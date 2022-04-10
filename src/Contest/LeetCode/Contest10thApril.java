package Contest.LeetCode;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 8:26 AM 4/10/2022
 * Time Taken:
 */
public class Contest10thApril {

    public static void main(String[] args) {
//        System.out.println(largestInteger(247));
        System.out.println(maximumProduct(new int[]{0,4},5));
    }
    //LC 2231
    public static int largestInteger(int num) {
        char A[] = String.valueOf(num).toCharArray();
        List<Character> even = new ArrayList<>();
        List<Character> odd = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            int cur = Integer.parseInt(String.valueOf(A[i]));
            if(cur%2==0){
                even.add(A[i]);
                A[i] = 'e';
            }else{
                odd.add(A[i]);
                A[i] = 'o';
            }

        }
        Collections.sort(even,(a,b)->{
            return b-a;
        });
        Collections.sort(odd,(a,b)->{
            return b-a;
        });
        int e = 0;
        int o = 0;
        for(int i=0;i<A.length;i++){
            if(A[i]=='e'){
                A[i] = even.get(e++);
            }else A[i] = odd.get(o++);
        }
        return Integer.parseInt(String.valueOf(A));
    }


    //LC 2233
    public static int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
        }
        while(k-->0){
            int val = pq.poll();
            pq.offer(val+1);
        }
        System.out.println(pq);
        long maxProduct = 1;
        while(!pq.isEmpty()){
            maxProduct = (maxProduct * pq.poll())% 1000000007;

        }
        return (int)maxProduct;
    }
}
