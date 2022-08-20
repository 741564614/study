package leetcode.leetcode202208;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_1282 {
    public static void main(String[] args) {
        int[] groupSizes = new int[]{3, 3, 3, 3, 3, 1, 3};
        System.out.println(groupThePeople(groupSizes));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> keyMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int value = groupSizes[i];
            if (!keyMap.containsKey(value)) {
                keyMap.put(value, new ArrayList<>());
            }
            List<Integer> list = keyMap.get(value);
            list.add(i);
            if (list.size() == value) {
                result.add(new ArrayList<>(list));
                keyMap.put(value, new ArrayList<>());
            }
        }
        return result;
    }

    public static List<List<Integer>> groupThePeople2(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<groupSizes.length;i++){
            if(groupSizes[i]!=0){
                List<Integer> list = new ArrayList<>();
                int temp=groupSizes[i];
                list.add(i);
                temp--;
                for(int j=i+1;j<groupSizes.length&&temp >0;j++){
                    if(groupSizes[j]==groupSizes[i]){
                        list.add(j);
                        temp--;
                        groupSizes[j]=0;
                    }

                }
                ans.add(list);
            }
        }
        return ans;
    }
}
