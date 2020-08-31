package LeetCode.Trees;

public class LC450DeleteNodeinaBST {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(key< root.val)
            root.left=deleteNode(root.left,key);
        else if(key>root.val)
            root.right=deleteNode(root.right,key);
        else{
            //left side null take right
            if(root.left==null)
                return root.right;
            //right side null take left
            else if(root.right==null)
                return root.left;
            // if both are not null
            else {
                /*
                Two ways
                1)Take right minimum ie go to the right node and traverse to the left side copy it in deletion node place
                and then delete that node
                2) Take LEFT MAXIMUM

                * */
                  //RIGHT MINIMUM
//                TreeNode rightMin=root.right;
//                while(rightMin.left!=null) rightMin=rightMin.left;
//                root.val=rightMin.val;
//                root.right=deleteNode(root.right, root.val);

                //LEFT MAXIMUM
                TreeNode leftMax=root.left;
                while( leftMax.right!=null && leftMax.right.right!=null) leftMax=leftMax.right;

                if(leftMax.right==null){
                    root.val=leftMax.val;
                    root.left=leftMax.left;

                }
                else{
                    root.val=leftMax.right.val;
                    root.right=leftMax.left;
                    leftMax.right=null;
                }

            }
        }
        return root;
    }






}
