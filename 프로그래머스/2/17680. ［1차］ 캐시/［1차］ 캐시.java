class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0) return cities.length * 5;
        
        String[] caches = new String[cacheSize];
        
        int cachedCount = 0;
        for(String city: cities){
            city = city.toLowerCase();
            int index = indexOf(caches, city);
            if(index == -1){
                answer+=5;
                
                if(cachedCount < cacheSize){
                    for(int i = cachedCount; i > 0; i-- ){
                        caches[i] = caches[i-1];
                    }      
                    caches[0] = city;
                    cachedCount++;
                }else{
                    for(int i = cacheSize-1; i > 0; i-- ){
                        caches[i] = caches[i-1];
                    }      
                    caches[0] = city;
                }
            } else{
                for(int i = index; i > 0; i-- ){
                    caches[i] = caches[i-1];
                }      
                caches[0] = city;
                answer++;
            }
            
        }
        return answer;
    }
    
    private int indexOf(String[] caches, String city){
        for(int i = 0; i < caches.length; i++){
            if(caches[i] != null && caches[i].equals(city)){
                return i;
            }
        }
        return -1;
    }
}