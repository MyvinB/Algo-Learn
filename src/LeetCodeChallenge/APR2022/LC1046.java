package LeetCodeChallenge.APR2022;

import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 5:41 AM 4/7/2022
 * Time Taken:
 */
public class LC1046 {

    public static void main(String[] args) {

    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int stone:stones){
            pq.add(stone);
        }

        while(pq.size()>1){
            int big = pq.poll();
            int small = pq.poll();
            if(big != small) pq.add(big-small);
        }
        return pq.peek()!=null?pq.poll():-1;


    }
}
