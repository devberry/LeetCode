/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // to avoid overflow incase (left+right)>2147483647
            if (isBadVersion(mid)) {
                ans = mid; // record mid as current answer
                right = mid - 1; // try to find smaller version in the left side
            } else {
                left = mid + 1; // try to find in the right side
            }
        }
        return ans;
    }
}

/*
i int: n
o function to find the first bad version.
You should minimize the number of calls to the API.
c API bool isBadVersion(version) which returns whether version is bad. 
1 <= bad <= n <= 231 - 1
e

sol
1.
주어진 n, bad의 범위가 굉장히 넓으므로 이분탐색을 떠올릴 수 있다.
먼저 start를 1, end를 n으로 놓고
loop:(start<=end)
mid를 start + (end - start) / 2로 설정한다. -> 주어진 범위를 고려했을 때 (start + end) / 2로 하게 되었을 경우 
overflow가 발생할 수 있으므로 이렇게 한다.
isBadVersion(mid) -> false일 경우
    start = mid + 1
true일 경우
    만약 mid가 1이면 
        return 1(처음부터 bad version이면 전부 bad version)
    isBadVersion(mid - 1) -> false이면 return mid
true면
    end = mid - 1

time O(logn)
space O(1)
*/