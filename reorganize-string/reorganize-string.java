class Solution {
    public String reorganizeString(String s) {
        if(s.length() == 1) {
            return s;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
            else {
                map.put(ch, 1);
            }
        }
        
        int max = 0;
        char mostEmerge = '\0';
        
        for(char ch : map.keySet()) {
            if(map.get(ch) > max) {
                mostEmerge = ch;
                max = map.get(ch);
            }
        }
        
        char[] result = new char[s.length()];
        int even = 0;
        
        for(int i = 0; i < max; i++) {
            if(even >= s.length()) {
                return "";
            }
            result[even] = mostEmerge;
            even += 2;
        }
    
        int lastEven = 0;
        
        if(s.length() % 2 == 0) {
            lastEven = (s.length() / 2 - 1) * 2;
        }
        else {
            lastEven = (s.length() / 2) * 2;
        }
        
        int odd = 1;
        
        if(even <= lastEven) {
            odd = even;
        }
        
        for(char ch : map.keySet()) {
            if(ch != mostEmerge) {
                for(int i = 0; i < map.get(ch); i++) {
                    if(odd % 2 == 0 && odd > lastEven) {
                        odd = 1;
                    }
                    result[odd] = ch;
                    odd += 2;
                }
            }
        }
        
        return String.valueOf(result);
    }
}

/*
i string: s
o string: rearranged input s(any two adjacent characters are not the same.)
c 1 <= s.length <= 500
e s.length == 1

solution
1. 
s의 char들을 전부 확인해서 map에 넣는다.(key는 char, value는 등장 횟수)
value가 가장 큰 key를 짝수 index에 배치한다.(0, 2, 4...) 
남은 짝수 index가 있다면 나머지 key들을 배치하고 이어서 홀수 index에 배치한다.

time O(n)
space O(n)
*/