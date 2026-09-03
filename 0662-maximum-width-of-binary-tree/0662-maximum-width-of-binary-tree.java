/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node,int i){
            this.node=node;
            this.index=i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair>queue=new LinkedList<>();
        int ans=0;
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            int min=queue.peek().index;
            int last=0,first=0;
            for(int i=0;i<size;i++){
                Pair p=queue.poll();
                TreeNode curr=p.node;
                int curindx=p.index-min;
                if(i==0)first=curindx;
                if(i==size-1)last=curindx;
                if(curr.left!=null)queue.offer(new Pair(curr.left,curindx*2+1));
                if(curr.right!=null)queue.offer(new Pair(curr.right,curindx*2+2));
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}