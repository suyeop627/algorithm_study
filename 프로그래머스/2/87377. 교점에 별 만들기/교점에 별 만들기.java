import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        List<int[]> list = new ArrayList<>();
        
        for(int i =0; i < line.length-1 ;i++){
            for(int j = i+1; j < line.length; j++){
                int[] line1 = line[i];
                int[] line2 = line[j];
                long tmp = (long)line1[0] * line2[1] - line1[1] * line2[0];
                
                if(tmp ==0) continue;
                
                long x = (long)line1[1] * line2[2] - line1[2] * line2[1];
                long y = (long)line1[2] * line2[0] - line1[0] * line2[2];
                
                
                if(x % tmp != 0 || y %tmp != 0) continue;
                int xIndex = (int) (x/tmp);
                int yIndex = (int) (y/tmp);
                
                list.add(new int[]{xIndex, yIndex});
            }
        }
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int[] p : list){
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            minY = Math.min(minY, p[1]);
            maxY = Math.max(maxY, p[1]);
        }

        int height = maxY - minY + 1;
        int width = maxX - minX + 1;

        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = ".".repeat(width);
        }
        
        
        for(int[] point : list){
            int x = point[0] - minX;
            int y = maxY - point[1];
            answer[y] = answer[y].substring(0, x) + "*" + answer[y].substring(x+1);
        }
        
        return answer;
    }
}