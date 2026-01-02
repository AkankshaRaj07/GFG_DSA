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
    class Custom{
        Node node;
        int col;
        Custom(Node node,int col){
            this.node= node;
            this.col= col;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null ) return list;
        Queue <Custom> queue= new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        queue.offer(new Custom (root,0));
        while(!queue.isEmpty()){
            Custom customNode = queue.poll();
            Node newNode = customNode.node;
            int col= customNode.col;
            map.put(col,newNode.data);
            if(newNode.left != null ) {
                queue.offer(new Custom(newNode.left, col - 1));
            }
            if(newNode.right != null){
                queue.offer(new Custom(newNode.right, col + 1));
            }
            
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}
