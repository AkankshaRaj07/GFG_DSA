/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node root) {
        if(root == null || root.next == null) return root;
        root.next = flatten(root.next);
        root = merge(root, root.next);
        root.next = null;

        return root;
    }
    public Node merge(Node a, Node b) {
    Node dummy = new Node(0);
    Node tail = dummy;

    while (a != null && b != null) {
        if (a.data <= b.data) {
            tail.bottom = a;
            a = a.bottom;
        } else {
            tail.bottom = b;
            b = b.bottom;
        }
        tail = tail.bottom;
    }

    if (a != null) tail.bottom = a;
    else tail.bottom = b;

    return dummy.bottom;
    }
}
