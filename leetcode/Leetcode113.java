import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null)
            return res;
        return getpath(root,targetSum,res,new ArrayList<>());
    }

    public List<List<Integer>> getpath(TreeNode root, int targetSum,List<List<Integer>> res,List<Integer> nowPath) {
        nowPath.add(root.val);
        if (root.left==null&&root.right==null&&targetSum==root.val)
        {
            res.add(nowPath);
            return res;
        }
        if (root.left!=null)
            res = getpath(root.left,targetSum-root.val,res,new ArrayList<>(nowPath));
        if (root.right!=null)
            res = getpath(root.right,targetSum-root.val,res,new ArrayList<>(nowPath));
        return res;
    }

}
