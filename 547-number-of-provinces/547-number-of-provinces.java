class Solution {
    //find
    public int findParent(int x, int[] parent) {
        if(x == parent[x])
            return x;
        return parent[x] = findParent(parent[x], parent);
    }
    //union
    public int unionParent(int a, int b, int[] parent) {
        a = findParent(a, parent);
        b = findParent(b, parent);
        //부모가 같으면 union 연산이 필요 없으므로 종료 
        if(a == b) {
            return 0;
        }
        
        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
        //union 연산이 수행될 경우 province의 갯수에서 -1
        return -1;
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        //부모 배열
        int[] parent = new int[n];
        //province의 갯수
        int cnt = n;
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected[0].length; j++) {
                if(isConnected[i][j] == 1) {
                    cnt += unionParent(i, j, parent);
                }
            }
        }
        
        return cnt;
    }
}

/*
i int[][] isConnected 
o total number of provinces
c 1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
e

sol
1.
union-find 사용
크기 n인 parent 배열을 만든다.
isConnected를 이용해 union 연산을 수행한다.
값이 1인 경우에 union

time O(n+mlogn) n==isConnected.length, m==find 연산 횟수
space O(n)
*/