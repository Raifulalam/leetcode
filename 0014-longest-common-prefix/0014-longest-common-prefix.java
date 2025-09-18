class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        String fst=strs[0];
        for(int i=1;i<strs.length;i++){
            while(!strs[i].startsWith(fst)){
                fst=fst.substring(0,fst.length()-1);
            }
            if(fst.isEmpty()){
                return "";
            }
        }
        return fst;
    }
}