package Leetcode;/* 2020/9/9 1:23 */

public class TreeNode {//全都公开，供其他包调用，省去getter、setter
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }
}