class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int[] left = {3, 0};
        int[] right = {3, 2};
        boolean isRightHander = hand.equals("right");

        for (int n : numbers) {
            switch(n){
                case 1,4,7:
                    answer.append("L");
                    left = getPosition(n);
                    break;
                case 3,6,9:
                    answer.append("R");
                    right = getPosition(n);
                    break;
                default:
                    int[] target = getPosition(n);

                    int leftDistance = getDistance(left, target);
                    int rightDistance = getDistance(right, target);

                    if (leftDistance < rightDistance) {
                        answer.append("L");
                        left = target;
                    } else if (leftDistance > rightDistance) {
                        answer.append("R");
                        right = target;
                    } else {
                        if (isRightHander) {
                            answer.append("R");
                            right = target;
                        } else {
                            answer.append("L");
                            left = target;
                        }
                    }
                }
            }
        return answer.toString();
    }

    private int[] getPosition(int n) {
        if (n == 0){
            return new int[]{3,1};  
        } 
        return new int[]{(n -1)/3, (n - 1)%3};
    }

    private int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] -b[0]) + Math.abs(a[1]- b[1]);
    }
}