class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0;
        int max=0;
      
 
        for(int num:nums){
            if(num==1){

             ans++;
             max=Math.max(max,ans);
            }else{
                ans=0;

            }
            
        }
        return max;
    }
}