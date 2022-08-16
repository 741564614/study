import java.util.ArrayList;
import java.util.List;

public class leetcode_1656 {
    public static void main(String[] args) {

    }

    class OrderedStream {
        int pre;
        String[] values;

        public OrderedStream(int n) {
            values = new String[n];
            pre = 0;
        }

        public List<String> insert(int idKey, String value) {
            values[idKey - 1] = value;
            List<String> result = new ArrayList<>();
            if (idKey - 1 == pre) {
                while (pre < values.length && values[pre] != null) {
                    result.add(values[pre++]);
                }
            }
            return result;
        }
    }

}
