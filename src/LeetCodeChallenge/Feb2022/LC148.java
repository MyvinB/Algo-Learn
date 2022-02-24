package LeetCodeChallenge.Feb2022;

/
  @author mmichaelbarboza
  on 6:34 AM 2/24/2022
  Time Taken:
 /
public class LC148 {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
        return head;
        }
        ListNode prev = null;
        ListNode fast=head,slow = head;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1,l2);
    }

    public ListNode merge(ListNode l1,ListNode l2){
          ListNode l = new ListNode(-1);
          ListNode p = l;
          while(l1!=null && l2!=null){
              if(l1.val<l2.val){
                  p.next = l1;
                  l1 = l1.next;
              }else {
                  p.next = l2;
                  l2 = l2.next;
              }
              p = p.next;
          }
          if(l1!=null) p.next = l1;
          if(l2!=null) p.next = l2;
          return l.next;
    }
}
