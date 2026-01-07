/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.data != childSum(root)) return false;
        return isSumProperty(root.left) && isSumProperty(root.right);
        
    }
    public int childSum(Node root){
        if(root.right== null) return root.left.data;
        if(root.left == null) return root.right.data;
        else return root.left.data+root.right.data;
    }
}
