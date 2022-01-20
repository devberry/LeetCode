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
    public int sumNumbers(TreeNode root) {
	    return sum(root, 0);
    }

    public int sum(TreeNode node, int s) {
        if (node == null) {
            return 0;
        }
        
	    if (node.right == null && node.left == null) {
            return s*10 + node.val;
        }
        
	    return sum(node.left, s*10 + node.val) + sum(node.right, s*10 + node.val);
    }
}

/*
i root(binary tree)
o otal sum of all root-to-leaf numbers
c The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 9
The depth of the tree will not exceed 10.
e

sol
dfs를 이용해 탐색한다.
트리를 탐색하면서 경유하는 노드의 값을 list에 넣는다.
path가 완성될 때마다 결과 list에 추가한다.
탐색이 끝나면 list에서 path를 꺼내서 int로 바꾼 뒤 모두 더한다.
path를 수정할 때마다 backtracking 사용

time O(?)
space O(?)

class Solution {
    public int sumNumbers(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int res = 0;
        
        dfs(root, paths, path);
        
        for(int i = 0; i < paths.size(); i++) {
            int size = paths.get(i).size() - 1;
            for(int j = 0; j < paths.get(i).size(); j++) {
                //꺼낸 path의 노드 값 * 꺼낸 path의 size - 1(size는 1씩 감소, 10의 자리수...1의 자리수)
                res += paths.get(i).get(j) * Math.pow(10, size--);
            }
        }
        
        return res;
    }
    
    public void dfs(TreeNode node, List<List<Integer>> paths, List<Integer> path) {
        //리프 노드를 만나면
        if(node.left == null && node.right == null) {
            path.add(node.val);
            //root-to-leaf path를 목록에 추가
            paths.add(new ArrayList(path));
            //path를 수정해야 하므로 마지막에 추가한 노드 값 삭제
            path.remove(path.size() - 1);
            return;
        }
        
        path.add(node.val);
        
        if(node.left != null) {
            dfs(node.left, paths, path);
        }
        if(node.right != null) {
            dfs(node.right, paths, path);
        }
        
        path.remove(path.size() - 1);
    }
}

dfs를 이용해 탐색한다.
재귀함수는 기본적으로 왼쪽 서브트리 합 + 오른쪽 서브트리 합을 반환하도록 한다.
리프 노드를 만나면 더해오던 숫자 * 10 + 현재 노드의 값을 반환하도록 한다.

time O(n)
space O(n)
*/
