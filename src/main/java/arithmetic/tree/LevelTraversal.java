package arithmetic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author fxs
 * @Description level traversal of tree
 * @Date 2019/12/24
 **/
public class LevelTraversal {
    /**
     * The level of the tree
     * same as {@link #levelOrder(TreeNode).size()}
     */
    private static int level;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    static LinkedList<TreeNode> list = new LinkedList<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        /**
         * use queue ,add null after level++
         */
        list.addLast(root);
        list.addLast(null);
        ArrayList<Integer> levelItems = new ArrayList<>();
        levelItems.add(root.val);
        ArrayList<List<Integer>> levels = new ArrayList<>();
        levels.add(levelItems);
        while (!list.isEmpty()) {
            TreeNode treeNode = list.removeFirst();
            if (treeNode != null) {
                if (treeNode.left != null) {
                    list.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    list.addLast(treeNode.right);
                }
            } else {
                if (list.isEmpty()) break;
                list.addLast(null);
                levelItems = new ArrayList<>();
                for (TreeNode node : list) {
                    if (node != null) {
                        int val = node.val;
                        //level 为0时，队列中存入的 其实的第二层（根节点已经出队列了）
                        levelItems.add(val);
                    }
                }
                levels.add(levelItems);
                level++;
            }
        }
        return levels;
    }


}