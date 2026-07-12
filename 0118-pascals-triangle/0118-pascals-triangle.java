class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            ans.add(generateRow(i));
        }
        return ans;
    }
    ArrayList<Integer>generateRow(int n){
      ArrayList<Integer> list=new ArrayList<>();
      int ans=1;
      list.add(ans);
      for(int i=1;i<n;i++){
        ans=ans*(n-i);
        ans=ans/i;
        list.add(ans);
      }
      return list;  
    }
}