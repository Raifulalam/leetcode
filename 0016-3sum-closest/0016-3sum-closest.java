class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int Tsum=nums[i]+nums[l]+nums[r];
                if(Tsum==target){
                    return Tsum;
                }
                if(Math.abs(Tsum-target)<Math.abs(sum-target)){
                    sum=Tsum;
                }
                if(Tsum>target){
                    --r;
                }else{
                    ++l;
                }
            }
           
        }
        return sum;
    }
}