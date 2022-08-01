package LeetCodeChallenge.Aug2022;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC480 {

    public static void main(String[] args) {
        //[2147483647,1,2,3,4,5,6,7,2147483647]
        //2
        int[] t = new int[]{2147483647,1,2,3,4,5,6,7,2147483647};
        System.out.println(Arrays.toString(medianSlidingWindow(t,2)));
    }
    static class MedianFinder{
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b.compareTo(a));

        public void add(int num){
            if(maxHeap.size()==0 || maxHeap.peek()>num){
                maxHeap.add(num);
            }else minHeap.add(num);
            balance();
        }

        public void remove(int num){
            //We can never judge using the left half imagine the case 1 goes to macHeap and 2 to min heap here we try to check num<=maxHeap which will be true but num is in minHeap
            //If the element does not lesser that minHeap peak value that means it's there in mean heap because lesser than that will be in max heap
            if(minHeap.size()!=0 && minHeap.peek()<=num){
                minHeap.remove(num);
            }else maxHeap.remove(num);
            balance();
        }

        public void balance(){
            if (maxHeap.size()-minHeap.size()>1){
                minHeap.add(maxHeap.poll());
            }
            if(minHeap.size()-maxHeap.size()>1){
                maxHeap.add(minHeap.poll());
            }
        }

        public double getMedian(){
            if(maxHeap.size()>minHeap.size()) return maxHeap.peek();
            else if(minHeap.size()>maxHeap.size()) return minHeap.peek();
            else return ((double)minHeap.peek()+(double)maxHeap.peek())/2.0;
        }


    }





    public static double[] medianSlidingWindow(int[] nums, int k) {
        MedianFinder medianFinder = new MedianFinder();
        int n = nums.length;
        int size = n-k+1;
        double[] res = new double[size];

        for(int i=0;i<=n;i++){
            if(i>=k){
                res[i-k] = medianFinder.getMedian();
                medianFinder.remove(nums[i-k]);
            }
            if(i<n)
                medianFinder.add(nums[i]);
        }
        return res;
    }
}
