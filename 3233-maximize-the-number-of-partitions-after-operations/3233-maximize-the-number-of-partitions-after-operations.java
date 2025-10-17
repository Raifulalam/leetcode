
public class Solution {
    private String s;
    private int k, n;
    private Map<String, Integer> memo;

    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.k = k;
        this.n = s.length();
        this.memo = new HashMap<>();
        return dp(0, false, 0) + 1; // +1 for the first partition
    }

    private int dp(int i, boolean usedChange, int mask) {
        if (i == n) return 0;

        String key = i + "," + usedChange + "," + mask;
        if (memo.containsKey(key)) return memo.get(key);

        int res = 0;
        int c = s.charAt(i) - 'a';
        int bitC = 1 << c;
        int distinct = Integer.bitCount(mask);

        // Option 1: keep s[i] as-is
        if ((mask & bitC) != 0) {
            // already in mask
            res = Math.max(res, dp(i + 1, usedChange, mask));
        } else {
            if (distinct < k) {
                // add to current mask
                res = Math.max(res, dp(i + 1, usedChange, mask | bitC));
            } else {
                // start new partition with just this character
                res = Math.max(res, 1 + dp(i + 1, usedChange, bitC));
            }
        }

        // Option 2: change s[i] to another letter (only if change not yet used)
        if (!usedChange) {
            // Try changing s[i] to each possible character (a-z)
            for (int x = 0; x < 26; x++) {
                int bitX = 1 << x;
                if ((mask & bitX) != 0) {
                    // no new distinct, safe to continue
                    res = Math.max(res, dp(i + 1, true, mask));
                } else {
                    if (distinct < k) {
                        // room to add a new character to current mask
                        res = Math.max(res, dp(i + 1, true, mask | bitX));
                    } else {
                        // mask is full, must cut here
                        res = Math.max(res, 1 + dp(i + 1, true, bitX));
                    }
                }
            }
        }

        memo.put(key, res);
        return res;
    }
}
