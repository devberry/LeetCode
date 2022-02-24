class Solution {
    public int countBinarySubstrings(String s) {
        int pre = 0;
        int cur = 1;
        int cnt = 0;
        
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            
            if(pre >= cur) {
                cnt++;
            }
        }
        
        return cnt;
    }
}

/*
i one binary string
o number of non-empty substrings that have the same number of 0's and 1's, and all the 0's
Substrings that occur multiple times are counted the number of times they occur.(쉽게 말해 중복 substring도 별개로 취급한다는 의미)
c 1 <= s.length <= 105
e s.length==1

sol
1.
substring 조건은 substring 내부에 있는 0과 1끼리는 전부 붙어있어야 하고 0과 1의 갯수가 같아야 한다는 것이다.
예를 들어 00110011은 0과 1끼리 붙어있지 않기 때문에 invalid
이전 문자 갯수 pre
현재 문자 갯수 cur

이전 숫자와 현재 숫자가 같으면 cur++
이전 숫자와 현재 숫자가 다르면 pre = cur, cur = 1
pre >= cur일 때 cnt++
01 0011 000111

time O(n)
space O(1)
*/