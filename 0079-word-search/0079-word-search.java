class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board,word,i,j,1))
                        return true;
                }
            }
        }
        return false;
    }
    boolean helper(char[][]b,String word,int i,int j,int c){
        if(c==word.length()){
            return true;
        }
        char t=b[i][j];
        b[i][j]='#'; //mark visited
        int[][]dir={{-1,0},{0,1},{1,0},{0,-1}};
        for(int[]d:dir){
            int ni=i+d[0];
            int nj=j+d[1];

            if(ni>=0 && ni<b.length && nj>=0 && nj<b[0].length && b[ni][nj]==word.charAt(c)){
                if(helper(b,word,ni,nj,c+1)){
                    b[i][j]=t; // restore before returning
                    return true;
                }
            }
        }
        b[i][j]=t; //backtrack
        return false;
    }
}