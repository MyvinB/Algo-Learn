package practise;

public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
    if(root == null){
        return null;
    }
    if(key<root.val){
        root.left = deleteNode(root.left,key)
    }
    else if(key>root.val){
        root.right = deleteNode(root.right,key)
    }
    else{
        if(root.left==null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }
        else{
            TreeNode minVal = findMinInRight(root.right);
            root.val = minVal.val;
            root.right = deleteNode(root.right,root.val);
        }
    }
    return root;
    }

    public TreeNode findMinInRight(TreeNode root){
        while(root.left!= null){
            root = root.left;
        }
        return root;
    }
}
