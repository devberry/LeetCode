class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sDict = new char[256];
        char[] tDict = new char[256];
        
        for(int i = 0; i < s.length(); i++) {
            char tempS = s.charAt(i);
            char tempT = t.charAt(i);
        
            if(sDict[tempS] != '\0') {
                if(tDict[tempT] != tempS) {
                    return false;
                }
            } else {
                //No two characters may map to the same character --> 이 조건 때문에 필요
                if(tDict[tempT] != '\0') {
                    return false;
                }
                
                sDict[tempS] = tempT;
                tDict[tempT] = tempS;
            }
        }
        
        return true;
    }
}

/*
i string s, string t
o determine if they are isomorphic
c 1 <= s.length <= 5 * 10^4
t.length == s.length
s and t consist of any valid ascii character.
e s.length != t.length -> return false

sol
1.
paper, title의 경우를 생각


pafer
title

p,t
a,i
f,t --> t는 이미 p에 매핑되어있으므로 이것도 안됨, 따라서 배열을 두 개 만들어서 검증

mapping할 때는 아스키문자가 256개 있으므로 256개의 공간을 가진 배열을 만들어서 매핑
s의 문자에 이미 해당하는 mapping이 있으면 그걸 가져오는데 가져온 문자가 t의 문자와 일치하지 않으면 false return
끝까지 true가 나오지 않으면 true return

time O(n), n == s.length
space O(1)

badc
baba

s[b]: b
s[a]: a
s[d]: 
*/