class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int ans=0;
        int i=0;
        while(i<boxTypes.length && truckSize!=0){
            if(truckSize>=boxTypes[i][0]){
                ans+=(boxTypes[i][0]*boxTypes[i][1]);
                truckSize-=boxTypes[i][0];
            }
            else{
                ans+=(truckSize*boxTypes[i][1]);
                truckSize=0;
            }
            i++;
        }
        return ans;
    }
}