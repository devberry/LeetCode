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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) {
            return res;
        }
        
        dfs(root, targetSum, 0, sub, res);
        
        return res;
    }
    
    public void dfs(TreeNode node, int targetSum, int curSum, List<Integer> sub, List<List<Integer>> res) {
        if(node.left == null & node.right == null) {
            if(targetSum == curSum + node.val) {
                sub.add(node.val);
                //res.add(sub)로 작성하게 되면 이후 sub에 일어나는 변경사항까지 전부 적용되기 때문에 아래처럼 작성해야 한다.
                res.add(new ArrayList(sub));
                sub.remove(sub.size() - 1);
            }
            return;
        }
        
        sub.add(node.val);
        
        if(node.left != null)
            dfs(node.left, targetSum, curSum + node.val, sub, res);
        if(node.right != null)
            dfs(node.right, targetSum, curSum + node.val, sub, res);
        
        sub.remove(sub.size() - 1);
    }
}

/*
i root of tree, int: targetSum
o int: all root-to-leaf paths where the sum of the node values in the path equals targetSum.
c The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
e root == null

sol
1.
dfs로 탐색한다.
list를 하나 만들어서 노드들의 값을 추가하면서 다음 노드로 넘어갈 때 넘겨준다(현재 노드의 value도 sum에 더해서 같이).
함수를 return할 때 sum과 targetSum이 일치하면 현재 list를 결과 list에 추가한다.

time O(n)
space O(n + ab) a==leaf node의 갯수, b==root to leaf까지의 노드 갯수
*/