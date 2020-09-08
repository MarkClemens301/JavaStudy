package 剑指Offer复习;/* 2020/9/9 1:01 */

import Leetcode.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _07重建二叉树 {
    @Test
    public void test1() {
        int[] pre = new int[]{3, 9, 20, 15, 7}, in = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildTree(pre, in);
        System.out.println("root = "
                + "\n" + root.val
                + "\n" + root.left.val
                + "+" + root.right.val
                + "\t\n#+#+" + root.right.left.val
                + "+" + root.right.right.val
        );
    }

    //class TreeNode {
    //    int val = 0;
    //    TreeNode left = null;
    //    TreeNode right = null;
    //
    //    TreeNode(int val) {
    //        this.val = val;
    //    }
    //}

    private int[] preorder;
    private Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inrder) {
        this.preorder = preorder;
        inMap = new HashMap<>();
        for (int i = 0; i < inrder.length; i++) {
            inMap.put(inrder[i], i);
        }
        return buildTree(0, preorder.length - 1, 0, inrder.length - 1);
    }

    private TreeNode buildTree(int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) return null;
        int val = preorder[preL];//前序索引2节点值
        int pivot = inMap.get(val);//节点值2中序索引
        TreeNode root = new TreeNode(val);
        root.left = buildTree(preL + 1, preL + (pivot - inL), inL, pivot - 1);
        root.right = buildTree(preL + (pivot - inL) + 1, preR, pivot + 1, inR);
        return root;//
    }
}
