class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int i=0;
        for(int j=0;j<n;j++){
            if(nums[j]!=0){
                if(i!=j){
                swap(nums,i,j);
                }
                i++;
            }
        }
    }
    void swap(int [] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}