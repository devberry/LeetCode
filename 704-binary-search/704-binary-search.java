class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(target == nums[mid]) {
                return mid;
            } else if(target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        
        return -1;
    }
}

/*
i int array: nums, int: target
o search target in nums
If target exists, then return its index. Otherwise, return -1.
c O(log n) runtime complexity.
1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.
e

sol
1.
loop:(start<=end)
start+end/2 -> mid
target이 mid보다 크면 start를 mid+1로
mid보다 작으면 end를 mid-1로
mid와 같으면 return mid

loop를 벗어날 경우 return -1

start 0, end 5, target 9

mid 2
nums[2] 3
start = 3

mid 4
nums[4] 9

time O(logn)
space O(1)
*/