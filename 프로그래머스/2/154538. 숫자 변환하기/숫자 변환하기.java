import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});
        
        boolean[] visited = new boolean[y+1];
        visited[x] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int now = cur[0];
            int count = cur[1];
            
            if(now == y) {
                return count;
            }
            int[] nexts = {now + n, now * 2, now * 3};
            
            for(int next : nexts) {
                if(next <= y && !visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, count + 1});
                }
            }
        }
        return -1;
    }
}