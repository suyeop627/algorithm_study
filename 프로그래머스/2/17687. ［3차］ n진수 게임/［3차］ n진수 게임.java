import java.lang.StringBuilder;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int num  = 0;
        while(sb.length() < t * m){
            sb.append(Integer.toString(num++, n));
        }
        String str = sb.toString();
        StringBuilder answerSb = new StringBuilder();
        for(int i = 1; i<= t; i++){
            answerSb.append(str.charAt(m * (i-1)  + p-1));
        }
        
        return answerSb.toString().toUpperCase();
    }
}