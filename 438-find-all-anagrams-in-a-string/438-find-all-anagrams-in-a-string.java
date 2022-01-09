class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        
        if(s.length() < p.length()) {
            return res;
        }
        
        
        int start = 0;
        int end = 0;
        
        while(end - start + 1 <= p.length()) {
            end++;
        }
        
        char[] charP = p.toCharArray();
        
        Arrays.sort(charP);
        
        while(end <= s.length()) {
            char[] charS = s.substring(start, end).toCharArray();
                
            Arrays.sort(charS);
                
            if(Arrays.equals(charS, charP)) {
                res.add(start);    
            }
            
            start++;
            end++;
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
*/