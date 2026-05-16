class Solution {
    public int totalNQueens(int n) {
        int[][]board=new int[n][n];
        boolean[]rowUsed=new boolean[n];
        boolean[]lowerdiag=new boolean[(2*n)-1];
        boolean[]upperdiag=new boolean[(2*n)-1];
        return helper(board,0,n,rowUsed,lowerdiag,upperdiag);

    }
    int helper(int[][]board,int col,int n,boolean[]rowUsed,boolean[]lowerdiag,boolean[]upperdiag){
        int count=0;
        if(col==n){
            return 1;
        }
        for(int row=0;row<n;row++){
            if(rowUsed[row] || lowerdiag[row+col] || upperdiag[(n-1)+(col-row)]){
                continue;
            }
            board[row][col]=1;//queen
            rowUsed[row]=true;
            lowerdiag[row+col]=true;
            upperdiag[(n-1)+(col-row)]=true;
            count+=helper(board,col+1,n,rowUsed,lowerdiag,upperdiag);
            board[row][col]=0; //remove queen 
            rowUsed[row]=false; //backtrack
            lowerdiag[row+col]=false;
            upperdiag[(n-1)+(col-row)]=false;
        }
        return count;
    }
}