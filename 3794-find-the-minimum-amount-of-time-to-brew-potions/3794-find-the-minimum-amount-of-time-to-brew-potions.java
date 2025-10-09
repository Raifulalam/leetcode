import java.util.*;

class Solution {
    public long minTime(int[] skill, int[] mana) {
        long sumSkill = 0;
        for (int s : skill) sumSkill += s;
       
        long prevWizardDone = sumSkill * mana[0];
        
        int n = skill.length;
        int m = mana.length;
        for (int j = 1; j < m; j++) {
           
            long prevPotionDone = prevWizardDone;
            for (int i = n - 2; i >= 0; i--) {
                prevPotionDone -= (long) skill[i + 1] * mana[j - 1];
                long candidate = prevWizardDone - (long) skill[i] * mana[j];
                prevWizardDone = Math.max(prevPotionDone, candidate);
            }
            prevWizardDone += sumSkill * mana[j];
        }
        
        return prevWizardDone;
    }
}
