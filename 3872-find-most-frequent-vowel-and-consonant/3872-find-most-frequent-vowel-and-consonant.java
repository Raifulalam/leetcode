class Solution {
    public int maxFreqSum(String s) {
        String vowels="aeiou";
        int[] count=new int[26];
        int maxConst=0;
        int maxVowel=0;
        for(char ch:s.toCharArray()){
            ++count[ch-'a'];
        }
        for(char ch:s.toCharArray()){
            if(isVowel(ch)){
                maxVowel=Math.max(maxVowel,count[ch-'a']);
            }else{
                maxConst=Math.max(maxConst,count[ch-'a']);
            }
        }
        return maxVowel+maxConst;
    }
     private boolean isVowel(char c) {
            return "aeiou".indexOf(c) != -1;
              }
     
}