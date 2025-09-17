class Solution {
    public boolean doesAliceWin(String s) {
       String vowels="aeiou";
       for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(vowels.indexOf(ch)!=-1){
            return true;
        }
       }
       return false;
    }
}