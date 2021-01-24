package 剑指Offer复习;/* 2020/10/31 23:52 */

import Nodes.TreeNode;
import org.junit.Test;

public class _26_树的子结构 {//
    @Test
    public void t2() {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);
        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(1);
        System.out.println(isSubStructure(A, B));//true
    }

    @Test
    public void t() {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right= new TreeNode(3);
        TreeNode B = new TreeNode(3);
        B.right = new TreeNode(1);
        System.out.println(isSubStructure(A, B));//false
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //空树不是任意树的子树
        if (A == null || B == null) return false;
        return equals(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean equals(TreeNode A, TreeNode B) {
        //假设根节点相同，子树先到达终点，母树后遍历完
        if (B == null) return true;
        if (A == null) return false;
        return A.val == B.val && equals(A.left, B.left) && equals(A.right, B.right);
    }
}
