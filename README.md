# LeetCode

백트래킹을 사용할 때 res.add(sub)로 작성하게 되면 이후 재귀의 과정에서 sub에 일어나는 변경사항까지 전부 적용되기 때문에 아래처럼 작성해야 한다.
-> res.add(new ArrayList(sub));

이진 트리의 높이는 최악의 경우 O(n), 최적의 경우(포화, 완전 이진트리) O(logn)이 된다.

이분 탐색을 사용할 때 주어진 범위를 고려해서 (start + end)에서 overflow가 발생할 가능성이 있다면 mid를 start + (end - start) / 2로 설정하면 된다.
