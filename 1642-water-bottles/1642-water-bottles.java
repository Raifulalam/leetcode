class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=numBottles;
        int init=numBottles;
        while(init>=numExchange){
            int left=init%numExchange;
            int chg=(init-left)/numExchange;
            ans+=chg;
            init=left+chg;

        }
        return ans;
    }
}