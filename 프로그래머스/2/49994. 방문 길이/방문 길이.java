import java.util.*;
class Solution {
    int[] now = {0,0};
    Set<String> histories = new HashSet<>();
    
    public int solution(String dirs) {
        for(char dir : dirs.toCharArray()){
            goTo(dir);
        }
        
        return histories.size()/2;
    }
    private void goTo(char dir){
        int[] to = new int[2];
        switch(dir){
            case 'U': 
                to[0] = now[0]-1;
                to[1] = now[1];
                break;
            case 'D': 
                to[0] = now[0]+1;
                to[1] = now[1];
                break;
            case 'L': 
                to[0] = now[0];
                to[1] = now[1]-1;
                break;
            case 'R': 
                to[0] = now[0];
                to[1] = now[1]+1;
                break;
        }
        if(Math.abs(to[0]) > 5 || Math.abs(to[1]) > 5 ){
            return;
        }
        String path1 = String.format("%d,%d-%d,%d", now[0], now[1], to[0], to[1]);
        String path2 = String.format("%d,%d-%d,%d", to[0], to[1], now[0], now[1]);
        histories.add(path1);
        histories.add(path2);
        now= to;
    }
}