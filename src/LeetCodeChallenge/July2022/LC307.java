package LeetCodeChallenge.July2022;

import javax.swing.text.Segment;

public class LC307 {

    public static void main(String[] args) {
        int[] t = new int[]{0,9,5,7,3};
        NumArray p = new NumArray(t);
        System.out.println(p.sumRange(4,4));

    }

     static class NumArray {
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

        private SegmentTree buildTree(int[] nums,int start,int end){
            SegmentTree root = new SegmentTree(start,end);
            //leaf nodes
            if(start==end){
                root.sum = nums[start];
            }
            else {
                int mid = start+ (end-start)/2;
                root.left = buildTree(nums,start,mid);
                root.right = buildTree(nums,mid+1,end);
                root.sum = root.left.sum +root.right.sum;
            }

            return root;
        }

        void updateHelper(SegmentTree root,int index, int val){
            if(root.start == root.end){
                root.sum = val;
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

        int sumRange(SegmentTree root,int start,int end){
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

        public NumArray(int[] nums) {
            root = buildTree(nums,0,nums.length-1);
        }

        public void update(int index, int val) {
            updateHelper(root,index,val);
        }

        public int sumRange(int left, int right) {
            return sumRange(root,left,right);
        }
    }

}
