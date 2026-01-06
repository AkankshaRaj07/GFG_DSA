/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static ArrayList<ArrayList<Integer>> ans;
    static ArrayList<Integer> list;

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ans = new ArrayList<>();
        list = new ArrayList<>();
        dfs(root);
        return ans;
    }

    private static void dfs(Node root) {
        if (root == null) return;

        list.add(root.data);

        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(list));
        }

        dfs(root.left);
        dfs(root.right);

        list.remove(list.size() - 1);
    }
}
