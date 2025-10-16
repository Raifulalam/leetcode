class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
       int count=0;
       int len=nums.length;
       int min=nums[0],max=nums[len-1];
       if(nums[0]==nums[len-1]) return 0;
       for(int num:nums){
       if(num>min && num<max) count++;
       }
       return count;
    }
}