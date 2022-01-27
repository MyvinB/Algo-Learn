package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 7:36 AM 1/27/2022
 */
public class LC421 {

    public static void main(String[] args) {
        int[] a = new int[]{14,70,53,83,49,91,36,80,92,51,66,70};
        System.out.println(findMaximumXOR(a));
    }


    static class  Trie{
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }


    public static int findMaximumXOR(int[] nums) {
        if( nums==null || nums.length==0) return 0;
        Trie root = new Trie();
        for(int num:nums){
            Trie curNode = root;
            for(int i=5;i>=0;i--){
                int curBit = getCurBit(num,i);
                if(curNode.children[curBit]==null){
                    curNode.children[curBit] = new Trie();
                }
                curNode = curNode.children[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            Trie curNode = root;
            int res=0;
            for(int i=5;i>=0;i--){
                int curBit = getCurBit(num,i);
                if(curNode.children[curBit^1]!=null){
                    res+=(1<<i);
                    curNode=curNode.children[curBit^1];
                }
                else{
                    curNode=curNode.children[curBit];
                }
            }
            max = Math.max(max,res);

        }
        return max;
    }

    public static int getCurBit(int num, int i){
        return (num & (1<<i))==0?0:1;
    }
}
