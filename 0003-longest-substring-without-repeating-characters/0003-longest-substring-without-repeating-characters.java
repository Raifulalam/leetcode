class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        int left=0;
        int maxLength=0;
        Map<Character,Integer> charMap=new HashMap<>();
        for(int right=0;right<len;right++){
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                charMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }
        return maxLength;
    }
}