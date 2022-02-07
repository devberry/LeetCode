class Solution {
	public int makeConnected(int n, int[][] connections) {
	if(n == 1 || connections.length < n -1) 
		return - 1;
	
	List<List<Integer>> adj = new ArrayList<List<Integer>>();
	
	for(int i = 0; i < n; i++) {
		adj.add(new ArrayList<>());
    }
    //인접리스트 만들기
    for(int i = 0; i < connections.length; i++) {
		adj.get(connections[i][0]).add(connections[i][1]);
	    adj.get(connections[i][1]).add(connections[i][0]);
    }
    //방문 배열
    boolean[] visited = new boolean[n];
        
    int cnt = 0;
    //bfs 수행, 연결된 하나의 그룹을 전부 탐색하면 1씩 증가
    for(int i = 0; i < n; i++) {
		cnt += bfs(i, adj, visited);
    }
    //n개의 그룹을 연결하기 위해서 필요한 간선 갯수 n-1
    return cnt - 1;
}

    public int bfs(int i, List<List<Integer>> adj, boolean[] visited) {
        //방문한 컴퓨터는 bfs 수행 x
	    if(visited[i] == true) {
            return 0;
        }
        
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        
        q.offer(i);
        //큐가 빌 때까지 현재 컴퓨터와 연결된 컴퓨터를 모두 방문
	    while(!q.isEmpty()) {
		    int cur = q.poll();
            
		    for(int j = 0; j < adj.get(cur).size(); j++) {
			    if(!visited[adj.get(cur).get(j)]) {
                    visited[adj.get(cur).get(j)] = true;
				    q.offer(adj.get(cur).get(j));
			    }
            }
        }
        
        return 1;
    }
}
