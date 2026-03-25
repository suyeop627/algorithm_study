import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        Map<Character, Integer> moums = Map.of(
            'A', 0,
            'E', 1,
            'I', 2,
            'O', 3,
            'U', 4
        );
        
        int[] candidatesCounts = new int[5];
        for(int i =0; i< 5; i++){
            for(int j  =0; j< 5-i; j++){
                candidatesCounts[i] += Math.pow(5,j);    
            }
        }
        
        for(int i = 0; i < word.length(); i++){
            answer += moums.get(word.charAt(i)) * candidatesCounts[i] + 1;
        }
        
        
        
        return answer;
    }
}