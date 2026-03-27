import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> carToTotalTime = new HashMap<>();
        Map<String, Integer> carToInTime = new HashMap<>();
        
        for (String record : records) {
            String[] parts = record.split(" ");
            String timeStr = parts[0];
            String car = parts[1];
            String inOut = parts[2];
            
            int time = Integer.parseInt(timeStr.substring(0,2)) * 60
                     + Integer.parseInt(timeStr.substring(3,5));
            
            if(inOut.equals("IN")){
                carToInTime.put(car, time);
            } else {
                int intTime = carToInTime.remove(car);
                carToTotalTime.put(
                    car, 
                    carToTotalTime.getOrDefault(car,0) + (time - intTime)
                );
            }
        }
        
        for(String car : carToInTime.keySet()){
            int intTime = carToInTime.get(car);
            int outTime = 23*60 + 59;
            carToTotalTime.put(
                car, 
                carToTotalTime.getOrDefault(car,0) + (outTime - intTime)
            );
        }

        List<String> cars = new ArrayList<>(carToTotalTime.keySet());
        return cars.stream()
            .sorted()
            .mapToInt(car -> {
                int totalTime = carToTotalTime.get(car);
                if(totalTime <= fees[0]){
                    return fees[1];
                }else{
                    return fees[1] + (int)Math.ceil((double)(totalTime-fees[0]) / fees[2]) * fees[3];
                }
            })
            .toArray();
    }
}