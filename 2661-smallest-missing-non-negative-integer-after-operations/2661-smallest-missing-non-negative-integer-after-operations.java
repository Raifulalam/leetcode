class Solution {
    public int findSmallestInteger(int[] nums, int value) {
      int[] freq=new int[value];
      for(int num:nums){
        int mod = ((num % value) + value) % value; // handle negatives
        freq[mod]++;
      }
      int mex=0;
      while(true){
       int mod = mex % value;
        if(freq[mod]==0)
            return mex;
        freq[mod]--;
        mex++;
        
      }
    }
}