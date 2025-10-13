/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode p=l1, q=l2,current=head;
        int carry=0;
        while(p!=null || q!=null){
            int x,y;
            if(p!=null){
             x=p.val;
            }else {
                x=0;
            }
            if(q!=null){
             y=q.val;
            }else {
                y=0;
            }
            int sum=carry+x+y;
            carry=sum/10;
            current.next=new ListNode(sum%10);
            current=current.next;
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;

        }
        if(carry>0){
            current.next=new ListNode(carry);
        }
        return head.next;
    }
   
}