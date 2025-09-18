class Solution {
    public void moveZeroes(int[] nums) {
        int end=0;
        int start=0;
        while(end!=nums.length){
            if(nums[end]!=0){
                int temp=nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
                start++;
            }
            end++;
        }

    }
}