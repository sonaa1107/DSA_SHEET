class Solution {
    public int compareVersion(String version1, String version2) {
        String[]arr1=version1.split("\\.");
        String[]arr2=version2.split("\\.");
        int len=Math.min(arr1.length,arr2.length);
        for(int i=0;i<len;i++){
            String val1=removeLeadingZeroes(arr1[i]);
            String val2=removeLeadingZeroes(arr2[i]);

            if(val1.length()<val2.length())return -1;
            else if(val1.length()>val2.length())return 1;

            int cmp=val1.compareTo(val2);
            if(cmp<0)return -1;
            else if(cmp>0)return 1;
        }
        for(int i=len;i<arr1.length;i++){
            String str=removeLeadingZeroes(arr1[i]);
            if(!str.equals("0"))return 1;
        }
        for(int i=len;i<arr2.length;i++){
            String str=removeLeadingZeroes(arr2[i]);
            if(!str.equals("0"))return -1;
        }
        return 0;
    }
    String removeLeadingZeroes(String s){
        int i=0;
        while(i<s.length() && s.charAt(i)=='0')i++;
        if(i==s.length()) return "0";
        return s.substring(i);
    }
}