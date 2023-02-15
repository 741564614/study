package offer;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static leetcode.TreeNode.gen;

public class offer_26 {

    public static void main(String[] args) {
        int[] a = new int[]{4, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = new int[]{4, 8, 9};
        TreeNode A = gen(a);
        TreeNode B = gen(b);
        System.out.println(new offer_26().isSubStructure(A, B));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        List<TreeNode> startList = new ArrayList<>();
        getStart(startList, A, B.val);
        if (startList.isEmpty()) {
            return false;
        }
        for (TreeNode start : startList) {
            if (equals(start, B)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSubStructure20(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (equals(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }


    public boolean equals(TreeNode A, TreeNode B) {
        if (A != null && B != null && A.val == B.val) {
            return equals(A.left, B.left) && equals(A.right, B.right);
        }
        return B == null;
    }

    public void getStart(List<TreeNode> startList, TreeNode A, int target) {
        if (A == null) {
            return;
        }
        if (A.val == target) {
            startList.add(A);
        }
        getStart(startList, A.left, target);
        getStart(startList, A.right, target);
    }
}
