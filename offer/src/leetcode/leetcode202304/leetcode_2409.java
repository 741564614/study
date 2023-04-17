package leetcode.leetcode202304;

public class leetcode_2409 {

    public static void main(String[] args) {

        System.out.println(new leetcode_2409().countDaysTogether("08-15",
                "08-18",
                "08-16",
                "08-16"));
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String arrive = arriveAlice.compareTo(arriveBob) >= 0 ? arriveAlice : arriveBob;
        String leave = leaveAlice.compareTo(leaveBob) >= 0 ? leaveBob : leaveAlice;
        if (arrive.compareTo(leave) > 0) {
            return 0;
        }
        return differ(arrive, leave);
    }


    public int differ(String a, String b) {
        if (a.compareTo(b) == 0) {
            return 1;
        }
        int[] month = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] splitA = a.split("-");
        String[] splitB = b.split("-");
        int aM = Integer.parseInt(splitA[0]);
        int bM = Integer.parseInt(splitB[0]);
        int aD = Integer.parseInt(splitA[1]);
        int bD = Integer.parseInt(splitB[1]);
        int ans = 0;
        if (aM == bM) {
            return Math.abs(aD - bD) + 1;
        } else if (aM < bM) {
            ans += (month[aM - 1] - aD + 1);
            for (int i = aM; i < bM - 1; i++) {
                ans += month[i];
            }
            ans += bD;
        } else {
            ans += (month[bM - 1] - bD + 1);
            for (int i = bM; i < aM - 1; i++) {
                ans += month[i];
            }
            ans += aD;
        }
        return ans;
    }
}
