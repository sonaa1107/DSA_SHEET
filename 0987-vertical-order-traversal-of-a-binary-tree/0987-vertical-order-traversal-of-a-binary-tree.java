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
    class Tuple{
        TreeNode node;
        int vertical;
        int level;

        Tuple(TreeNode n,int v,int l){
            this.node=n;
            this.vertical=v;
            this.level=l;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple>q=new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map=new TreeMap<>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t=q.poll();
            TreeNode node=t.node;
            int v=t.vertical;
            int l=t.level;

            if(!map.containsKey(v)){
                map.put(v,new TreeMap<>());
            } 
            if(!map.get(v).containsKey(l)){
                map.get(v).put(l,new PriorityQueue<>());
            }
            map.get(v).get(l).offer(node.val);

            if(node.left!=null){
                q.offer(new Tuple(node.left,v-1,l+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,v+1,l+1));
            }
        }
        List<List<Integer>>ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>>ys:map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:ys.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
    
}