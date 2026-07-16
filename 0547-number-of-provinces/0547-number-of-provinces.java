class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int ans=0;
        boolean[]visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected,visited,i);
                ans++;
            }
        }
        return ans;
    }
    void  bfs(int[][] isConnected,int curr,boolean[]visited){
        Queue<Integer>queue=new LinkedList<>();
        queue.add(curr);
        visited[curr]=true;
        while(!queue.isEmpty()){
            int c=queue.poll();
            for(int i=0;i<isConnected.length;i++){
                if(!visited[i] && isConnected[c][i]==1){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
    }
    void dfs(int[][]isConnected,boolean[]vis,int curr){
        vis[curr]=true;
        for(int i=0;i<isConnected.length;i++){
            if(!vis[i] && isConnected[curr][i]==1){
                dfs(isConnected,vis,i);
            }
        }
    }
}