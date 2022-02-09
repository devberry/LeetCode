class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        
        StringBuilder sb = new StringBuilder(s);
        int size = sb.length();
        
        for(int i = 0; i < size; i++) {
            if(sb.toString().equals(goal))
                return true;
            
            char temp = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(temp);
        }
        
        return false;
    }
}

/*
i string s, string goal
o eturn true if and only if s can become goal after some number of shifts on s
c 1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.
e s.length != goal.length -> return false

sol
1.
abcde
bcdea
cdeab
deabc
eabcd
abcde

s 길이만큼 shift를 수행한다.
goal과 일치하면 return true
수행이 끝나도 true가 나오지 않으면 return false

time O(n) n==s.length
space O(n)
*/