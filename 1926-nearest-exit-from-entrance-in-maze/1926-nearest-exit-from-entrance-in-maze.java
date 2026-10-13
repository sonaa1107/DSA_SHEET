class Solution {
    int ans=Integer.MAX_VALUE;
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]>queue=new LinkedList<>();
        queue.offer(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]] = '+';
        int[][]dir={{-1,0},{0,1},{1,0},{0,-1}};
        while(!queue.isEmpty()){
            int[]curr=queue.poll();
            int i=curr[0];
            int j=curr[1];
            int step=curr[2];
            for(int[]d:dir){
                int ni=i+d[0];
                int nj=j+d[1];
                int count=0;

                if(ni>=0 && ni<maze.length && nj>=0 && nj<maze[0].length && maze[ni][nj]!='+'){
                    count=step+1;
                    queue.offer(new int[]{ni,nj,count});
                    maze[ni][nj]='+';
                    if(ni==0 || nj==0 || ni==maze.length-1 || nj ==maze[0].length-1){
                        ans=Math.min(count,ans);
                    }
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}