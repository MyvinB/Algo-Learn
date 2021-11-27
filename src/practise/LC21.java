package practise;

/**
 * @author mmichaelbarboza
 * on 9:07 AM 11/27/2021
 */
public class LC21 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l2.next= new ListNode(3);
        l2.next.next = new ListNode(4);
        mergeTwoLists(l1,l2);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int val = 0;
        while(true){
            if(list1 == null){
                dummy.next=list2;
                break;
            }
            if(list2 == null){
                dummy.next=list1;
                break;
            }
            if(list1.val<=list2.val){
                dummy.next = list1;
                list1=list1.next;

            }else {
                dummy.next= list2;
                list2= list2.next;
            }
            dummy = dummy.next;
        }

        return head.next;

    }
}
