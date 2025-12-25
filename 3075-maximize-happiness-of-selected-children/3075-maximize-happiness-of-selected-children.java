class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum=0;
        int n=happiness.length;
        Arrays.sort(happiness);
        for(int i=0;i<k;i++){
            int value=happiness[n-1-i]-i;
            if(value<=0)break;
            sum+=value;
            
        }
        return sum;
    }
}