import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/*Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

class TwoLinkedNumber {
    static void addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode lat =new ListNode(0);
        ListNode dum=lat;
        int sum=0;
        int i=0;
        while(true){

            if(temp1!=null){
                i++;
                sum=sum+temp1.val;
                temp1=temp1.next;
            }
            if(temp2!=null){
                i++;
                sum=sum+temp2.val;
                temp2=temp2.next;
            }
            if(sum>9){
                System.out.println(sum+"if");
                lat.next=new ListNode(sum%10);
                lat=lat.next;
                sum=sum/10;
            }
            else{
                System.out.println(sum+"else");
                lat.next=new ListNode(sum);
                lat=lat.next;
                sum=0;
            }
            if(temp1==null&&temp2==null)break;

        }
        if(sum>0){
            lat.next=new ListNode(sum);
            //lat=lat.next;
        }

        while(dum!=null){
            System.out.println(dum.val);
            dum=dum.next;
        }
    }
    public static void main(String[] args) {
        ListNode a=new ListNode(2);
        ListNode b=new ListNode(4);
        ListNode c=new ListNode(3);
        a.next=b;
        b.next=c;
        ListNode a1=new ListNode(5);
        ListNode b1=new ListNode(6);
        ListNode c1=new ListNode(4);
        //ListNode d1=new ListNode();
        a1.next=b1;
        b1.next=c1;
        //c1.next=d1;
        ListNode ae=new ListNode(5);
        ListNode be=new ListNode(5);
        addTwoNumbers(ae,be);

    }
}
