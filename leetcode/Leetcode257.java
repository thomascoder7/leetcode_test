import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {


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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        return addTreePaths(root,res,"");
    }

    public List<String> addTreePaths(TreeNode node, List<String> res, String path) {
        StringBuffer stringBuffer = new StringBuffer(path);
        stringBuffer.append(node.val);
        if (node.left==null&&node.right==null)
        {
            res.add(stringBuffer.toString());
            return res;
        }
        stringBuffer.append("->");

        if (node.left!=null)
            res = addTreePaths(node.left,res,stringBuffer.toString());
        if (node.right!=null)
            res = addTreePaths(node.right,res,stringBuffer.toString());
        return res;
    }

}
