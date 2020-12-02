import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BST {

//    二叉查找树

    private int count;
    private Node root;

    public class Node
    {
        private String key;
        private String value;
        private Node left;
        private Node right;

        public Node(String key, String value)
        {
            this.key = key;
            this.value = value;
        }

        public void getValue()
        {
            System.out.println(value);
        }

    }

    public int getSize()
    {
        return count;
    }

    public Node insert(String key, String value)
    {
        insert(root,key,value);
        return root;
    }

    /**
     * 递归
     * 对于当前以node为根的子树进行插入操作
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node insert(Node node, String key, String value)
    {
        //递归出口
        if (root==null)
        {
            node = new Node(key,value);
            root = node;
            return node;
        }

        if (node.key.equals(key))
        {
            if (node.value != value)
                node.value = value;
            return node;
        }
        //递归
        if (key.compareTo(node.key)<0)
        {
            if (node.left==null)
                node.left = new Node(key,value);
            return insert(node.left,key,value);
        }

        else if (key.compareTo(node.key)>0)
        {
            if (node.right == null)
                node.right = new Node(key,value);
            return insert(node.right,key,value);
        }

        return node;
    }

    /**
     * 查询键值为key的value
     * @param key
     * @return
     */
    public String search(String key)
    {
        return search(root,key);
    }

    private String search(Node node, String key)
    {
        //递归出口
        if (node.key.equals(key))
        {
            return node.value;
        }
        else if (node.left == null && node.right == null)
        {
            return null;
        }

        if (key.compareTo(node.key) <0)
        {
            return search(node.left,key);
        }
        else if (key.compareTo(node.key) >0 )
        {
            return search(node.right,key);
        }
        return node.value;
    }

    /**
     * 前序遍历
     */
    public void preOrder()
    {
        preOrder(root);
    }

    private void preOrder(Node node)
    {
        if (node==null)
            return;
        System.out.println(node.value);

        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 层序遍历
     */
    public void levelOrder()
    {
        Queue<Node> queue = new LinkedList<>();
        if (root!=null)
        {
            queue.offer(root);
            levelOrder(queue);
        }
    }

    private void levelOrder(Queue<Node> queue)
    {
        while(!queue.isEmpty())
        {
            Node node = queue.poll();
            System.out.println(node.value);
            if (node.left!=null)
                queue.offer(node.left);
            if (node.right!=null)
                queue.offer(node.right);
        }

    }

    /**
     * 删除node节点根节点的子树的最大节点
     * @param node
     */
    public Node deleteMax(Node node)
    {
        if (node.right==null)
        {
            //这一步很关键
            return node.left;
        }

        node.right = deleteMax(node.right);
        return node;
    }

    /**
     * 删除node节点根节点的子树的最小节点
     * @param node
     */
    public Node deleteMin(Node node)
    {
        if (node.left==null)
        {
            return node.right;
        }

        node.left = deleteMin(node.left);
        return node;
    }

    /**
     * 根据key值删除节点
     * @param node
     * @param key
     * @return
     */
    public Node remove(Node node, String key)
    {
        if (key.compareTo(node.key)>0)
        {
            node.right = remove(node.right,key);
            return node;
        }
        else if (key.compareTo(node.key)<0)
        {
           node.left = remove(node.left,key);
           return node;
        }
        else if (key.equals(node.key))
        {
            if (node.left==null)
            {
                return node.right;
            }
            else if (node.right==null)
            {
                return node.left;
            }
            //执行到这里说明node.left!=null&&node.right!=null
            Node rightMin = getMin(node.right);
            rightMin.right = deleteMin(node.right);
            rightMin.left = node.left;
            return rightMin;
        }
        return node;
    }

    /**
     * 获得已node节点为根节点的树的最小节点
     * @param node
     * @return
     */
    private Node getMin(Node node)
    {
        if (node.left==null)
            return node;
        return getMin(node.left);
    }

}
