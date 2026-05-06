class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<nums.length){
            int correctIndex=nums[i];
            if(correctIndex<n && nums[correctIndex]!= correctIndex){
                swap(nums,correctIndex,i);
            }else
                i++;
        }
        int ans=n;
        for(int in=0;in<n;in++){
            if(nums[in]!=in){
                ans=in;
            }
        }
        return ans;
    }
    void swap(int[]arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}