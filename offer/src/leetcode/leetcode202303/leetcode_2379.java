package leetcode.leetcode202303;

import java.util.ArrayList;
import java.util.List;

public class leetcode_2379 {

    public static void main(String[] args) {
        String s = "WBBWWBBWBW";
        System.out.println(new leetcode_2379().minimumRecolors(s, 7));
    }

    public int minimumRecolors(String blocks, int k) {
        List<Integer> blockColors = new ArrayList<>();
        List<Integer> blockNum = new ArrayList<>();
        char[] chars = blocks.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int start = i;
            while (i + 1 < chars.length && chars[i + 1] == chars[i]) {
                i++;
            }
            blockColors.add(chars[i] == 'W' ? 0 : 1);
            blockNum.add(i - start + 1);
            if (chars[i] == 'B' && (i - start + 1) >= k) {
                return 0;
            }
        }
        int ans = k;
        for (int i = 0; i < blockColors.size(); i++) {
            if (blockColors.get(i) == 1) {
                int nowNum = blockNum.get(i);
                int index = i + 2, cost = 0;
                while (index < blockColors.size() && nowNum < k) {
                    ans = Math.min(ans, k - nowNum + cost);
                    cost += blockNum.get(index - 1);
                    nowNum += (blockNum.get(index - 1) + blockNum.get(index));
                    index += 2;
                }
                ans = Math.min(ans, Math.max(k - nowNum, 0) + cost);
            }
        }
        return ans;
    }

    public int minimumRecolors202(String blocks, int k) {
        int wNum = 0, l = 0, r = 0, ans = k;
        char[] chars = blocks.toCharArray();
        while (r < k) {
            if (chars[r] == 'W') {
                wNum++;
            }
            r++;
        }
        ans = Math.min(ans, wNum);
        while (r < blocks.length()) {
            if(chars[r++]=='W'){
                wNum++;
            }
            if(chars[l++]=='W'){
                wNum--;
            }
            ans = Math.min(ans, wNum);
        }
        return ans;
    }
}
