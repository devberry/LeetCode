class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        if(customers.length == 1) {
            return customers[0];
        }
        
        int cus = 0;
        
        for(int i = 0; i < customers.length; i++) {
            if(grumpy[i] == 0) {
                cus += customers[i];
            }
        }
        
        int start = 0;
        int currWindow = 0;
        int maxWindow = 0;
        
        for(int end = 0; end < customers.length; end++) {
            //먼저 end를 움직이면서 start와 end 사이의 범위를 탐색
            if(grumpy[end] == 1) {
                currWindow += customers[end];
            }
            //창의 크기가 minutes에 도달했을 때
            if(end - start + 1 >= minutes) {
                maxWindow = Math.max(maxWindow, currWindow);
                    
                if(grumpy[start] == 1) {
                    currWindow -= customers[start];
                }
                start++;
            }
        }
        
        return cus + maxWindow;
    }
}

/*
i customers, grumpy, minutes
o maximum number of customers that can be satisfied throughout the day
c n == customers.length == grumpy.length
1 <= minutes <= n <= 2 * 104
0 <= customers[i] <= 1000
e customers.length == 1

sol
1. 
technique을 사용하지 않았을 때 max값이 나올 수도 있으므로
처음엔 technique을 적용하지 않은 채로 max값을 구한다.
이후 sliding window를 적용해서 linear time 내에 max값을 구하면 된다.

time O(n)
space O(1)
*/