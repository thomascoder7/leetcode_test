public class Leetcode100 {
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


    public boolean isSameTree(TreeNode p, TreeNode q) {

          if (p==null&&q==null)
              return true;

          if (p==null||q==null)
              return false;

          if (isSameTree(p.left,q.left)!=true||isSameTree(p.right,q.right)!=true)
              return false;


          if (p.val!=q.val)
              return false;
          else
              return true;

    }

    //Leetcode101
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left,root.right);
    }

    public boolean compare(TreeNode left,TreeNode right)
    {
        if (left==null&&right==null)
            return true;
        if (left==null||right==null)
            return false;

        if (!compare(left.left,right.right)||!compare(left.right,right.left))
            return false;

        if (left.val!=right.val)
            return false;
        else
            return true;
    }

    // Leetcode222题
    public int countNodes(TreeNode root) {

          if (root==null)
              return 0;
          return countNodes(root.left)+countNodes(root.right)+1;

    }


    // Leetcode110
    public boolean isBalanced(TreeNode root) {

        return getLength(root)!=-1;

    }

    public int getLength(TreeNode root) {
        if (root==null)
            return 0;

        int left = getLength(root.left);
        if (left==-1)
            return -1;
        int right = getLength(root.right);
        if (right==-1)
            return -1;
        if (Math.abs(right-left)>=2)
            return -1;
        else
            return Math.max(left,right)+1;

    }


}
