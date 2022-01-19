/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        
        int curSum = 0;
        List<Boolean> list = new ArrayList<>();
        
        dfs(root, targetSum, curSum, list);
        
        return list.contains(true);
    }
    
    public void dfs(TreeNode root, int targetSum, int curSum, List<Boolean> list) {
        if(root.left == null & root.right == null) {
            list.add(targetSum == root.val + curSum);
            return;
        }
        
        if(root.left != null)
            dfs(root.left, targetSum, root.val + curSum, list);
        
        if(root.right != null)
            dfs(root.right, targetSum, root.val + curSum, list);
    }
}

/*
i root of tree, int: targetSum
o boolean: true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum
c The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
e root == null

sol
1.
dfs로 탐색
현재 노드의 value를 sum에 더해가면서 다음에 탐색할 노드에 넘겨주는 방식
leaf 노드를 만나면 sum과 targetSum을 대조해서 같으면 true return

time O(n)
space O(n)
*/