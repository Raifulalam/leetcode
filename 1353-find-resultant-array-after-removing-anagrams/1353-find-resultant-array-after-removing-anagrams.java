class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list=new ArrayList<>();
        list.add(words[0]);
      
        for(int i=1;i<words.length;i++){
            String prev=words[i-1];
            String curr=words[i];
            if (!isAnagram(prev, curr)) {
                list.add(curr);
            }   
        }
        return list;
    }
    private boolean isAnagram(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        char[] a=s1.toCharArray();
        char[] b=s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);

    }
}