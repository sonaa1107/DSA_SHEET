class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer>map=new HashMap<>();
        int k=s1.length();
        int i=0,j=0,count=k;
        for(char c:s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        while(j<s2.length()){
            char ch=s2.charAt(j);
            if(map.containsKey(ch)){
                if(map.get(ch)>0){
                   count--; 
                }
                map.put(ch,map.get(ch)-1);
            }
            if(j-i+1>k){
                char left=s2.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if(map.get(left)>0)
                        count++;
                }
                i++;
            }
            if(j-i+1==k){
                if(count==0){
                    return true;
                }
            }
            j++;
        }
        return false;
    }
}