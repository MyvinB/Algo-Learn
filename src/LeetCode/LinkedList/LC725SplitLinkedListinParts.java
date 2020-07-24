package LeetCode.LinkedList;/*
 @author Myvin Barboza
 24/07/20 9:49 AM 
 */

public class LC725SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts=new ListNode[k];
        int len=0;
        for(ListNode node=root;node!=null;node=node.next)len++;
        int n=len/k,r=len%k;
        ListNode node=root;
        for(int i=0; node!=null && i<k;i++,r--){
            parts[i]=node;
            ListNode prev=null;
            for(int j=0;j<n+(r>0?1:0);j++){
                prev=node;
                node=node.next;
            }
            prev.next=null;
        }

        return parts;
    }

}
