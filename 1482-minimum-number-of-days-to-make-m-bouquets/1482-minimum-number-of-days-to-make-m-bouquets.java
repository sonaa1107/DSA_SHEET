class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start=1;
        int end=getMax(bloomDay);
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isPossible(bloomDay,k,m,mid)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
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
    boolean isPossible(int[]arr,int k,int m,int bloom){
        int total=0;
        int count=0;
        int j=0;
        while(j<arr.length){
            if(arr[j]<=bloom){
                count++;
                if(count==k){
                total++;
                count=0;
                }
            }
            else{
                count=0;
            }
            j++;
        }
        return total>=m?true:false;
    }
}