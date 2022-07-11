package Contest.Upsolve;

import java.util.PriorityQueue;

public class LC2335 {

    public static void main(String[] args) {

    }

    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int p:amount)pq.offer(p);
        int ans = 0;
        while(!pq.isEmpty()){
            int f = pq.poll();
            int s = pq.poll();
            if(f<=0 && s<=0){
                break;
            }
            pq.offer(--f);
            pq.offer(--s);
            ans++;
        }
        return ans;
    }
}
