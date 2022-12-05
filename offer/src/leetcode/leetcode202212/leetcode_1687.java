package leetcode.leetcode202212;

public class leetcode_1687 {
    public int boxDelivering02(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        var n = boxes.length;
        var f = new int[n + 1];
        f[1] = 2;
        var diffSum = 2;
        var weightSum = boxes[0][1];
        var left = 0;
        for (int i = 1; i < n; ++i) {
            weightSum += boxes[i][1];
            if (boxes[i][0] != boxes[i - 1][0]) diffSum++;
            while (weightSum > maxWeight || i - left + 1 > maxBoxes || f[left + 1] == f[left]) {
                weightSum -= boxes[left++][1];
                if (boxes[left][0] != boxes[left - 1][0]) --diffSum;
            }
            f[i + 1] = f[left] + diffSum;
        }
        return f[n];
    }
}
