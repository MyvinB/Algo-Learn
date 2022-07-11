package Contest.Upsolve;

import java.util.PriorityQueue;

public class LC2336 {

    public static void main(String[] args) {

    }

    class SmallestInfiniteSet {
        private PriorityQueue<Integer> pq = new PriorityQueue<>();
        public SmallestInfiniteSet() {
            for(int i=1;i<=1000;i++){
                pq.add(i);
            }
        }

        public int popSmallest() {
            return pq.poll();
        }

        public void addBack(int num) {
              if(!pq.contains(num)) pq.offer(num);
        }
    }
}
