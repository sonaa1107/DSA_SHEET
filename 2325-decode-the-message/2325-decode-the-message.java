class Solution {
    public String decodeMessage(String key, String message) {
        int count=0;
        HashMap<Character,Integer>map=new HashMap<>();
        for (char ch:key.toCharArray()){
            if(ch==' ')continue;
            else if(!map.containsKey(ch)){
                map.put(ch,count);
                count++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<message.length();i++){
            char c=message.charAt(i);
            if(c==' '){
                sb.append(" ");
            }
            else{
                int val=map.get(c);
                char ans=(char)('a'+ val);
                sb.append(ans);
            }
        }
        return sb.toString();
    }
}