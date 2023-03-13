package leetcode.leetcode202303;

public class leetcode_2383 {
    public static void main(String[] args) {
        //1
        //1
        //[1,1,1,1]
        //[1,1,1,50]
        int[] energy = new int[]{1, 1, 1, 1};
        int[] experience = new int[]{1, 1, 1, 50};
        System.out.println(new leetcode_2383().minNumberOfHours(1, 1, energy, experience));
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        int needEnergy = 1, needExp = 0;
        for (int e : energy) {
            needEnergy += e;
        }
        ans += Math.max(0, needEnergy - initialEnergy);
        for (int e : experience) {
            if (initialExperience > e) {
                initialExperience += e;
            } else {
                needExp += (e - initialExperience + 1);
                initialExperience = 2 * e + 1;
            }
        }
        ans += needExp;
        return ans;
    }

}
