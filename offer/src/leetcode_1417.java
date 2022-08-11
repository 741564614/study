public class leetcode_1417 {
    public static void main(String[] args) {
        String s="abc2123";
        System.out.println(reformat(s));
    }

    public static String reformat2(String s) {
        int sumDigit = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sumDigit++;
            }
        }
        int sumAlpha = s.length() - sumDigit;
        if (Math.abs(sumDigit - sumAlpha) > 1) {
            return "";
        }
        boolean flag = sumDigit > sumAlpha;
        char[] arr = s.toCharArray();
        for (int i = 0, j = 1; i < s.length(); i += 2) {
            if (Character.isDigit(arr[i]) != flag) {
                while (Character.isDigit(arr[j]) != flag) {
                    j += 2;
                }
                swap(arr, i, j);
            }
        }
        return new String(arr);
    }

    public static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }


    public static String reformat(String s) {
        if(s.length()==1){
            return s;
        }
        int num = 0;
        int letter = 0;
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                letter++;
            } else {
                num++;
            }
        }
        if (num == 0 || letter == 0||Math.abs((num - letter)) > 1  ) {
            return "";
        }
        char[] result = new char[s.length()];
        int i = 0;
        int j = 1;
        if (num > letter) {
            i = 1;
            j = 0;
        }
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result[i] = c;
                i += 2;
            } else {
                result[j] = c;
                j += 2;
            }
        }
        return new String(result);
    }
}
