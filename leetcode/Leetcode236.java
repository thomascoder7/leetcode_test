public class Leetcode236 {


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          if (root==null)
              return null;
          if (root.val==p.val||root.val==q.val)
              return root;

          TreeNode lson = lowestCommonAncestor(root.left,p,q);
          TreeNode rson = lowestCommonAncestor(root.right,p,q);

          if (lson!=null&&rson!=null)
              return root;

          if (lson!=null)
              return lson;
          if (rson!=null)
              return rson;

          return null;


    }


}
