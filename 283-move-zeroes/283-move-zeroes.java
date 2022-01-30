class Solution {
    public void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        int low = 0;
        int high = temp.length - 1;
        int i = 0;
            
        while(low <= high) {
            if(nums[i] == 0) {
                temp[high--] = nums[i];
            } else {
                temp[low++] = nums[i];
            }
            i++;
        }
        
        
        for(int j = 0; j < temp.length; j++) {
            nums[j] = temp[j];
        }
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

*/