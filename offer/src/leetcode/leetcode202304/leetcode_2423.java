package leetcode.leetcode202304;

import java.util.*;
import java.util.Map;

public class leetcode_2423 {

    public static void main(String[] args) {
        System.out.println(new leetcode_2423().equalFrequency("abc"));
    }

    public boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        int moreCnt = 0, count = 0;
        int[] upCnt = new int[101];
        for (int i : cnt) {
            if (i != 0) {
                upCnt[i]++;
                count++;
            }
        }

        for (int i = 0; i < upCnt.length; i++) {
            if (upCnt[i] == count - 1) {
                moreCnt = i;
                break;
            }
        }

        return count == 1 || upCnt[1] == count || (moreCnt != 0 && (upCnt[1] == 1 || (moreCnt + 1 < upCnt.length && upCnt[moreCnt + 1] == 1)));
    }


    class Solution {
        public boolean equalFrequency(String word) {
            int[] charCount = new int[26];
            int n = word.length();
            for (int i = 0; i < n; i++) {
                charCount[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (charCount[i] == 0) {
                    continue;
                }
                charCount[i]--;
                HashSet<Integer> frequency = new HashSet<Integer>();
                for (int f : charCount) {
                    if (f > 0) {
                        frequency.add(f);
                    }
                }
                if (frequency.size() == 1) {
                    return true;
                }
                charCount[i]++;
            }
            return false;
        }
    }
}
