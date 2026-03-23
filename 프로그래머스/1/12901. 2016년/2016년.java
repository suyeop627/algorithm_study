class Solution {
    public String solution(int a, int b) {
        String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        
        int[] dayCount = {-1, 31,29,31,30,31,30,31,31,30,31,30,31};
        int day = b;
        for(int i = 1; i < a; i++){
            day+=dayCount[i];
        }

        return days[(day - 1) % 7];
    }
}