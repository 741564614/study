package leetcode.leetcode202302;

public class leetcode_1255 {

    public static void main(String[] args) {
        String[] words = new String[]{"dog", "cat", "dad", "good"};
        char[] letters = new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] score = new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(new leetcode_1255().maxScoreWords(words, letters, score));
    }

    int max = 0;
    int len;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        len = words.length;
        int[] wordScore = new int[len];
        int[][] wordCost = new int[len][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                wordScore[i] += score[c - 'a'];
                wordCost[i][c - 'a']++;
            }
        }

        int[] letterCount = new int[26];
        for (char letter : letters) {
            letterCount[letter - 'a']++;
        }

        dfs(wordScore, wordCost, letterCount, 0, 0);
        return max;
    }

    public void dfs(int[] wordScore, int[][] wordCost, int[] letterCount, int total, int index) {
        for (int i = index; i < len; i++) {
            if (canCost(letterCount, wordCost[i])) {
                total += wordScore[i];
                max = Math.max(max, total);
                cost(letterCount, wordCost[i], false);
                dfs(wordScore, wordCost, letterCount, total, i + 1);
                cost(letterCount, wordCost[i], true);
                total -= wordScore[i];
            }
        }
    }

    public boolean canCost(int[] letterCount, int[] wordCost) {
        for (int i = 0; i < 26; i++) {
            if (letterCount[i] < wordCost[i]) {
                return false;
            }
        }
        return true;
    }

    public void cost(int[] letterCount, int[] wordCost, boolean isReturn) {
        for (int i = 0; i < 26; i++) {
            letterCount[i] += isReturn ? wordCost[i] : -wordCost[i];
        }
    }
}
