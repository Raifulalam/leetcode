class Solution {
    public int mostFrequent(int[] nums, int key) {
        int n=nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
     
        for(int i=0;i<n-1;i++){
            if(nums[i]==key){
                int target=nums[i+1];
                freq.put(target, freq.getOrDefault(target, 0) + 1);
            }
        }
         int ans = -1, maxFreq = 0;
         for (int num : freq.keySet()) {
            if (freq.get(num) > maxFreq) {
            maxFreq = freq.get(num);
            ans = num;
                }
             }
         
        return ans;
    }
}