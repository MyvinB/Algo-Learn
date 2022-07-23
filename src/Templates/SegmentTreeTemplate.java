package Templates;

s

public class SegmentTreeTemplate {

    public static void main(String[] args) {
        
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

    void updateHelper(SegmentTree root, int index, int val){
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

    int sumRange(SegmentTree root, int start, int end){
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


}
