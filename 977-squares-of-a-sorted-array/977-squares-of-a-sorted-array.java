class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        
        Arrays.sort(nums);
        
        return nums;
    }
}

/*
i an integer array nums sorted in non-decreasing order
o an array of the squares of each number sorted in non-decreasing order.
c 1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
e

sol
1.
nums의 각각의 숫자를 전부 ^2 연산을 해준 뒤 원래 자리에 전부 넣어준다.
sort를 해준다.

time O(n + nlogn = nlogn)
space O(1)
*/