class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(new ArrayList<>(),k,n,1,0);
        return ans;
    }
    void helper(ArrayList<Integer>list,int k,int n,int num,int sum){
        if(list.size()==k){
            if(sum==n){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=num;i<=9;i++){
            if(sum+i>n)break;
            list.add(i);
            helper(list,k,n,i+1,sum+i);
            list.remove(list.size()-1);
        }
    }
}