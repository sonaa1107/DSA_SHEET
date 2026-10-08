class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start=1;
        int end=getMax(nums);
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isPossible(nums,mid,threshold)){
                ans=mid;
                end=mid-1;
            }
            else start=mid+1;
        }
        return ans;
    }
    int getMax(int[]arr){
        int ans=Integer.MIN_VALUE;
        for(int i:arr){
            if(i>ans)ans=i;
        }
        return ans;
    }
    boolean isPossible(int[]arr,int div,int threshold){
        int total=0;
        for(int n:arr){
            double val=(double)n/div;
            total+=Math.ceil(val);
        }
        return total<=threshold?true:false;
    }
}