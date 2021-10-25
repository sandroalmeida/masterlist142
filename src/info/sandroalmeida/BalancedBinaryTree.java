package info.sandroalmeida;

public class BalancedBinaryTree {

     public static class TreeNode {
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

     public static class NodeInfo {
         boolean isBalanced;
         int maxHeight;

         public NodeInfo(boolean isBalanced, int maxHeight) {
             this.isBalanced = isBalanced;
             this.maxHeight = maxHeight;
         }
     }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        NodeInfo rootInfo = traverse(root);
        return rootInfo.isBalanced;
    }

    private static NodeInfo traverse(TreeNode node){

         NodeInfo leftInfo = node.left == null ? new NodeInfo(true, 0) : traverse(node.left);
         NodeInfo rightInfo = node.right == null ? new NodeInfo(true, 0) : traverse(node.right);

         int maxHeight = Math.max(leftInfo.maxHeight, rightInfo.maxHeight) + 1;

         boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced && (Math.abs(leftInfo.maxHeight - rightInfo.maxHeight) <= 1);

        return new NodeInfo(isBalanced, maxHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(7);

        System.out.println(isBalanced(root));
    }
}
