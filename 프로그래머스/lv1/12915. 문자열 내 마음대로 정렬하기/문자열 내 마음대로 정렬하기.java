import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] strings, int n) {

        return Arrays.stream(strings).sorted((s1, s2) -> {
            if (s1.charAt(n) == s2.charAt(n))
                return s1.compareTo(s2);
            return s1.charAt(n) - s2.charAt(n);
        }).collect(Collectors.joining(" ")).split(" ");
    }
}