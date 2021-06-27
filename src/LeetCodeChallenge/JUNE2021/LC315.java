package LeetCodeChallenge.JUNE2021;

import java.util.ArrayList;
import java.util.List;

public class LC315 {

    class SegmentTreeNode {
        private int start, end;
        private SegmentTreeNode left, right;
        private int sum;

        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            sum = 0;
        }
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
       SegmentTreeNode ret = new SegmentTreeNode(start, end);
        if (start == end) {
            return ret;
        } else {
            int mid = start + (end - start) / 2;
            ret.left = buildTree(nums, start, mid);
            ret.right = buildTree(nums, mid + 1, end);
            ret.sum = ret.left.sum + ret.right.sum;
        }
        return ret;
    }

    int sumRangeHelper(SegmentTreeNode root,int start,int end){
        if (root == null || start >end) {
            return 0;
        }
        if(root.start ==start && root.end == end) return root.sum;
        else {
            int mid = root.start + (root.end- root.start)/2;
            if(end<=mid){
                return sumRangeHelper(root.left,start,end);
            }
            else if(start>=mid+1){
                return  sumRangeHelper(root.right,start,end);
            }
            else return sumRangeHelper(root.left,start,mid) +sumRangeHelper(root.right,mid+1,end);
        }
    }

    void updateHelper(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end)
            root.sum += val;
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid)
                updateHelper(root.left, pos, val);
            else
                updateHelper(root.right, pos, val);

            root.sum = root.left.sum + root.right.sum;
        }
    }

    public  List<Integer> countSmaller(int[] nums) {
        int[] counts = new int[nums.length];
        int min = Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        for(int i:nums){
            min= Integer.min(min,i);
            max= Integer.max(max,i);
        }
        SegmentTreeNode rootNode = buildTree(nums,min,max);
        for(int i=nums.length-1;i>=0;i--){
            updateHelper(rootNode,nums[i],1);
            counts[i]=sumRangeHelper(rootNode,min,nums[i]-1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i:counts){
            ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums ={5,2,6,1};
        for(Integer i:new LC315().countSmaller(nums)){
            System.out.println(i);
        }
    }
}
