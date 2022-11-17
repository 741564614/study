package leetcode.leetcode202211;

import java.util.ArrayList;

public class leetcode_792 {
    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<Integer>[] index = new ArrayList[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index[c - 'a'] == null) {
                index[c - 'a'] = new ArrayList<>();
            }
            index[c - 'a'].add(i);
        }
        int ans = 0;
        for (String word : words) {
            if (check(index, word)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean check(ArrayList<Integer>[] index, String word) {
        int j = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (index[c - 'a'] == null || index[c - 'a'].size() == 0) {
                return false;
            }
            int temp = leftBound(index[c - 'a'], j);
            if (temp == -1) {
                return false;
            }
            j = index[c - 'a'].get(temp) + 1;
        }
        return true;
    }

    public int leftBound(ArrayList<Integer> index, int target) {
        int left = 0, right = index.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > index.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == index.size()) {
            return -1;
        }
        return left;
    }
}
