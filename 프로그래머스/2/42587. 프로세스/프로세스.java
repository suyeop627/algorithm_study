import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            queue.offer(new Process(priorities[i], i));
        }
        
        while(true){
            Process process = queue.poll();
            boolean existHiger = isExistHiger(queue, process);
            if(existHiger){
                queue.offer(process);
                continue;
            }
            answer++;
            if(location == process.location){
                break;
            }
        }
        return answer;
    }
    
    static class Process {
        int priority;
        int location;
        public Process(int p, int l){
            priority = p;
            location = l;
        }
    }
    public boolean isExistHiger(Queue<Process> queue, Process process){
        for(Process candidate : queue){
            if(candidate.priority > process.priority){
                return true;
            }
        }
        return false;
    }
}