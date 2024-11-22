import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Boolean> map = new HashMap<>();
        for (String number : phone_book) {
            map.put(number, true);
        }

        for (String number : phone_book) {
            for (int length = 1; length < number.length(); length++) {
                if (map.containsKey(number.substring(0, length))) {
                    return false;
                }
            }
        }
        return true;
    }
}