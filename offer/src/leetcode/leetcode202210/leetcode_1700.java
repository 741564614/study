package leetcode.leetcode202210;

public class leetcode_1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int ans=0;
        int[] count=new int[2];
        for (int student : students) {
            count[student]++;
        }
        for (int sandwich : sandwiches) {
            if(count[sandwich]>0){
                count[sandwich]--;
                ans++;
            }else{
                break;
            }
        }
        return sandwiches.length-ans;
    }
}
