package LeetCodeChallenge.JUNE2021;

import java.util.Arrays;

public class LC307 {
    static class  NumArray {
        SegmentTreeNode rootNode = null;

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
                ret.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }

        void updateHelper(SegmentTreeNode root, int pos, int val) {
            if (root.start == root.end)
                root.sum = val;
            else {
                int mid = root.start + (root.end - root.start) / 2;
                if (pos <= mid)
                    updateHelper(root.left, pos, val);
                else
                    updateHelper(root.right, pos, val);

                root.sum = root.left.sum + root.right.sum;
            }
        }

        public NumArray(int[] nums) {
            rootNode = buildTree(nums, 0, nums.length - 1);
        }

        public void update(int index, int val) {
            updateHelper(rootNode,index,val);
        }

        public int sumRange(int left, int right) {
           return  sumRangeHelper(rootNode,left,right);
        }

        int sumRangeHelper(SegmentTreeNode root,int start,int end){
            if(root.start ==start && root.end == end) return rootNode.sum;
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

        public static void main(String[] args) {
            int ar[]= {9,-8};
            NumArray temp =new NumArray(ar);
            temp.sumRange(1,1);


        }
    }
}
