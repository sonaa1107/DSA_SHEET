class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character>set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count=0,ans=0;
        int i=0,j=0;
        while(j<s.length()){
            if(set.contains(s.charAt(j)))count++;
            if(j-i+1>k){
                if(set.contains(s.charAt(i))){
                    count--;
                }
                i++;
            }
            if(j-i+1==k)ans=Math.max(ans,count);
            j++;
        }
        return ans;
    }
}