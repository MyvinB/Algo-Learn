package LeetCode.LinkedList;

public class LC1290ConvertBinaryNumberinaLinkedListtoInteger {

    public static void main(String[] args) {

    }

    public int getDecimalValue(ListNode head) {
        int ans=0;
        while (head != null) {
            //bit wise way
            //ans = ans<<1 | head.val
            ans=ans*2+head.val;
            System.out.println(ans);
            head = head.next;
        }
        return ans;
    }
}
