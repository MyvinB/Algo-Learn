package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 9:33 AM 3/11/2022
 * Time Taken:
 */
public class LC61 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        ListNode first = head;
        ListNode last = head;
        int totalCount = 1;
        while(last.next!=null){
            totalCount++;
            last=last.next;
        }
        last.next = first;
        k= k%totalCount;
        for(int i=1;i<=totalCount-k;i++){
            first = first.next;
            last = last.next;
        }
        last.next = null;
        return first;
    }
}
