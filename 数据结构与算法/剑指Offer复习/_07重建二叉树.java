package 剑指Offer复习;/* 2020/9/9 1:01 */

import Node.TreeNode;
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

    private int[] preOrder;
    private Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {//保证输入合理
        //preOrder 全局
        this.preOrder = preOrder;
        //inOrder val-place映射
        inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }
        //递归
        return buildTree(0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    /*
    提纲：
    val pL.. ..pR
    iL.. pivot ..iR
     */
    private TreeNode buildTree(int pL, int pR, int iL, int iR) {
        //终止条件
        if (pL > pR || iL > iR) {
            return null;
        }
        //根节点
        int val = preOrder[pL];//前序位置2val
        int pivot = inMap.get(val);//val2中序位置
        TreeNode root = new TreeNode(val);
        //左子树、右子树
        root.left = buildTree(pL + 1, pL + (pivot - iL), iL, pivot - 1);
        root.right = buildTree(pL + (pivot - iL) + 1, pR, pivot + 1, iR);
        //返回
        return root;
    }
}
