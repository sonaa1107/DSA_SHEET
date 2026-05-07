class Solution {
    public int myAtoi(String s) {
        int i=0;
        int n=s.length();
        int sign=1;
        long num=0;
        //ignore leading whitespaces
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        if(i==s.length()){
            return 0;
        }
        // +/- 
        if(s.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        else if(s.charAt(i)=='+'){
            i++;
        }

        while(i<n && Character.isDigit(s.charAt(i))){
            int d=s.charAt(i)-'0';
            num=num*10+d;

            if((sign)*num<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            else if((sign)*num>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            i++;
        }
        return (int)(sign*num);
    }
    
}