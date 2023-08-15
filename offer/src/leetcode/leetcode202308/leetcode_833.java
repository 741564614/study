package leetcode.leetcode202308;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

public class leetcode_833 {

    public static void main(String[] args) {
        String s = "mhnbzxkwzxtaanmhtoirxheyanoplbvjrovzudznmetkkxrdmr";
        int[] in = new int[]{46, 29, 2, 44, 31, 26, 42, 9, 38, 23, 36, 12, 16, 7, 33, 18};
        String[] source = new String[]{"rym", "kv", "nbzxu", "vx", "js", "tp", "tc", "jta", "zqm", "ya", "uz", "avm", "tz", "wn", "yv", "ird"};
        String[] targets = new String[]{"gfhc", "uq", "dntkw", "wql", "s", "dmp", "jqi", "fp", "hs", "aqz", "ix", "jag", "n", "l", "y", "zww"};
        System.out.println(new leetcode_833().findReplaceString(s, in, source, targets));
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            indexMap.put(indices[i], i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            if (indexMap.containsKey(i) && s.substring(i, i + sources[indexMap.get(i)].length()).equals(sources[indexMap.get(i)])) {
                sb.append(targets[indexMap.get(i)]);
                i += sources[indexMap.get(i)].length();
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
}
