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
    class NodeValue{
        int sum;
        int maxNode;
        int minNode;
        NodeValue(int sum,int maxNode,int minNode){
            this.sum=sum;
            this.maxNode=maxNode;
            this.minNode=minNode;
        }
    }
    int maxsum=0;
    public int maxSumBST(TreeNode root) {
       NodeValue ans=maxSum(root);
       return maxsum;
    }
    NodeValue maxSum(TreeNode root){
        if(root==null){
            return new NodeValue(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        NodeValue left=maxSum(root.left);
        NodeValue right=maxSum(root.right);

        if(left.maxNode<root.val && root.val<right.minNode){
            int currsum=root.val+left.sum+right.sum;
            maxsum=Math.max(currsum,maxsum);
            return new NodeValue(currsum,Math.max(root.val,right.maxNode),Math.min(root.val,left.minNode));
        }
        return new NodeValue(Math.max(left.sum,right.sum),Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
}