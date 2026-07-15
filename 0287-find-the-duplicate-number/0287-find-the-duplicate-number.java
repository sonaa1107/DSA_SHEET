class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n){
            int ci=nums[i]-1;
            if(nums[ci]!=nums[i]){
                swap(nums,i,ci);
            }
            else 
            i++;
        }
        for(int in=0;in<n;in++){
            if(nums[in]!=in+1){
                return nums[in];
            }
        }
        return -1;
    }
    void swap(int[]arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}