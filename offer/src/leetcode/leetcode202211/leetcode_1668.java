package leetcode.leetcode202211;

public class leetcode_1668 {
    public int maxRepeating(String sequence, String word) {
        int max = sequence.length() / word.length();
        for (int i = max; i > 0; i--) {
            StringBuilder stringBuffer = new StringBuilder();
            for (int j = 0; j < i; j++) {
                stringBuffer.append(word);
            }
            if (sequence.contains(stringBuffer.toString())) {
                return i;
            }
        }
        return 0;
    }

    public int maxRepeating02(String sequence, String word) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(word);
        int ans=0;
        while (sequence.contains(stringBuffer.toString())){
            stringBuffer.append(word);
            ans++;
        }
        return ans;
    }
}
