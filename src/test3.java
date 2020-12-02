public class test3 {

    /**
     * 测试二叉搜索树
     * @param args
     */

    public static void main(String[] args) {
        BST bst = new BST();
        BST.Node root = bst.insert("3","3");
        bst.insert("4","4").getValue();
        bst.insert("7","7").getValue();
        bst.insert("6","6").getValue();
        bst.insert("5","5").getValue();
        bst.insert("9","9").getValue();
        bst.insert("8","8").getValue();
        System.out.println("分割线");
        System.out.println(bst.search("4"));
        System.out.println("分割线");
        bst.preOrder();
        System.out.println("分割线");
        bst.levelOrder();
//        bst.deleteMax(root);
        System.out.println("分割线");
        bst.remove(root,"7");
        bst.levelOrder();
    }


}
