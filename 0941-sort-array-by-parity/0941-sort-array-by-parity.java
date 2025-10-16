class Solution {
    public int[] sortArrayByParity(int[] nums) {
       int n=nums.length;
       int[] ans=new int[n];
       int lst=n-1;
       int strt=0;
       for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                ans[strt]=nums[i];
                strt++;
            }else{
                ans[lst]=nums[i];
                lst--;
            }
       }
       return ans;

    }
}