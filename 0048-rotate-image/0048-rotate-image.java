class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
        for(int i=0;i<n;i++){
            reverse(matrix[i]);
        }
        return;
    }
    void reverse(int[]arr){
        int n=arr.length;
        int i=0;
        int j=n-1;
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    void swap(int[]arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}