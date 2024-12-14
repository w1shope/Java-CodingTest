import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Set<String> strs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            strs.add(br.readLine());
        }

        int duplicateCnt = 0;
        for(int i = 0; i < M; i++) {
            if(strs.contains(br.readLine())) {
                duplicateCnt++;
            }
        }

        System.out.println(duplicateCnt);
    }
}