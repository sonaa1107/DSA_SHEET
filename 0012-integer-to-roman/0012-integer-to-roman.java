class Solution {
    public String intToRoman(int num) {
        String[]sym={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[]val={1,4,5,9,10,40,50,90,100,400,500,900,1000};
        StringBuilder sb=new StringBuilder();
        for(int i=val.length-1;i>=0;i--){
            while(num>=val[i]){
                sb.append(sym[i]);
                num-=val[i];
            }
            if(num==0)break;
        }
        return sb.toString();
    }
}