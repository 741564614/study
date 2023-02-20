package leetcode.leetcode202302;

public class leetcode_2347 {
    public String bestHand(int[] ranks, char[] suits) {
        int[] rankCount = new int[14];
        int[] suitCount = new int[5];

        int suitMax = 0;
        for (char suit : suits) {
            suitCount[suit - 'a']++;
            suitMax = Math.max(suitMax, suitCount[suit - 'a']);
        }

        if (suitMax == 5) {
            return "Flush";
        }

        int max = 0;

        for (int rank : ranks) {
            rankCount[rank]++;
            max = Math.max(max, rankCount[rank]);
        }
        return max >= 3 ? "Three of a Kind" : max == 2 ? "Pair" : "High Card";
    }
}
