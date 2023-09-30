import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static List<String[]> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            students.add(br.readLine().split(" "));

        Collections.sort(students, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
                    if (Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
                        if (Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])) {
                            return o1[0].compareTo(o2[0]);
                        }
                        return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                    }
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                }
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        });

        for (int i = 0; i < n; i++) {
            sb.append(students.get(i)[0] + "\n");
        }

        System.out.println(sb);
    }
}