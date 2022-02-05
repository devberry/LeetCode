class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        //s1의 char별 등장횟수 map에 저장
        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //window의 start, end
        int start = 0;
        //s1의 char이 모두 발견되면 0이 되어야 함.
        int cnt = map.size();
        
        for(int end = 0; end < s2.length(); end++) {
            char c = s2.charAt(end);
            //end가 가리키는 문자가 map에 있다면
            if(map.containsKey(c)) {
                //등장 횟수--
                map.put(c, map.get(c) - 1);
                //모두 등장했다면 한 문자가 모두 나왔으므로 cnt--
                if(map.get(c) == 0) {
                    cnt--;
                }
            }
            //window의 크기가 s1의 길이와 같아졌을 경우
            while(cnt == 0) {
                if(end - start + 1 == s1.length()) {
                    return true;
                }
                
                char c2 = s2.charAt(start);
                
                if(map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if(map.get(c2) > 0) {
                        cnt++;
                    }
                }
                
                start++;
            }
        }
        
        return false;
    }
}

/*
i two strings s1 and s2
o true if s2 contains a permutation of s1, or false otherwise
c 1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
e s1.length > s2.length -> return false

sol
1. sliding window
permutation이므로 각 문자의 등장 횟수가 모두 같다는 것을 파악한다.
s1을 돌면서 map에 (character, cnt)를 넣는다.
s2를 돌면서 s1의 길이만큼 window를 잡고 window를 움직인다.
window 내에서 char의 등장 횟수와 map 내의 char 등장 횟수를 대조해서 모두 일치하면 true return
끝까지 탐색해도 true가 나오지 않으면 false return

time O(n)
space O(n)
*/