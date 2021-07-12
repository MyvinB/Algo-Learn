package LeetCodeChallenge.JULY2021;

import java.util.PriorityQueue;

public class LC295 {
    public static void main(String[] args) {

    }

    class MedianFinder {
        private PriorityQueue<Integer> maxHeap, minHeap = null;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a, b) -> (b - a));
            minHeap = new PriorityQueue<>((a,b)->(a-b));
        }

        public void addNum(int num) {
            if (maxHeap.size() == 0 || maxHeap.peek() >= num) {
                maxHeap.offer(num);
            } else minHeap.offer(num);

            balance();
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else if (maxHeap.size() < minHeap.size()) {
                return minHeap.peek();
            } else {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
        }

        public void balance(){
            if(minHeap.size()-maxHeap.size() >1){
                maxHeap.add(minHeap.poll());
            }
            if(maxHeap.size() - minHeap.size()>1) {
                minHeap.add(maxHeap.poll());
            }
        }
    }
}
