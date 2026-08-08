/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        // inserting node in between
        Node temp=head;
        while(temp!=null){
            Node copynode=new Node(temp.val);
            copynode.next=temp.next;
            temp.next=copynode;
            temp=temp.next.next;
        }
        //connecting random pointer
        Node tem=head;
        while(tem!=null){
            if(tem.random==null){
                tem.next.random=null;
            }
            else{
                tem.next.random=tem.random.next;
            }
            tem=tem.next.next;
        }
        //connecting next pointer
        Node dh=new Node(-1);
        Node dp=dh;
        Node t=head;
        while(t!=null){
            dp.next=t.next;
            t.next=t.next.next; //connect to org node next again
            dp=dp.next;
            t=t.next;
        }
        return dh.next;

    }
}