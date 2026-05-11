class Solution {
    public int maxSubArray(int[] arr) {
        return opSol(arr);
    }
    int opSol(int[]arr){
        int currsum=arr[0];
        int maxsum=arr[0];
        for(int i=1;i<arr.length;i++){
            currsum=Math.max(arr[i],currsum+arr[i]);
            maxsum=Math.max(maxsum,currsum);
        }
        return maxsum;
    }
    int bfSol(int[]arr){
        int currsum=0;
	    int maxsum=0;
	    for(int i=0;i<arr.length;i++){
	        currsum=0;
	        for(int j=i;j<arr.length;j++){
	            currsum+=arr[j];
	            maxsum=Math.max(currsum,maxsum);
	        }
	    }
	    return maxsum;
    }
}