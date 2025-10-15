class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int pl=0;
        int curr=1;
        int result=0;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)){
                curr+=1;
            }else{
                pl=curr;
                curr=1;
            }
        result = Math.max(result, Math.max(curr / 2, Math.min(pl, curr)));
        }
        return result;
    }
}