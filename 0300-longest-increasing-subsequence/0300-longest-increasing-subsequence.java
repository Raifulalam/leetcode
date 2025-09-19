class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0 ) return 0;
       ArrayList<Integer>tails=new ArrayList<>();
        for(int n:nums){
            int i=Collections.binarySearch(tails,n);
           if(i<0) i=-i-1;
           if(i==tails.size()) tails.add(n);
           else tails.set(i,n);
        }
        return tails.size();
    }
}