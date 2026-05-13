class Solution {
    List<List<String>>ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][]b=new int[n][n];
        helper(b,0,n);
        return ans;
    }
    void helper(int[][]b,int colIdx,int n){
        if(colIdx==n){
            ArrayList<String>list=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(b[i][j]==0){
                        sb.append(".");
                    }else{
                        sb.append("Q");
                    }
                }
                list.add(sb.toString());    
            }
            ans.add(list);
        }
        for(int rowIdx=0;rowIdx<n;rowIdx++){
            if(check(rowIdx,colIdx,b,n)){
                b[rowIdx][colIdx]=1;
                helper(b,colIdx+1,n);
                b[rowIdx][colIdx]=0;
            }
        }
    }
    boolean check(int r,int c,int[][]b,int n){
        //row check
        for(int j=0;j<c;j++){
            if(b[r][j]==1){
                return false;
            }
        }
        //upper diag
        int r1=r;
        int c1=c;
        while(r1>=0 && c1>=0){
            if(b[r1][c1]==1){
                return false;
            }
            r1--;
            c1--;
        }
        //lower diag
       int r2=r;
        int c2=c;
        while(r2<n && c2>=0){
            if(b[r2][c2]==1){
                return false;
            }
            r2++;
            c2--;
        }
        return true;
    }
}