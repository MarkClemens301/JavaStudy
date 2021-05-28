package 剑指Offer复习;/* 2021/1/21 23:41 */
/*
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]"
 */

import Nodes.TreeNode; //模块名改为Nodes
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class _37_序列化二叉树 {////请实现两个函数，分别用来序列化和反序列化二叉树。

    @Test
    public void t() {
        System.out.println("hello");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(serialize(root));
        System.out.println(deserialize(serialize(root)));
    }

    public String serialize(TreeNode root) {//广度优先搜索，逐层遍历
        if (root == null) {
            return "[]";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder("[");

        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean haveNode = false;
            StringBuilder layer = new StringBuilder();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    layer.append(node.val).append(",");
                    haveNode = true;//本层存在非空节点
                    q.offer(node.left);
                    q.offer(node.right);
                } else {
                    layer.append("null,");
                }
            }
            if (haveNode) sb.append(layer);
        }

        sb.deleteCharAt(sb.length() - 1).append("]");//可以连着使用
        return sb.toString();
    }

    public TreeNode deserialize(String data) {//根据String反序列化出TreeNode
        if (data == null || data.equals("[]")) {
            return null;
        }
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int i = 0;//遍历nodes 两个两个地
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (++i < nodes.length && !nodes[i].equals("null")) {
                int left = Integer.parseInt(nodes[i]);
                node.left = new TreeNode(left);
                q.offer(node.left);
            }
            if (++i < nodes.length && !nodes[i].equals("null")) {
                int right = Integer.parseInt(nodes[i]);
                node.right = new TreeNode(right);
                q.offer(node.right);
            }
        }
        return root;
    }
}
