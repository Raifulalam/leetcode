class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count=0;
        int curr=Integer.MIN_VALUE;
        for(int n:nums){
            int low=n-k;
            int high=n+k;
            if(curr+1<=high){
                int ass=Math.max(curr+1,low);
                curr=ass;
                count++;
            }
        }
        return count;
    }
}