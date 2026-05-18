class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex=0;
        for(int i=0;i<nums.length;i++){
            if(i<=maxIndex){
                maxIndex=Math.max(maxIndex,nums[i]+i);
            }else{
                return false;
            }
        }
        return true;
    }
}