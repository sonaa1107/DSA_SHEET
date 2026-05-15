class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean[][]vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board,word,i,j,1,vis))
                        return true;
                }
            }
        }
        return false;
    }
    boolean helper(char[][]b,String word,int i,int j,int c,boolean[][]vis){
        if(c==word.length()){
            return true;
        }
        vis[i][j]=true;
        int[][]dir={{-1,0},{0,1},{1,0},{0,-1}};
        for(int[]d:dir){
            int ni=i+d[0];
            int nj=j+d[1];

            if(ni>=0 && ni<b.length && nj>=0 && nj<b[0].length && !vis[ni][nj] && b[ni][nj]==word.charAt(c)){
                if(helper(b,word,ni,nj,c+1,vis))
                    return true;
            }
        }
        vis[i][j]=false;
        return false;
    }
}