class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer>list=new ArrayList<>();
        HashMap<Character,Integer>map=new HashMap<>();
        int k=p.length();
        int i=0,j=0;
        for(char c:p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count=k ;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                if(map.get(ch)>0){
                   count--; 
                }
                map.put(ch,map.get(ch)-1);
            }
            if(j-i+1>k){
                char left=s.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if(map.get(left)>0)
                        count++;
                }
                i++;
            }
            if(j-i+1==k && count==0){
                list.add(i);
            }
            j++;
        }
        return list;
    }
}