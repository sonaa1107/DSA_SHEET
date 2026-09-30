class Solution {
    public String countAndSay(int n) {
        if(n==1)return "1";
        String newstr=countAndSay(n-1);
        return formation(newstr);
    }
    String formation(String s){
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            int count=1;
            while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                count++;
                i++;
            }
           sb.append(String.valueOf(count)+s.charAt(i));
           i++;
        }
        return sb.toString();
    }
}