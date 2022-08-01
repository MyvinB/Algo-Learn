package LeetCodeChallenge.Aug2022;

import java.util.PriorityQueue;

public class LC295 {

    public static void main(String[] args) {

    }


    class MedianFinder {

        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a,b)->b-a);
            minHeap = new PriorityQueue<>((a,b)->a-b);
        }

        public void addNum(int num) {
            if(maxHeap.size()==0 || maxHeap.peek()>num){
                maxHeap.offer(num);
            }else minHeap.offer(num);
            balance();
        }

        public double findMedian() {
            if(minHeap.size()>maxHeap.size()) return minHeap.peek();
            if(maxHeap.size()>minHeap.size()) return maxHeap.peek();
            else return (maxHeap.peek()+minHeap.peek())/2.0;
        }

        public void balance(){
            if(maxHeap.size()-minHeap.size()>1){
                minHeap.add(maxHeap.poll());
            }
            if(minHeap.size()-maxHeap.size()>1){
                maxHeap.add(minHeap.poll());
            }
        }
    }
}
