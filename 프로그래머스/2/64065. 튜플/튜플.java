import java.util.*;

class Solution {
    public int[] solution(String s) {

        String[] arr = Arrays.stream(s.split("},\\{"))
                .map(str -> str.replace("{", "").replace("}", ""))
                .sorted((a,b) -> a.length() - b.length())
                .toArray(String[]::new);

        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (String e : arr) {
            for (String num : e.split(",")) {
                int value = Integer.parseInt(num);

                if (!set.contains(value)) {
                    set.add(value);
                    result.add(value);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}