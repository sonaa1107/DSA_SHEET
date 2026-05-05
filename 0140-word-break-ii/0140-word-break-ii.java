class Solution {
    ArrayList<String>ans=new ArrayList<>();
    HashSet<String>set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        helper(s,0,new ArrayList<>());
        return ans;
    }
    void helper(String s,int index,List<String>l){
        if(index==s.length()){
            StringBuilder sb=new StringBuilder();
            for(String curr:l){
                sb.append(curr+" ");
            }
            ans.add(sb.toString().trim());
            return;
        }
        for(int i=index;i<s.length();i++){
            String curr=s.substring(index,i+1);
            if(set.contains(curr)){
                l.add(curr);
                helper(s,i+1,l);
                l.remove(l.size()-1);
            }
        }
    }
}