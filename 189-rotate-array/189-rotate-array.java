class Solution {
    public void rotate(int[] nums, int k) {
        int newK = k % nums.length;
        
        if(newK == 0 || nums.length == 1) {
            return;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        int t = 0;
        for(int p = nums.length - newK; p < nums.length; p++) {
            q.offer(nums[p]);
        }
        for(int i = 0; i < nums.length - newK; i ++) {
            q.offer(nums[i]);
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = q.poll();
        }
        
        return;
    }
}

/*
i int[] nums, int k
o rotate the array to the right by k steps, where k is non-negative.
c 1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
e k == 0 || k == nums.length || nums.length == 1 -> retun nums

sol
1.
배열 res
p = nums.length - k
p를 nums.length - 1까지 증가시키면서
q.offer(nums[p])


i는 0부터 nums.length - k 미만까지
q.offer(nums[p])

nums를 돌면서
nums[i] = q.poll()

time O(n)
space O(n)

2.


*/