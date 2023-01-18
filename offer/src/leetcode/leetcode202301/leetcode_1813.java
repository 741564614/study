package leetcode.leetcode202301;

public class leetcode_1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() == sentence2.length() && sentence1.equals(sentence2)) {
            return true;
        }
        String temp1 = sentence1.length() > sentence2.length() ? sentence1 : sentence2;
        String temp2 = sentence1.length() > sentence2.length() ? sentence2 : sentence1;

        int indexStart = temp1.indexOf(temp2);
        int indexEnd=temp1.lastIndexOf(temp2);

        if ((indexStart == 0 && temp1.charAt(indexStart + temp2.length()) == ' ') || (indexEnd + temp2.length() == temp1.length() && temp1.charAt(indexEnd - 1) == ' ')) {
            return true;
        }

        for (int i = 0; i < temp2.length(); i++) {
            if (temp2.charAt(i) == ' ') {
                String prefix = temp2.substring(0, i);
                String suffix = temp2.substring(i + 1);
                indexStart = temp1.indexOf(prefix);
                indexEnd = temp1.lastIndexOf(suffix);
                if ((indexStart == 0 && temp1.charAt(indexStart + prefix.length()) == ' ') && (indexEnd + suffix.length() == temp1.length() && temp1.charAt(indexEnd - 1) == ' ')) {
                    return true;
                }
            }
        }

        return false;
    }
}
