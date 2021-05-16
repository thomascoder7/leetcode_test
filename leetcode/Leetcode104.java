public class Leetcode104 {

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


    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        TreeNode node = root;
        int maxL = 0;
        int maxR = 0;
        if (node.left==null&&node.right==null)
            return 1;
        if (root.left!=null)
            maxL = maxDepth(root.left);
        if (root.right!=null)
            maxR = maxDepth(root.right);
        return maxL>maxR?maxL+1:maxR+1;

    }


}
