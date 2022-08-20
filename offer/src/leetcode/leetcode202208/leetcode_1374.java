package leetcode.leetcode202208;

import java.util.Arrays;

public class leetcode_1374 {
    public static void main(String[] args) {
        System.out.println(generateTheString(5));
    }
    public static String generateTheString(int n) {
        char[] value=new char[n];
        Arrays.fill(value,'a');
        if((n&1)!=1){
            value[n-1]='b';
        }
        return new String(value);
    }
}
