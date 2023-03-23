package offer;

import java.util.ArrayList;
import java.util.List;

public class offer_62 {
    public int lastRemaining20(int n, int m) {
        boolean[] check = new boolean[n];
        int last = 0, count = n;
        while (count > 0) {
            int cur = 0;
            while (cur < m) {
                if (!check[last]) {
                    cur++;
                }
                if (cur < m) {
                    last = (last + 1) % n;
                }
            }
            check[last] = true;
            count--;
        }
        return last;
    }

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() != 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public int lastRemaining02(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
