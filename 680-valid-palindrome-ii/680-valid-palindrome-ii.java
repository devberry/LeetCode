class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    public boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}

/*
i string s
o return true if the s can be palindrome after deleting at most one character from it.
c 1 <= s.length <= 10^5
s consists of lowercase English letters.
e

sol
1.
at most라는 건 아예 안 지워도 된다는 의미니깐 맨 처음에도 palindrome 여부를 확인
앞에서부터 한 문자씩 지운 뒤 palindrome check
맞으면 return true
아니면 지웠던 문자 다시 복구
전부 해봐도 안 되면 return false

time O(n^2) --> TLE
space O(1)

2.
투 포인터로 palindrome check를 진행하고 두 char가 같지 않게 되었을 때
현재 left가 i, right가 j라 하면 (i+1,j),(i,j-1) 두 가지 경우를 모두 check한다.(문자를 지우는 대신 이렇게 처리한다.)
한 쪽이라도 palindrome이면 한 문자만 지워서 palindrome인 경우가 존재하는 것이므로 true return

time O(n)
space O(1)
*/