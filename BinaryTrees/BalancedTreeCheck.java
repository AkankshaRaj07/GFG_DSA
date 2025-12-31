/*
class Node {
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public boolean isBalanced(Node root) {
        // code here
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(!(Math.abs(leftHeight-rightHeight) <=1)) return false;
        return isBalanced(root.left) && isBalanced(root.right);
        
    }
    public int height(Node root){
        if(root== null) return 0;
        return 1+ Math.max(height(root.left),height(root.right));
    }
}
