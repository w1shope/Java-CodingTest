import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        List<Circle> circles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            int center = Integer.parseInt(inputs[0]);
            int radius = Integer.parseInt(inputs[1]);
            circles.add(new Circle(center - radius, center + radius));
        }

        Collections.sort(circles, (c1, c2) -> {
            if (c1.start == c2.start) {
                return c1.end - c2.end;
            }
            return c1.start - c2.start;
        });
        Stack<Circle> stack = new Stack<>();
        for (Circle circle : circles) {
            while (!stack.isEmpty() && stack.peek().end < circle.start) {
                stack.pop();
            }
            if (!stack.isEmpty() &&
                    (stack.peek().end >= circle.start && stack.peek().end <= circle.end)) {
                System.out.println("NO");
                return;
            }
            stack.push(circle);
        }

        System.out.println("YES");
    }

    static class Circle {
        int start;
        int end;

        public Circle(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}