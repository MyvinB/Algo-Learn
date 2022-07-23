package LeetCodeChallenge.JUNE2021;

import Templates.SegmentTreeTemplate;

import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.List;

public class LC315R {

    public static void main(String[] args) {
        int[] t = new int[]{5,2,6,1};
        LC315R as = new LC315R();
        System.out.println(as.countSmaller(t));
    }
    SegmentTree root = null;
    class SegmentTree{
        private int start,end;
        private SegmentTree left,right;
        private int sum;
        SegmentTree(int start,int end){
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            sum = 0;
        }
    }

    private SegmentTree buildTree(int[] nums, int start, int end){
        SegmentTree root = new SegmentTree(start,end);
        //leaf nodes
        if(start==end){
            return root;
        }
        else {
            int mid = start+ (end-start)/2;
            root.left = buildTree(nums,start,mid);
            root.right = buildTree(nums,mid+1,end);
        }
        return root;
    }

    void updateHelper(SegmentTree root, int index, int val){
        if(root.start == root.end){
            root.sum += val;
        }
        else {
            int mid = root.start + (root.end-root.start)/2;
            if(index<=mid){
                updateHelper(root.left,index,val);
            }
            else updateHelper(root.right,index,val);
            root.sum = root.left.sum + root.right.sum;
        }
    }

    int sumRange(SegmentTree root, int start, int end){
        if (root == null || start >end) {
            return 0;
        }
        if(root.start== start && root.end==end) return root.sum;
        else {
            int mid = root.start +(root.end-root.start)/2;
            if(end<=mid){
                return sumRange(root.left,start,end);
            }
            else if(start>=mid+1){
                return sumRange(root.right,start,end);
            }
            else return sumRange(root.left,start,mid) + sumRange(root.right,mid+1,end);
        }
    }


    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        SegmentTree segmentTree = buildTree(nums,min,max);
        for(int i=n-1;i>=0;i--){
            updateHelper(segmentTree,nums[i],1);
            counts[i] = sumRange(segmentTree,min,nums[i]-1);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<counts.length;i++) res.add(counts[i]);
        return res;
    }

}
