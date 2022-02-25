class Solution {
    public String decodeString(String s) {
        Queue<Character> q = new LinkedList<>();
        
        for(char c : s.toCharArray()) {
            q.offer(c);
        }
        
        return recursion(q);
    }
    
    public String recursion(Queue<Character> q) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        while(!q.isEmpty()) {
            char ch = q.poll();
            
            if(ch == '[') {
                String temp = recursion(q);
                
                for(int j = 0; j < cnt; j++) {
                    sb.append(temp);
                }
                
                cnt = 0;
            } else if(ch == ']') {
                break;
            } else if(Character.isLetter(ch)) {
                sb.append(ch);
            } else { // 만약 digit char이 연속으로 나열되어 있을 수도 있으므로(ex. 12, 200) 아래처럼 저장해야 한다.
                // 1의 자리만 있을 때는 0에 10이 곱해지므로 0 + charS[i] - '0'이 된다.
                cnt = cnt * 10 + ch - '0';
            }
        }
        
        return sb.toString();
    }
}

/*
i string s
o decoded s
c 1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
e

sol
1.
숫자: count에 저장
문자: sb에 바로 추가
'[': recursion 사용, 내부의 문자를 count만큼 반복해서 추가 
']': break

"3[a2[c]]"
sub1's count 3
sub1 {
    "a"
    sub2's count 2
    sub2 {
        "cc"
    }
}
*/