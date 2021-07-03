package LeetCodeChallenge.JULY2021;

import java.util.*;

public class LC658 {
    public static void main(String[] args) {
    int[] arr= {1,2,3,4,5};
        System.out.println(Arrays.toString(findClosestElements(arr,4,3).toArray()));
    }

    /*When list is sorted two pointer approach 0(n) */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l= 0,h=arr.length-1;
        while(h-l >=k ){
            int a = Math.abs(arr[l]-x),b = Math.abs(arr[h]-x);
            if(a>b)
                l++;
            else
                h--;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=l;i<=h;i++){
            list.add(arr[i]);
        }
        return list;
    }
    private static class Node{
        private int index;
        private int diff;
        Node(int index,int diff){
            this.index = index;
            this.diff = diff;
        }
    }

    /*When list is not sorted */
    public static List<Integer> findClosestElementsPQ(int[] arr, int k, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->(b.diff==a.diff?b.index-a.index:b.diff-a.diff));
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            pq.add(new Node(arr[i],Math.abs(arr[i]-x)));
            if(pq.size() > k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            list.add(pq.poll().index);
        }
        Collections.sort(list);
        return list;

    }
}
