class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alienDict = new int[256];
        
        for(int i = 0; i < order.length(); i++) {
            alienDict[order.charAt(i)] = i;
        }
        
        for(int i = 0; i < words.length - 1; i++) {
            int limit = Math.min(words[i].length(), words[i + 1].length());
            int equalCnt = 0;
            
            for(int j = 0; j < limit; j++) {
                if(alienDict[words[i].charAt(j)] > alienDict[words[i + 1].charAt(j)])
                    return false;
                if(alienDict[words[i].charAt(j)] < alienDict[words[i + 1].charAt(j)])
                    break;
                if(alienDict[words[i].charAt(j)] == alienDict[words[i + 1].charAt(j)])
                    equalCnt++;
            }
            
            if(equalCnt == limit && words[i].length() > words[i + 1].length())
                return false;
        }
        
        return true;
    }
}

/*
i string[] words, string order
o boolean(return true if and only if the given words are sorted lexicographically in this alien language.)
c 1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.
e 

sol
1.
256개의 공간을 가진 배열을 만든다.
order을 읽어서 char이 해당하는 index에 i를 저장한다.(alien language 순서대로)
공백은 어떤 char보다도 작다.(순서가 앞이다.)
words 배열을 읽으면서 alienDict의 순서대로 비교하고 순서가 맞지 않으면 false return
전부 맞으면 true return

time O(mn) n==words.length m==words의 원소 중 가장 긴 문자열 길이
space O(1)
*/