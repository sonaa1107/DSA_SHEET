class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer>list=new ArrayList<>();
        int cnt1=0,cnt2=0,ele1=0,ele2=0;
        for(int i=0;i<n;i++){
            if(cnt1==0 && nums[i]!=ele2){
                cnt1=1;
                ele1=nums[i];
            }
            else if(cnt2==0 && nums[i]!=ele1){
                cnt2=1;
                ele2=nums[i];
            }
            else if(nums[i]==ele1){
                cnt1++;
            }
            else if(nums[i]==ele2){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        int mini=(int)n/3+1;
        int c1=0,c2=0;
        for(int ele:nums){
            if(ele==ele1){
                c1++;
            }else if(ele==ele2){
                c2++;
            }
        }
        if(c1>=mini)list.add(ele1);
        if(c2>=mini)list.add(ele2);
        return list;
    }
}