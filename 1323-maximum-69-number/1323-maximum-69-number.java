class Solution {
    public int maximum69Number (int num) {
       
            String numString=String.valueOf(num);
            String ans=numString.replaceFirst("6","9");
            return Integer.parseInt(ans);

        
    }
}