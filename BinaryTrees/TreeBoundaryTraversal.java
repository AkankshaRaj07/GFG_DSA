/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

import java.util.*;

import java.util.*;

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        if(!isLeaf(root)) list.add(root.data);
        leftBoundary(list, root);
        leaf(list, root);
        rightBoundary(list, root);
        return list;
    }
    public void leftBoundary(ArrayList<Integer> list, Node root){
        Node node = root.left;
        while(node!=null) {
            if(isLeaf(node)) break;
            list.add(node.data);
            if(node.left != null ) node =node.left; 
            else node = node.right;
        }
    }
    public void rightBoundary(ArrayList<Integer> list, Node root){
        Node node = root.right;
        Stack <Integer> st = new Stack <>();
        while(node!=null) {
            if(isLeaf(node)) break;
            st.push(node.data);
            //list.add(node.data);
            if(node.right != null ) node =node.right; 
            else node = node.left;
        }
        while(!st.isEmpty()){
            list.add(st.pop());
        }
    }
    public void leaf(ArrayList<Integer> list, Node root){
         if(root == null) return ;
        if(isLeaf(root)) list.add(root.data);
        leaf(list, root.left);
        leaf(list, root.right);
        
    }
    public boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }
}

