import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "*+-", true);
        String[] operators = new String[]{"+*-", "+-*", "*-+", "*+-", "-+*", "-*+"};

        List<String> elements = new ArrayList<>();
        while (st.hasMoreTokens())
            elements.add(st.nextToken());

        long max = -1;
        for (String operator : operators) {
            long result = Math.abs(calculate(new ArrayList<>(elements), operator));
            max = result > max ? result : max;
        }
        
        return max;
    }

    private long calculate(List<String> elements, String operator) {
        for (char op : operator.toCharArray()) {
            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).charAt(0) == op) {
                    long num1 = Long.valueOf(elements.get(i - 1));
                    long num2 = Long.valueOf(elements.get(i + 1));
                    long result = calculate(num1, num2, op);

                    elements.remove(i - 1);
                    elements.remove(i - 1);
                    elements.remove(i - 1);
                    elements.add(i - 1, String.valueOf(result));
                    i -= 1;
                }
            }
        }
        return Long.valueOf(elements.get(0));
    }

    private long calculate(long num1, long num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            default:
                return num1 * num2;
        }
    }
}