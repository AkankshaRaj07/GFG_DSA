/*Complete the Given Function

Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=null;
        right=null;
    }
}*/

class Solution {
    public void toSumTree(Node root) {
        getSum(root);
    }
    public int getSum(Node root){
        if (root == null) return 0;
        int left = getSum(root.left);
        int right = getSum(root.right);
        int old = root.data;
        root.data = left+right;
        return old+root.data;
    }
    
}
