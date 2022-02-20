class Solution {
    public String[] reorderLogFiles(String[] logs) {
        //log 분류(letter, digit)
        
        List<String> dig = new ArrayList<>();
        List<String> let = new ArrayList<>();
        
        for(int i = 0; i < logs.length; i++) {
            String[] log = logs[i].split(" ");
            
            if(Character.isDigit(log[1].charAt(0)))
                dig.add(logs[i]);
            else
                let.add(logs[i]);
        }
        
        Collections.sort(let, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String temp1 = s1.substring(s1.indexOf(" ") + 1);
                String temp2 = s2.substring(s2.indexOf(" ") + 1);
                
                if(temp1.equals(temp2))
                    return s1.split(" ")[0].compareTo(s2.split(" ")[0]);
                else
                    return temp1.compareTo(temp2);
            }
        });
        
        let.addAll(dig);
        
        return let.toArray(new String[let.size()]);
        
    }
}

/*

*/