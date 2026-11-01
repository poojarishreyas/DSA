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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int pos=1;
        ListNode before=null;
        ListNode curr=head;
        while(pos!=left){
            pos++;
            before=curr;
            curr=curr.next;   
        }
        ListNode temp=curr;
        int k=right-left+1;
        ListNode prev=null;
        while(k!=0){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            k--;
        }
        if(before!=null){
             before.next=prev;
        }
        else{
            head=prev;
        }
       
        temp.next=curr;
        return head;
    }
}