package Trees;

/*
 @author Myvin Barboza
 15/04/20 10:34 AM 
 */
public class SameTreeLC100 {

    static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null) return false;
        if (q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {

    }
}