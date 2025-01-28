import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list.add(0);
        list.add(1);
        while (list.size() <= N) {
            int size = list.size();
            list.add(list.get(size - 2) + list.get(size - 1));
        }

        System.out.println(list.get(N));
    }
}