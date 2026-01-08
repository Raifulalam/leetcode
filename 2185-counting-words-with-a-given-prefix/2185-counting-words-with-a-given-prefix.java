class Solution {
    public int prefixCount(String[] words, String pref) {
        int count=0;
        for(String word:words){
            String sub="";
            if(word.length()>=pref.length()){
                sub=word.substring(0,pref.length());
            }
            
            if(sub.equals(pref)){
                count++;
            }
        }
        return count;
    }
}