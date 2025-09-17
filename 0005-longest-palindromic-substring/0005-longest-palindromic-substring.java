class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n<1 || s==null) return "";
        int start=0, end=0;
        for(int i=0;i<n;i++){
            int len1=eac(s,i,i);
            int len2=eac(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>end-start){
                 start = i - (len - 1) / 2;
                 end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private int eac(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}