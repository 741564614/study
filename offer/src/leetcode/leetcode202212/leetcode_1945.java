package leetcode.leetcode202212;

public class leetcode_1945 {
    public static void main(String[] args) {
        System.out.println(new leetcode_1945().getLucky("iiii",1));
    }
    public int getLucky(String s, int k) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : s.toCharArray()) {
            stringBuffer.append(c - 'a' + 1);
        }
        String w = stringBuffer.toString();
        for (int i = 0; i < k; i++) {
            w = change(w);
        }
        return Integer.parseInt(w);
    }

    public String change(String value) {
        if (value.length() < 1) {
            return value;
        }
        int ans = 0;
        for (char c : value.toCharArray()) {
            ans += (c - '0');
        }
        return String.valueOf(ans);
    }

    public int getLucky02(String s, int k) {
        int ret = 0; char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            int x=arr[i]-'a'+1; ret+=x%10+x/10;
        }
        for(int j=1;j<k;j++){
            int temp=ret; ret=0;
            while(temp!=0){ ret+=temp%10; temp/=10;}

        }
        return ret;
    }
}
