class Solution {
    public String findLexSmallestString(String s, int a, int b) {
       Queue<String>q=new LinkedList<>();
       Set<String> visited=new HashSet<>();
       String smallest=s;
        visited.add(s);
        q.offer(s);
        while(!q.isEmpty()){
            String curr=q.poll();
            if(curr.compareTo(smallest)<0){
                smallest=curr;
            }
            char[] chars=curr.toCharArray();
            for(int i=1;i<chars.length;i+=2){
                chars[i]=(char)((chars[i]-'0'+a)%10+'0');
            }
            String str=new String(chars);
            if(visited.add(str)){
                q.offer(str);
            }
            String rotated=curr.substring(curr.length()-b)+curr.substring(0,curr.length()-b);
            if(visited.add(rotated)){
                q.offer(rotated);
            }

        }


        return smallest;
    }
}