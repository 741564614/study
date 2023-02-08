package leetcode.leetcode202302;

import java.util.*;

public class leetcode_1604 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> result = new ArrayList<>();

        Map<String, LinkedList<String>> limitTimeMap = new HashMap<>();

        int n = keyName.length;

        Integer[] indexs = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexs[i] = i;
        }

        Arrays.sort(indexs, Comparator.comparing(a -> keyTime[a]));

        for (int j = 0; j < n; j++) {
            int i = indexs[j];
            if (limitTimeMap.containsKey(keyName[i]) && keyTime[i].compareTo(limitTime(limitTimeMap.get(keyName[i]).getFirst())) <= 0) {
                limitTimeMap.get(keyName[i]).add(keyTime[i]);
                if (limitTimeMap.get(keyName[i]).size() >= 3) {
                    result.add(keyName[i]);
                    limitTimeMap.remove(keyName[i]);
                }
            } else {
                if (!result.contains(keyName[i])) {
                    limitTimeMap.putIfAbsent(keyName[i], new LinkedList<>());
                    limitTimeMap.get(keyName[i]).addLast(keyTime[i]);
                    while (keyTime[i].compareTo(limitTime(limitTimeMap.get(keyName[i]).getFirst())) >= 0) {
                        limitTimeMap.get(keyName[i]).removeFirst();
                    }
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    public String limitTime(String time) {
        Integer value = Integer.parseInt(time.substring(0, 2)) + 1;
        return (value < 10 ? "0" + value : value) + time.substring(2);
    }

    public List<String> alertNames02(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> timeMap = new HashMap<String, List<Integer>>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            timeMap.putIfAbsent(name, new ArrayList<Integer>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            timeMap.get(name).add(hour * 60 + minute);
        }
        List<String> res = new ArrayList<String>();
        Set<String> keySet = timeMap.keySet();
        for (String name : keySet) {
            List<Integer> list = timeMap.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                int time1 = list.get(i - 2), time2 = list.get(i);
                int difference = time2 - time1;
                if (difference <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
