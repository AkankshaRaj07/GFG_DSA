/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node root) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if(root== null) return result;
        Queue <Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            if(currNode.right!= null ) queue.offer(currNode.right);
            if(currNode.left!= null ) queue.offer(currNode.left);
            result.add(currNode.data);
        }
        Collections.reverse(result);
        return result;
    }
    
}
