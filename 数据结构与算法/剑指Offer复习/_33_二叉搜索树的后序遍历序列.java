package 剑指Offer复习;/* 2020/12/29 10:37 */
/*
// 参考以下这颗二叉搜索树：
//
//      5
//    / \
//   2   6
//  / \
// 1   3
//
// 示例 1：
//
// 输入: [1,6,3,2,5]
//输出: false
//
// 示例 2：
//
// 输入: [1,3,2,6,5]
//输出: true
 */

import org.junit.Test;

import java.util.*;//

public class _33_二叉搜索树的后序遍历序列 {//判断是否是后续遍历序列，前提【二叉搜索树】

    @Test
    public void t() {
        System.out.println(verifyPostOrder(new int[]{1, 6, 3, 2, 5}));//X
        System.out.println(verifyPostOrder(new int[]{1, 3, 2, 6, 5}));//V
    }

    public boolean verifyPostOrder(int[] postOrder) {
        return recur(postOrder, 0, postOrder.length - 1);
    }

    // 最后一个元素为根节点，找到第一个比根节点大的元素，此处为右子树分界点；对比root 左侧均小，右侧均大；
    // 左右子树也符合此搜索律则整棵树是二叉搜索树。
    private boolean recur(int[] postOrder, int i, int j) { //todo 递归、分治
        if (i >= j) return true;
        int p = i;
        while (postOrder[p] < postOrder[j]) p++;
        int m = p;//左右子树分界点
        while (postOrder[p] > postOrder[j]) p++;

        // i~m-1; m~j-1; j;
        return p == j && recur(postOrder, i, m - 1) && recur(postOrder, m, j - 1);
    }
}
