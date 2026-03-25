import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        int index = 1;
        for(char c = 'A'; c <= 'Z'; c++){
            map.put(String.valueOf(c), index++);
        }
        
        for(int i = 0; i < msg.length(); ){
            String word = "" + msg.charAt(i);
            int j = i + 1;
            
            while(j <= msg.length() && map.containsKey(msg.substring(i, j))){
                word = msg.substring(i, j);
                j++;
            }
            result.add(map.get(word));
            if(j <= msg.length()){
                map.put(msg.substring(i, j), index++);
            }
            
            i += word.length();
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}