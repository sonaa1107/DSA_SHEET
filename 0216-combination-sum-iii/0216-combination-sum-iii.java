class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(new ArrayList<>(),k,n,1);
        return ans;
    }
    void helper(ArrayList<Integer>list,int k,int n,int num){
        if(list.size()==k){
            int sum=0;
            for(int x:list){
                sum+=x;
            }
            if(sum==n){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=num;i<=9;i++){
            list.add(i);
            helper(list,k,n,i+1);
            list.remove(list.size()-1);
        }
    }
}