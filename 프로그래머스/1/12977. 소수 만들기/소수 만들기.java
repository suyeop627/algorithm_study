class Solution {
    int[] combi = new int[3];
    int count = 0;
    public int solution(int[] nums) {
        dfs(nums, 0, 0);
        return count;
    }
    private void dfs(int[] nums, int start, int level){
        if(level == 3){
           int val = combi[0]+combi[1]+combi[2];
            if(isPrimeNumber(val)){
                count++;
            }
        }else{
            for(int i = start; i < nums.length; i++){
                combi[level] = nums[i];
                dfs(nums, i+1, level+1);
            }
        }
    }
    private boolean isPrimeNumber(int n){
        if(n < 2) return false;
        
        for(int i = 2; i*i <= n; i++){
            if(n %i ==0){
                return false;
            }
        }
        return true;
    }
}