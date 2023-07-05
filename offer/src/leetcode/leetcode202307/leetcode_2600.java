package leetcode.leetcode202307;

public class leetcode_2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        return numOnes + numZeros >= k ? Math.min(k, numOnes) : numOnes - (k - numOnes - numZeros);
    }
}
