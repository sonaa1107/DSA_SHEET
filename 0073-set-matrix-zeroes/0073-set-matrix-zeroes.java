class Solution {
    public void setZeroes(int[][] matrix) {
        // brute force approach
        int m=matrix.length;
        int n=matrix[0].length;
        int col0=1;
        //boolean row[]=new boolean[m]; //matrix[...][0]
        //boolean col[]=new boolean[n]; //matrix[0][...]
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;  //row update
                    if(j!=0)
                    matrix[0][j]=0;  //col update
                    else
                    col0=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]!=0)
                    if(matrix[i][0]==0 ||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //update row 0
        if(matrix[0][0]==0){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        if(col0==0){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
        return;
    }
}