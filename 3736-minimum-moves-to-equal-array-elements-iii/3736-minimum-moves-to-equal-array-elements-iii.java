class Solution {
    public int minMoves(int[] nums) {
        int max=getMax(nums);
        int minMove=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=max){
                minMove+=max-nums[i];
            }
        }
        return minMove;
    }
    int getMax(int[]arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)max=arr[i];
        }
        return max;
    }
}