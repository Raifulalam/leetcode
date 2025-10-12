class Solution {
    static final int MOD = 1_000_000_007;

    public int magicalSum(int m, int k, int[] nums) {   // ✅ fixed name + parameter order
        int n = nums.length;

        long[] fact = new long[m + 1];
        long[] invFact = new long[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[m] = modInv(fact[m]);
        for (int i = m; i >= 1; i--) invFact[i - 1] = invFact[i] * i % MOD;

        class Comb {
            long comb(int a, int b) {
                if (b < 0 || b > a) return 0;
                return fact[a] * invFact[b] % MOD * invFact[a - b] % MOD;
            }
        }
        Comb C = new Comb();

        long[][] powNums = new long[n][m + 1];
        for (int b = 0; b < n; b++) {
            powNums[b][0] = 1;
            for (int x = 1; x <= m; x++)
                powNums[b][x] = powNums[b][x - 1] * nums[b] % MOD;
        }

        int maxBit = n + 5;
        Map<State, Long> dp = new HashMap<>();
        dp.put(new State(0, 0, 0), 1L);

        for (int b = 0; b < maxBit; b++) {
            Map<State, Long> next = new HashMap<>();
            for (var e : dp.entrySet()) {
                State st = e.getKey();
                long prodSum = e.getValue();
                if (st.bitsSet > k || st.used > m) continue;

                if (b < n) {
                    for (int x = 0; x <= m - st.used; x++) {
                        int sumOnes = x + st.carry;
                        int bitVal = sumOnes & 1;
                        int newBits = st.bitsSet + bitVal;
                        int newCarry = sumOnes >> 1;
                        long ways = C.comb(m - st.used, x) * powNums[b][x] % MOD;
                        long newProd = prodSum * ways % MOD;
                        State ns = new State(newCarry, st.used + x, newBits);
                        next.merge(ns, newProd, (a, b2) -> (a + b2) % MOD);
                    }
                } else {
                    int sumOnes = st.carry;
                    int bitVal = sumOnes & 1;
                    int newBits = st.bitsSet + bitVal;
                    int newCarry = sumOnes >> 1;
                    State ns = new State(newCarry, st.used, newBits);
                    next.merge(ns, prodSum, (a, b2) -> (a + b2) % MOD);
                }
            }
            dp = next;
        }
        State target = new State(0, m, k);
        return dp.getOrDefault(target, 0L).intValue();
    }

    private long modInv(long x) { return modPow(x, MOD - 2); }
    private long modPow(long x, long e) {
        long res = 1;
        x %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) res = res * x % MOD;
            x = x * x % MOD;
            e >>= 1;
        }
        return res;
    }

    static class State {
        int carry, used, bitsSet;
        State(int c, int u, int b) { carry = c; used = u; bitsSet = b; }
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State)) return false;
            State s = (State) o;
            return carry == s.carry && used == s.used && bitsSet == s.bitsSet;
        }
        public int hashCode() { return Objects.hash(carry, used, bitsSet); }
    }
}
