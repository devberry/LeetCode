class Solution {
    public void moveZeroes(int[] nums) {
        for(int p = 0, i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, p++, i);
            }
        }
    }
    
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

/*
i int[] nums
o move all 0's to the end of it while maintaining the relative order of the non-zero elements.
c Note that you must do this in-place without making a copy of the array.
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
e

sol
1.
추가 배열을 사용했을 경우
int[] temp
low = 0
high = temp.length - 1

nums를 돌면서
if nums[i] == 0
    temp[high--] = nums[i]
else
    temp[low++] = nums[i]
    
time O(n)
space O(n)
    
2.
i는 배열 안에서 움직이고
p는 0이 아닌 원소를 만났을 때만 증가
0 1 0 3 12
i 0
p 0
1 0 0 3 12
i 1
p 1
1 0 0 3 12
i 2
p 1
1 3 0 0 12
i 3
p 2
1 3 0 0 12
i 4
p 2

time O(n)
space O(1)
*/