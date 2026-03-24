import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = convertMap(str1);
        Map<String, Integer> map2 = convertMap(str2);
        
        int intersection = 0;
        int union = 0;
        
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());
        
        for(String key : allKeys){
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            
            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }
        
        if(union == 0) return 1 * 65536;
        return (int)((double) intersection / union * 65536);
    }
    public Map<String, Integer> convertMap(String s){
        String str = s.toLowerCase();
        Map<String, Integer> map = new HashMap<>();
            
        for(int i = 0; i< str.length()-1; i++){
            if(Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i+1))){
                String key = "" + str.charAt(i) + str.charAt(i+1);
                map.put(key, map.getOrDefault(key, 0) +1);
            }
        }
        return map;
        
    }
}