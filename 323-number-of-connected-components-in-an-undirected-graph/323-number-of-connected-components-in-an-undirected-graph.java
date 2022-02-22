/*
i int n, int[][] edges
o num of connected component
c - `1 <= n <= 2000`
- `1 <= edges.length <= 5000`
- `edges[i].length == 2`
- `0 <= ai <= bi < n`
- `ai != bi`
- There are no repeated edges.
e n==1 -> return 1
sol
1.
union-find 사용
union-find를 사용한 결과 나오는 parent 배열을 탐색하면서 parent[i] == i일 때만 res 증가
res return
time O(n+mlogn) n==input n, m==num of find calc
space O(n)
*/

class Solution {
	public int numOfConnectedComponent(int n, int[][] edges) {
		if(n == 1)
			return 1;
		
		List<List<Integer>> adj = new ArrayList<List<Integer>>;
		int[] parent = new int[n];
		int res = 0;
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		for(int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for(int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < adj.get(i).size(); j++) {
				unionParent(i, adj.get(i).get(j), parent);
			}
		}
		for(int i = 0; i < n; i++)
			if(parent[i] == i)
				res++;
		return res;
	}
	public int findParent(int x, int[] parent) {
		if(x == parent[x])
			return x;
		
		return parent[x] = findParent(parent[x], parent);
	}
	public void unionParent(int a, int b, int[] parent) {
		a = findParent(a, parent);
		b = findParent(b, parent);
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
}
