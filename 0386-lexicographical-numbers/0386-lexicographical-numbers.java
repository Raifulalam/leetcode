class Solution {
    public List<Integer> lexicalOrder(int n) {
       List<String> strNums=new ArrayList<>();
       for(int i=1;i<=n;i++){
            strNums.add(String.valueOf(i));
       }
       List<Integer> ans=new ArrayList<>();
       Collections.sort(strNums);
       for(String s:strNums){
            ans.add(Integer.parseInt(s));
       }
       return ans;
    }
    
}