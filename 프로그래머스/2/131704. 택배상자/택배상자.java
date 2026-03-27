import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Deque<Integer> subBelt = new ArrayDeque<>();
        int orderIndex = 0;
        int mainBeltItem = 1;

        while (orderIndex < order.length) {
            if (!subBelt.isEmpty() && subBelt.peek() == order[orderIndex]) {
                subBelt.pop();
                answer++;
                orderIndex++;
            } else if (mainBeltItem <= order.length) {
                if (mainBeltItem == order[orderIndex]) {
                    answer++;
                    orderIndex++;
                } else {
                    subBelt.push(mainBeltItem);
                }
                mainBeltItem++;
            } else {
                break;
            }
        }

        return answer;
    }
}