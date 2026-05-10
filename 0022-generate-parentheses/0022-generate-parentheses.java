class Solution {
    ArrayList<String>ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(new StringBuilder(),0,0,n);
        return ans;

    }
    void generate(StringBuilder sb,int open,int close,int n){
        if(sb.length()==n*2){
            ans.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append('(');
            generate(sb,open+1,close,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            generate(sb,open,close+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}