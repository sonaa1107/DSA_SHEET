class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb=new StringBuilder();
        String[]arr=s.split(" ");
        for(int i=0;i<arr.length;i++){
            if(k>0){
                sb.append(arr[i]+" ");
                k--;
            }
        }
        return sb.toString().trim();
    }
}