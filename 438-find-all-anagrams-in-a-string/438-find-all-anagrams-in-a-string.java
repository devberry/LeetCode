class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        
        if(s.length() < p.length()) {
            return res;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        int start = 0;
        int end = 0;
        int cnt = map.size();
        
        while(end < s.length()) {
            char ch = s.charAt(end);
            
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                
                if(map.get(ch) == 0) {
                    cnt--;
                }
            }
            
            end++;
            
            while(cnt == 0) {
                char ch2 = s.charAt(start);
                
                if(map.containsKey(ch2)) {
                    map.put(ch2, map.get(ch2) + 1);
                    
                    if(map.get(ch2) > 0) {
                        cnt++;
                    }
                }
                
                if(end - start == p.length()) {
                    res.add(start);
                }
                
                start++;
            }
        }
        
        return res;
    }
}

/*
i string s, p
o array of all the start indices of p's anagrams in s
c 1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
e s.length < p.length

solution
1.
p를 정렬한다.
s 내에서 움직이는 두 개의 포인터를 만든다.
포인터를 p의 길이만큼 펼친다.
포인터들이 나타내는 문자열을 정렬해서 p와 같은지 확인한다.
같으면 앞의 포인터가 가리키는 index를 res에 추가한다.
같든 다르든 두 개의 포인터를 1씩 이동시킨다.

time O(mlgm+mn) n == s.length, m == p.length
space O(n)

2.
sliding window 사용
map<char, int>에 p의 char들을 전부 집어넣는다. int는 해당 char의 등장 횟수
cnt에 map size를 저장한다.
end가 가리키는 char을 확인해서 map에 해당 char이 존재하면 value를 감소시킨다.
value가 0이 될 때 cnt를 1 감소시킨다.
cnt가 0이면 start를 본다.
start가 가리키는 char을 확인해서 map에 집어넣는다.
value가 0보다 클 때마다 cnt를 증가시킨다.

time O(s + p)
space O(s + p)
*/