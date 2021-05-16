public class Leetcode404 {

    public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return valueOfLeftLeaves(root,false);
    }

    public int valueOfLeftLeaves(TreeNode node, boolean left) {

        if (node==null)
            return 0;

        if (node.left==null&&node.right==null&&left)
            return node.val;

        return valueOfLeftLeaves(node.left,true)+valueOfLeftLeaves(node.right,false);
    }

}
