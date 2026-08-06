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
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode t2=reverse(slow.next);
        ListNode t1=head;
        while(t2!=null){
            if(t1.val!=t2.val){
                return false;
            }
            else{
                t1=t1.next;
                t2=t2.next;
            }
        }
        return true;
    }
    ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode temp=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}