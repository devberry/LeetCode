class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(target == nums[mid]) {
                return mid;
            } else if(target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return start;
    }
}

/*
i a sorted array of distinct integers and a target value
o the index if the target is found
If not, return the index where it would be if it were inserted in order.
c You must write an algorithm with O(log n) runtime complexity.
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
e

sol
1.
array가 정렬되어 있고 O(logn)의 시간복잡도를 가지게 하면서 target을 찾으려면 이분 탐색이 필요하다.
다른 부분은 기존의 이분 탐색대로 구현하면 된다.
start와 end가 교차되었을 때 while문에서 빠져나오게 되고,
while문에서 나오기 직전에 target이 nums[mid]보다 컸다면 mid 바로 다음 위치에 target이 들어가야 하므로 start,
작았다면 mid 바로 이전 위치에 target이 들어가야 하지만 배열의 인덱스는 0이 최솟값이므로 여전히 start가 반환되어야 한다.

time O(logn)
space O(1)
*/