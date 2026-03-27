class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String tree : skill_trees){
            String remained = tree.replaceAll("[^"+skill +"]", "");
            boolean isRight = true;
            for(int i = 0; i< remained.length(); i++){
                if(remained.charAt(i) != skill.charAt(i)){
                    isRight = false;
                }
            }
            if(isRight) answer++;
        }
        return answer;
    }
}