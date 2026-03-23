import java.util.*;
class Solution {
    public int[] solution(int[] answers) {

        int[] scores = new int[3];
        for(int i = 0; i < answers.length; i++){
            if(isCorrect1(answers[i], i)){
                scores[0]++;
            }    
            if(isCorrect2(answers[i], i)){
                scores[1]++;
            }    
            if(isCorrect3(answers[i], i)){
                scores[2]++;
            }    
        }
        int max = Arrays.stream(scores).max().getAsInt();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < scores.length; i++){
            if(scores[i] == max){
                list.add(i+1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private boolean isCorrect1(int answer, int index){
        return (index % 5)+1 == answer;
    }
    
    private boolean isCorrect2(int answer, int index){
        if(index %2==0){
            return answer==2;
        }
        int[] candidates = {1,3,4,5};
        return candidates[(index /2) % 4] == answer;
    }
    
    private boolean isCorrect3(int answer, int index){
        int i = index %10;
        return switch(i){
            case 0,1-> answer==3;
            case 2,3-> answer==1;
            case 4,5-> answer==2;
            case 6,7-> answer==4;
            default-> answer==5;
        };
    }
}