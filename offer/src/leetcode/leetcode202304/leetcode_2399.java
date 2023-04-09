package leetcode.leetcode202304;

public class leetcode_2399 {
    public boolean checkDistances(String s, int[] distance) {
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int cIndex = s.charAt(i) - 'a';
            if (index[cIndex] == 0) {
                index[cIndex] = i + 1;
            } else {
                if (i - index[cIndex] != distance[cIndex]) {
                    return false;
                }
            }
        }
        return true;
    }
}
