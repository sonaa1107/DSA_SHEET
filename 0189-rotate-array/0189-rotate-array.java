class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

    }
    void reverse(int [] arr,int s,int e){
        int start=s;
        int end=e;
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    void swap(int[] arr,int i ,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}