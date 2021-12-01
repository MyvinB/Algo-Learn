package practise;

import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 6:56 PM 12/1/2021
 */
public class LC295 {

    public static void main(String[] args) {

    }

    class MedianFinder {
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap  = new PriorityQueue<>((a,b)->Integer.compare(b,a));
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if(minHeap.size()>maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if(maxHeap.size()>minHeap.size()) return maxHeap.peek();
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
    }
}
