/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int minTime(Node root, int target) {
        // code here
        if(root == null) return 0;
        HashMap<Node, Node> pm = new HashMap<>();
        getParent(pm,root);
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited= new HashSet<>();
        q.offer(findTarget(root, target));
        int time =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                Node curr = q.poll();
                visited.add(curr);
                if(pm.containsKey(curr) && !visited.contains(pm.get(curr))){
                    q.offer(pm.get(curr));
                }
                if(curr.left!= null && !visited.contains(curr.left)){
                    q.offer(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)){
                    q.offer(curr.right);
                }
            }
            time++;
        }
        return time-1;
    }
    public Node findTarget(Node root, int target){
        if (root == null) return null;
        if (root.data == target) return root;
        Node left = findTarget(root.left, target);
        if (left != null) return left;
        return findTarget(root.right, target);
    }
    public void getParent(HashMap<Node, Node> pm, Node root){
        if(root == null) return;
        if(root.left != null) pm.put(root.left, root);
        if(root.right != null) pm.put(root.right , root);
        getParent(pm,root.left);
        getParent(pm,root.right);
    }
}
