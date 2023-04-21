package leetcode.leetcode202304;

public class leetcode_2413 {
    public int smallestEvenMultiple(int n) {
        if(n%2==0){
            return n;
        }
        return n*2;
    }

    // java
    class Solution {
        public int smallestEvenMultiple(int n) {
            // return (n & 1) == 0 ? n : (n << 1);
            return n << (n & 1);
        }
    }
}
