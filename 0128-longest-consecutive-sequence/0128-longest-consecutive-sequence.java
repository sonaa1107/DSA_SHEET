class Solution {
    public int longestConsecutive(int[] nums) {
        return OpUsingHashing(nums);
    }
    int OpUsingHashing(int[]nums){
        HashSet<Integer>set=new HashSet<>();
        for(int ele:nums){
            set.add(ele);
        }
        int longest=0;
        for(int ele:set){
            if(!set.contains(ele-1)){
                int count=1;
                while(set.contains(ele+1)){
                    count++;
                    ele++;
                } 
                longest=Math.max(longest,count); 
            }
        }
        return longest;
    }
    boolean isPresent(int[]nums,int target){
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                return true;
            }
        }
        return false;
    }
    int usingSortAndLastEle(int[]nums){
        Arrays.sort(nums);
		int lastele=Integer.MIN_VALUE;
		int longest=1;
		int count=0;
		for(int i=0;i<nums.length;i++){
		    int ele=nums[i];
            if(lastele==ele){
                continue;
            }
		    if(lastele==ele-1){
		        count++;
		        lastele=ele;
		    }
		    else if(lastele!=ele-1){
		        lastele=ele;
		        count=1;
		    }
		    longest=Math.max(longest,count);
		}
        return longest;
    }
    int bruteForceUsingLinearSearch(int[]nums){
        int maxlen=0;
        for(int i=0;i<nums.length;i++){
            int ele=nums[i];
            int count=1;
            while(isPresent(nums,ele+1)){
                count++;
                ele=ele+1;
            }
            maxlen=Math.max(maxlen,count);
        }
        return maxlen;
    }
}