package leetcode.leetcode202304;

import java.util.*;
import java.util.Map;

public class leetcode_2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        Integer[] index = new Integer[names.length];
        for (int i = 0; i < names.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> heights[b] - heights[a]);
        String[] ans = new String[names.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = names[index[i]];
        }
        return ans;
    }

    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            quickSort(names, heights,0,heights.length-1);
            return names;
        }
        public void quickSort(String[] names, int[] heights, int lo, int hi){
            if(lo >= hi){
                return;
            }
            int i = lo;
            int j = hi;
            while(i<j){
                while(i<j && heights[j]<=heights[lo]){j--;}
                while(i<j && heights[i]>=heights[lo]){i++;}
                swap(names,heights,i,j);
            }
            swap(names,heights,i,lo);
            quickSort(names,heights,lo,i-1);
            quickSort(names,heights,i+1,hi);
        }
        public void swap(String[] names, int[] heights, int lo, int hi){
            String str_tmp = names[lo];
            int num_tmp = heights[lo];
            names[lo] = names[hi];
            heights[lo] = heights[hi];
            names[hi] = str_tmp;
            heights[hi] = num_tmp;
        }
    }
}
