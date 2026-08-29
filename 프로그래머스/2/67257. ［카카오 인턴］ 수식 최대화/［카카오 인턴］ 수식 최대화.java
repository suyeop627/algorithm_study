import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        String[] operations = {
            "+-*",
            "+*-",
            "*+-",
            "*-+",
            "-+*",
            "-*+"
        };
        List<String> splitted = new ArrayList<>();

        String temp = "";
        for(char c : expression.toCharArray()){
            if(Character.isDigit(c)){
                temp+=c;
            }else{
                splitted.add(temp);
                splitted.add(c+"");
                temp="";
            }
        }
        splitted.add(temp);

        for(String operation : operations){
            //요소 조작하는게 다음 순회에 영향 없게 복사해서 사용
            List<String> copied = new ArrayList<>(splitted); 
            for(char op : operation.toCharArray()){
                for(int i = 0; i < copied.size(); i++){
                    if(copied.get(i).equals(op+"")){
                        long left  = Long.parseLong(copied.get(i-1));
                        long right = Long.parseLong(copied.get(i+1));
                        long result = 0;
                        if(op == '+'){
                            result = left + right;
                        } else if(op == '-'){
                            result = left - right;
                        } else{
                            result= left * right;
                        }
                        copied.set(i-1, result+"");// left 를 결과로 대체
                        copied.remove(i);//기존 연산자 요소 지움
                        copied.remove(i);//기존 right 요소 지움
                        //위 로직 타고나면 i--하지 않으면 op 하나를 건너뛰게되므로 보정
                        // 1 + 2 + 3 -> 3 + 3
                        // 0 1 2 3 4 -> 0 1 2
                        //   i              i (i--하지 않으면 인덱스 2로 넘어감)                       
                        i--; 
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(copied.get(0))));
        }

        return answer;
    }
}