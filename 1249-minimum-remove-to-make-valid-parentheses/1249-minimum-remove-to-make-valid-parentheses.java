class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < sb.length(); i++) {
            char temp = sb.charAt(i);
            
            if(temp == '(') {
                stack.push(i);
            }
            if(temp == ')') {
                if(stack.isEmpty()) {
                    sb.setCharAt(i, '*');
                } else {
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        
        return sb.toString().replaceAll("\\*", "");
    }
}

/*
i string s
o remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
c 1 <= s.length <= 10^5
s[i] is either'(' , ')', or lowercase English letter.
e

sol
1.
s를 stringbuilder에 넣고 탐색한다.
여는 괄호를 만나면 stack에 해당 인덱스를 push
닫는 괄호를 만나면 스택이 비어있을 경우 해당 인덱스를 *로 교체
비어있지 않을 경우 pop
탐색이 끝나면 stack에 남아있는 인덱스(짝이 맞지 않는 여는 괄호)를 모두 *으로 교체
교체가 끝나면 모든 *을 삭제

time O(n)
space O(n)
*/