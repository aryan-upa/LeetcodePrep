class Solution {
    public int bestClosingTime(String customers) {
        int curPenalty = 0;

        for (int i = 0; i < customers.length(); i++)
            if (customers.charAt(i) == 'Y')
                curPenalty++;

        int minPenalty = curPenalty;
        int earliestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i);
            
            curPenalty += ch == 'Y' ? -1 : 1;
            
            if (curPenalty < minPenalty) {
                earliestHour = i + 1;
                minPenalty = curPenalty;
            }
        }

        return earliestHour;
    }
}