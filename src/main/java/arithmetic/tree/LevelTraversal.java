package arithmetic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/12/24
 **/
public class LevelTraversal {
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
        ArrayList<Integer> inner = new ArrayList<>();
        inner.add(root.val);
        ArrayList<List<Integer>> res = new ArrayList<>();
        res.add(inner);
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
                inner = new ArrayList<>();
                for (TreeNode node : list) {
                    if (node != null) {
                        int val = node.val;
                        //level 为0时，队列中存入的 其实的第二层（根节点已经出队列了）
                        inner.add(val);
                    }
                }
                res.add(inner);
                level++;
            }
        }
        return res;
    }


}
//写字楼里写字间，写字间里程序员；  
//程序人员写程序，又拿程序换酒钱。  
//酒醒只在网上坐，酒醉还来网下眠；  
//酒醉酒醒日复日，网上网下年复年。  
//但愿老死电脑间，不愿鞠躬老板前；  
//奔驰宝马贵者趣，公交自行程序员。  
//别人笑我忒疯癫，我笑自己命太贱；  
//不见满街漂亮妹，哪个归得程序员？ 