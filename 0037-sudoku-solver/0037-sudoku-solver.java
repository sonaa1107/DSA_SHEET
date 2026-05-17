class Solution {
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
    boolean helper(char[][]board,int i,int j){
        if(i==9){
            return true;
        }
        if(j==9){
            return helper(board,i+1,0);
        }
        if(board[i][j]!='.'){
            return helper(board,i,j+1);
        }
        for(char num='1';num<='9';num++){
            if(canPlace(board,num,i,j)){
                board[i][j]=num;
                if(helper(board,i,j+1))
                    return true;
                board[i][j]='.';
            }
        }
        return false;
    }
    boolean canPlace(char[][]board,char num,int i,int j){
        //row check
        for(int col=0;col<9;col++){
            if(board[i][col]==num){
                return false;
            }
        }
        //col check
        for(int row=0;row<9;row++){
            if(board[row][j]==num){
                return false;
            }
        }
        //3X3 grid check
        int sr=(i/3)*3;
        int sc=(j/3)*3;
        for(int ni=sr;ni<sr+3;ni++){
            for(int nj=sc;nj<sc+3;nj++){
                if(board[ni][nj]==num){
                    return false;
                }
            }
        }
        return true;
    }
}