/* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/
class Tree {
   
    public ArrayList<Integer> diagonal(Node root) {
        // add your code here.
        ArrayList <Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue <Node > q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            Node curr = q.poll();

            // traverse the right chain
            while (curr != null) {
                ans.add(curr.data);

                // save left child for later
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                curr = curr.right;
            }
        }
        return ans;
    }
}
