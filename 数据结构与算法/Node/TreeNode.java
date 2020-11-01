package Node;/* 2020/9/9 1:23 */

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {//全都公开，供其他包调用，省去getter、setter
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public String toString() {//2020-11-2
        TreeNode root = this;
        StringBuilder sb = new StringBuilder();
        Queue q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = (TreeNode) q.poll();
            if (node != null) {
                sb.append(',').append(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        if (sb.length() != 0) sb.deleteCharAt(0);
        return sb.toString();
    }
}