import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int deleteCount = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            list.add(i);
        }

        while (true) {
            int primeNumber = -1;
            for (int i = 0; i < list.size(); i++) {
                if (isPrimeNumber(list.get(i))) {
                    primeNumber = list.get(i);
                    break;
                }
            }

            Iterator<Integer> iter = list.iterator();
            while (iter.hasNext()) {
                int num = iter.next();
                if (num % primeNumber == 0) {
                    iter.remove();
                    deleteCount++;
                }

                if (deleteCount == K) {
                    System.out.println(num);
                    return;
                }
            }
        }
    }

    static boolean isPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}