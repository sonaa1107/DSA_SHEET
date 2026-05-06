class Solution {
    ArrayList<String>ans=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String>map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        helper(digits,0,map,new StringBuilder());
        return ans;
    }
    void helper(String s,int index,HashMap<Character,String>map,StringBuilder sb){
        if(index==s.length()){
            ans.add(sb.toString());
            return;
        }
        Character c=s.charAt(index);
        String value=map.get(c);
        for(char ch:value.toCharArray()){
            sb.append(ch);
            helper(s,index+1,map,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}