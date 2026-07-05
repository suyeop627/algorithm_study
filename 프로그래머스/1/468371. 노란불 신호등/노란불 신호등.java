class Solution {
    public int solution(int[][] signals) {

        long total = 1; //total : 모든 신호가 초기상태(초록불)로 돌아오는 최소 시각

        for (int[] signal : signals) {
            int period = signal[0] + signal[1] + signal[2];//초록-노랑-빨강 합한 주기
            total = lcm(total, period);
        }


        for (int time = 1; time <= total; time++) {
            boolean allYellow = true;

            for (int[] signal : signals) {
                if (!isYellow(time, signal)) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return time;
            }
        }
        return -1;
    }

    // 시각 t에 이 신호등이 노란불인지 판정
    private boolean isYellow(int time, int[] signal) {
        int green = signal[0], yellow = signal[1], red = signal[2];
        int period = green + yellow + red; //이 신호등의 주기
        
        int pos = (time - 1) % period + 1;
        return pos > green && pos <= green + yellow;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}