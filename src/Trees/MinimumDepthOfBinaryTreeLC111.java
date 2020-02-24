package Trees;

public class MinimumDepthOfBinaryTreeLC111 {

    static int minDepth(Node root) {
        if(root==null)return 0;
        if(root.left==null&&root.right==null)return 1;
        if(root.left==null)return 1+minDepth(root.right);
        if(root.right==null)return 1+minDepth(root.left);
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        return Math.min(left,right)+1;
    }
    
    public static void main(String[] args) {
        Node root=new Node(10);
        root.right=new Node(1);
        System.out.println(minDepth(root));

    }
}
