package practise;

public class LC1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        return constructIt(preorder,Integer.MAX_VALUE);
    }
    int index=0;
    TreeNode constructIt(int[] a,int limit){
        if(a.length==index || a[index]>limit){
            return null;
        }
        TreeNode root = new TreeNode(a[index++]);
        //for left the max limit will be the root node
        root.left = constructIt(a,root.val);
        //for right the max limorit will be roots parent or current lmit of root
        root.right = constructIt(a,limit);
        return root;
    }
}
