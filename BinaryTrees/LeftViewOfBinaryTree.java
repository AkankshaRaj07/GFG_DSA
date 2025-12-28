/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue <Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node currNode= root;
            for(int i = 0; i<size; i++){
                currNode = queue.poll();
                if(currNode.right != null) queue.offer(currNode.right);
                if(currNode.left != null) queue.offer(currNode.left);
            }
            list.add(currNode.data);
        }
        return list;
    }
}
