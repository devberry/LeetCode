class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        
        for(int i = 0; i < numbers.length; i++) {
            int j = i + 1;
            res[0] = i + 1;
            
            int bs = binarySearch(numbers, target - numbers[i], j, numbers.length - 1);
            if(bs != -1) {
                res[1] = bs + 1;
                break;
            }
        }
        
        return res;
    }
    
    public int binarySearch(int[] arr, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(arr[mid] > target) {
                right = mid - 1;
            } else if(arr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
}

/*
i 1-indexed array of integers numbers(already sorted in non-decreasing order)
o Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2
c 2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
e

sol
1.
이진 탐색 사용
i는 0부터 시작
j는 i + 1
i가 가리키는 값을 target에서 빼서 newTarget을 만든다.
그 후 binary(numbers, newTarget, j, numbers.length)을 사용해서 두번째 인덱스를 찾는다.
배열을 만들어서 반환

time O(nlogn)
space O(1)
*/