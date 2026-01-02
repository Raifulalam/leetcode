class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen=new HashSet<>();
        for(int n:nums){
            if(!seen.contains(n)){
                seen.add(n);
            }else{
                return n;
            }
        }
        return -1;
    }
}