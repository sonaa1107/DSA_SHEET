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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode nextnode=null;
        ListNode prevnode=null;
        while(temp!=null){
            ListNode kthNode=getKthNode(temp,k);
            if(kthNode==null){
                if(prevnode!=null){
                    prevnode.next=temp;
                }
                break;
            }
            nextnode=kthNode.next;
            kthNode.next=null;
            reverse(temp);
            if(temp==head)head=kthNode;
            else prevnode.next=kthNode;
            prevnode=temp;
            temp=nextnode;
        }
        return head;
    }
    ListNode getKthNode(ListNode head,int k){
        k--;
        while(head!=null && k>0){
            head=head.next;
            k--;
        }
        return head;
    }
    ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode newHead=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}