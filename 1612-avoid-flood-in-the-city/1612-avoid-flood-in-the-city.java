class Solution {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length;
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        Map<Integer,Integer> lakeIdToFullDay=new HashMap<>();
        TreeSet<Integer> emptyDays = new TreeSet<>();
        for(int i=0;i<n;i++){
            final int lakeId = rains[i];
             if (lakeId == 0) {
                emptyDays.add(i);
                    continue;
            }
            if (lakeIdToFullDay.containsKey(lakeId)) {
                final int fullDay = lakeIdToFullDay.get(lakeId);
                Integer emptyDay = emptyDays.higher(fullDay);
                        if (emptyDay == null)
                                  return new int[] {};
                                ans[emptyDay] = lakeId;
                                emptyDays.remove(emptyDay);
            }
                         lakeIdToFullDay.put(lakeId, i);
        }
            for (final int emptyDay : emptyDays)
                  ans[emptyDay] = 1;
            return ans;
    
    }
}