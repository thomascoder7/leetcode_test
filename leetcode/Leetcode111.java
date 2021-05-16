public class Leetcode111 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public int minDepth(TreeNode root) {
        if (root==null)
            return 0;
        TreeNode node = root;
        int min = Integer.MAX_VALUE;
        if (node.left==null&&node.right==null)
            return 1;
        if (root.left!=null)
            min = Math.min(minDepth(root.left),min);
        if (root.right!=null)
            min = Math.min(minDepth(root.right),min);
        return min+1;
    }

}
