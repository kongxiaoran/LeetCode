package kxr.code;


/**
 * @Author: kxr
 * @Date: 2021/4/13
 * @Description
 *
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/rabbits-in-forest
 *  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class P783 {

    int pre = -1;
    int min = Integer.MAX_VALUE;

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if(pre == -1){
            pre = root.val;
        }else{
            min = Math.min(min,root.val-pre);
            pre = root.val;
        }
        dfs(root.right);

    }
}

/**
 *
 * 解题思想在于 理解题目中 两个节点之间的最小值，充分利用 此树为二叉搜索树的条件。
 * 搜索二叉树的中序遍历序列是一个升序的序列。然后我可以知道 在 一组升序序列中 任意两个节点直接差最小的，
 * 一定是相邻的两个节点。
 */
