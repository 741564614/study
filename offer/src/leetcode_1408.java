import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class leetcode_1408 {
    public static void main(String[] args) {
        String[] words = new String[]{"mass", "as", "hero", "superhero"};
        System.out.println(stringMatching(words));
    }

    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    public static List<String> stringMatching2(String[] words) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i] + ",");
        }
        String s = sb.toString();
        for (int i = 0; i < words.length; i++) {
            if (sb.indexOf(words[i]) != sb.lastIndexOf(words[i])) {
                res.add(words[i]);
            }
        }
        return res;
    }
}
