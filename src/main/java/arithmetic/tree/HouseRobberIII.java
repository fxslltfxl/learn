package arithmetic.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author fxs
 * @Description //337. House Robber III
 * @Date 2019/12/16
 **/
public class HouseRobberIII {
    private static int level;
    private static int odd;
    private static int even;

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(1);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.right = treeNode5;


        int rob = rob(treeNode);

        System.out.println(rob);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static LinkedList<TreeNode> list = new LinkedList<>();

    public static int rob(TreeNode root) {
        return Math.max(rob(root, true), rob(root, false));
    }

    /**
     * 没有保存每一项F(n)的结果的 递归，每次都要重新计算 ，存在很多冗余计算例如F(2) 可能要被计算很多次
     *
     *  时间900+ms 对比
     *  {@link HouseRobberIII#robHelper(TreeNode, boolean)}  方法}
     * @param root
     * @param robRoot
     * @return
     */
    static int rob(TreeNode root, boolean robRoot) {
        if (root == null) {
            return 0;
        }
        if (robRoot) {
            return root.val + rob(root.left, false) + rob(root.right, false);
        } else {
            int leftMax = Math.max(rob(root.left, false), rob(root.left, true));
            int rightMax = Math.max(rob(root.right, false), rob(root.right, true));
            return leftMax + rightMax;
        }
    }

    private Map<TreeNode, Integer> rob = new HashMap<>();
    private Map<TreeNode, Integer> norob = new HashMap<>();

    /**
     * 使用hashMap 或者Array 缓存每个F(n) 递归的时候 判断如果有 不需计算 直接使用if (rob.containsKey(root)) {
     *                 // Solved case
     *                 return rob.get(root);
     *             }
     *
     *             时间 6ms
     *             {@link HouseRobberIII#rob(TreeNode, boolean)}  方法}
     * @param root
     * @param robRoot
     * @return
     */
    private int robHelper(TreeNode root, boolean robRoot) {
        if (root == null) {
            return 0;
        }

        if (robRoot) {
            if (rob.containsKey(root)) {
                // Solved case
                return rob.get(root);
            } else {
                int money = root.val + robHelper(root.left, false) + robHelper(root.right, false);
                rob.put(root, money);
                return money;
            }
        } else {
            if (norob.containsKey(root)) {
                // Solved case
                return norob.get(root);
            } else {
                int leftMax = Math.max(robHelper(root.left, false), robHelper(root.left, true));
                int rightMax = Math.max(robHelper(root.right, false), robHelper(root.right, true));
                int money = leftMax + rightMax;
                norob.put(root, money);
                return money;
            }
        }
    }


    /**
     * 利用队列 进行树层次遍历
     */
    @Deprecated
    static void levelTraversal() {
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
                for (TreeNode node : list) {
                    if (node != null) {
                        int val = node.val;
                        //level 为0时，队列中存入的 其实的第二层（根节点已经出队列了）
                        if (level % 2 == 0) {
                            odd += val;
                        } else {
                            even += val;
                        }
                    }
                }
                level++;
            }
        }
    }
}