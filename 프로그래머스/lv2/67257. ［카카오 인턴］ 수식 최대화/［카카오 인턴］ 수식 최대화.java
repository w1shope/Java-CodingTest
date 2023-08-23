import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    public long solution(String expression) {

        // 연산자를 구분자로 사용하여 토큰 분리
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }

        // 연산자 3개로 만들 수 있는 연산자 조합, 우선순위 적용됨
        String[][] operators = {
                "+-*".split(""),
                "+*-".split(""),
                "-+*".split(""),
                "-*+".split(""),
                "*+-".split(""),
                "*-+".split("")
        };

        long max = 0;
        for (String[] operator : operators) {
            // 음수는 양수로 변경한다
            long result = Math.abs(calculator(operator, new ArrayList<>(list)));
            max = result > max ? result : max;
        }

        return max;
    }
    
    private long calculator(String[] operator, List<String> list) {
        // operator에는 연산자 우선순위가 적용된 연산자 조합이 저장되어 있다.
        for (String op : operator) {
            for (int i = 0; i < list.size(); i++) {
                if (op.equals(list.get(i))) {
                    long num1 = Long.parseLong(list.get(i - 1));
                    long num2 = Long.parseLong(list.get(i + 1));
                    long result = calculator(op, num1, num2);

                    // 위에서 계산한 값과 연산자 제거
                    list.remove(i - 1);
                    list.remove(i - 1);
                    list.remove(i - 1);
                    // 위에서 계산한 값 추가
                    list.add(i - 1, String.valueOf(result));
                    i -= 1;
                }
            }
        }
        return Long.parseLong(list.get(0));
    }

    // 계산
    private long calculator(String operator, long num1, long num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            default:
                return 0;
        }
    }
}