import java.util.*;

public class Leetcode107 {

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


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res= new LinkedList<List<Integer>>();
        if (root==null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = queue.size();
        while (!queue.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            for (int i=0;i<levelSize;i++)
            {
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                if (treeNode.left!=null)
                    queue.offer(treeNode.left);
                if (treeNode.right!=null)
                    queue.offer(treeNode.right);
            }
            levelSize = queue.size();
            res.add(0,temp);
        }
        return res;
    }


    // Leetcode103
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        if (root==null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = queue.size();
        boolean status = true;
        while (!queue.isEmpty())
        {
            Deque<Integer> temp = new LinkedList<>();
            for (int i=0;i<levelSize;i++)
            {
                TreeNode treeNode = queue.poll();

                if (status)
                    temp.offerLast(treeNode.val);
                else
                    temp.offerFirst(treeNode.val);

                if (treeNode.left!=null)
                    queue.offer(treeNode.left);
                if (treeNode.right!=null)
                    queue.offer(treeNode.right);
            }
            status = !status;
            levelSize = queue.size();
            res.add(new LinkedList<>(temp));
        }
        return res;
    }

}
