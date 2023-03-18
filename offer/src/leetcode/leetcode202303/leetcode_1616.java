package leetcode.leetcode202303;

public class leetcode_1616 {

    public static void main(String[] args) {
        String a = "ulacfd";
        String b = "jizalu";
        System.out.println(new leetcode_1616().checkPalindromeFormation(a, b));
    }

    public boolean checkPalindromeFormation(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int len = a.length();
        if (check(charsA, 0, len - 1) || check(charsB, 0, len - 1)) {
            return true;
        }
        return check(charsA, charsB) || check(charsB, charsA);
    }

    public boolean check(char[] charsA, char[] charsB) {
        int l = 0, r = charsA.length - 1;
        while (l < r && charsA[l] == charsB[r]) {
            l++;
            r--;
        }
        if (l >= r) {
            return true;
        }
        int nextL = l, nextR = r;
        while (nextL < r && charsB[nextL] == charsB[r]) {
            nextL++;
            r--;
        }
        if (nextL >= r) {
            return true;
        }
        while (l < nextR && charsA[l] == charsA[nextR]) {
            l++;
            nextR--;
        }
        return l >= nextR;
    }

    public boolean check(char[] chars, int l, int r) {
        while (l < r && chars[l] == chars[r]) {
            l++;
            r--;
        }
        return l >= r;
    }

    class Solution {
        public boolean checkPalindromeFormation(String a, String b) {
            return checkConcatenation(a, b) || checkConcatenation(b, a);
        }

        public boolean checkConcatenation(String a, String b) {
            int n = a.length();
            int left = 0, right = n - 1;
            while (left < right && a.charAt(left) == b.charAt(right)) {
                left++;
                right--;
            }
            if (left >= right) {
                return true;
            }
            return checkSelfPalindrome(a, left, right) || checkSelfPalindrome(b, left, right);
        }

        public boolean checkSelfPalindrome(String a, int left, int right) {
            while (left < right && a.charAt(left) == a.charAt(right)) {
                left++;
                right--;
            }
            return left >= right;
        }
    }
}
