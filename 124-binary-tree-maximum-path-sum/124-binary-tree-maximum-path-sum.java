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
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        
        return max;
    }
    
    public int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }
        //0과 max 연산을 하는 이유? -> 노드 값이 음수인 경우엔 더해봤자 합이 더 작아지므로 더하지 않는 게 좋기 때문이다.
        int sumLeft = Math.max(0, dfs(node.left));
        int sumRight = Math.max(0, dfs(node.right));
        //왼쪽 경로와 오른쪽 경로를 연결할지 말지 선택
        max = Math.max(max, node.val + sumLeft + sumRight);
        //null이 아닐 때는 왼쪽과 오른쪽에서 더 큰 쪽을 선택해서 현재 노드와 더한 뒤 반환
        return node.val + Math.max(sumLeft, sumRight);
    }
}

/*
i root of binary tree
o maximum path sum of any non-empty path
c A node can only appear in the sequence at most once.
the path does not need to pass through the root
The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
e

sol
1.
트리를 탐색하기 위해 dfs를 사용한다.
합을 선택하는 경우의 수
1) 현재 노드만을 선택하는 경우
2) 왼쪽 서브트리만을 선택하는 경우
3) 오른쪽 서브트리만을 선택하는 경우
4) 왼쪽, 오른쪽 서브트리 둘 다 선택하는 경우

time O(n) n == 노드의 총 갯수
space O(h) h == 노드의 높이

       1
   -2   -3
  1 3 -2 null
-1   4
*/