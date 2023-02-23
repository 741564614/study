package offer;

import java.util.Stack;

public class offer_33 {

    public static void main(String[] args) {
        int[] p = new int[]{179, 437, 1405, 5227, 8060, 8764, 8248, 4687, 3297, 13038, 12691, 15744, 16195, 15642, 19813, 17128, 21051, 20707, 22177, 21944, 23644, 23281, 19970, 23652, 26471, 31467, 33810, 32300, 33880, 27334, 25987, 35643, 35103, 36489, 42534, 42990, 42942, 37090, 36075, 34516, 16624, 11335, 10737, 44641, 45754, 47096, 46021, 49150, 48013, 49814, 51545, 52555, 50701, 47875, 56783, 57558, 53812, 62008, 61737, 63052, 63478, 62799, 59246, 64765, 64066, 63862, 65384, 67449, 66552, 57741, 45618, 44412, 667, 69718, 75519, 76819, 72971, 79319, 78145, 80615, 84280, 80984, 86598, 85903, 84334, 80867, 87993, 92361, 88465, 87738, 80364, 94380, 94446, 96785, 93694, 76847, 99655, 98675, 97001, 72112};
        System.out.println(new offer_33().verifyPostorder(p));
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        return dfs(postorder, 0, postorder.length - 2, postorder[postorder.length - 1]);
    }

    public boolean dfs(int[] postorder, int start, int end, int root) {
        if(start>end){
            return true;
        }
        int mid = end;
        while (mid >= 0 && postorder[mid] > root) {
            mid--;
        }
        for (int i = start; i <= mid; i++) {
            if (postorder[i] > root) {
                return false;
            }
        }
        return (mid < 0 || dfs(postorder, start, mid - 1, postorder[mid])) && dfs(postorder, mid + 1, end - 1, postorder[end]);
    }

    public boolean verifyPostorder02(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
}
