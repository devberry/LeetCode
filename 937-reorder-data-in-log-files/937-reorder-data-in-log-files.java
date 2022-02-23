class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letter = new ArrayList<>();
        List<String> digit = new ArrayList<>();
        
        for(String log : logs) {
            String[] word = log.split(" ");
            
            if(Character.isDigit(word[1].charAt(0)))
                digit.add(log);
            else
                letter.add(log);
        }
        
        Collections.sort(letter, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String temp1 = s1.substring(s1.indexOf(" ") + 1);
                String temp2 = s2.substring(s2.indexOf(" ") + 1);
                
                if(temp1.equals(temp2)) {
                    return s1.split(" ")[0].compareTo(s2.split(" ")[0]);
                } else {
                    return temp1.compareTo(temp2);
                }
            }
        });
            
        letter.addAll(digit);
        
        return letter.toArray(new String[letter.size()]);
    }
}

/*
time O(n^2*logn) n==logs.length
space O(mn) m==logs[i].length
*/
