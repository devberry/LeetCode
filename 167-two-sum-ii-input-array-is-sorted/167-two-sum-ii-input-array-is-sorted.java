class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        
        while(low < high) {
            if(numbers[low] + numbers[high] == target) {
                break;
            } else if(numbers[low] + numbers[high] < target) {
                low++;
            } else {
                high--;
            }
        }
        
        return new int[] {low + 1, high + 1};
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

2.
low = 0
high = numbers.length - 1
numbers[low] + numbers[high] == target
-> return low, high
< target
low++
> target
high--

time O(n)
space O(1)
*/