import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(String numbers) {
        List<Integer> nums = numbers.chars().boxed().map(c -> Character.getNumericValue(c)).collect(Collectors.toList());
        return getPrimes(0, nums).size();
    }

    private boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private Set<Integer> getPrimes(int num, List<Integer> nums) {
        Set<Integer> primes = new HashSet<>();
        if(isPrime(num))
            primes.add(num);

        for(int i = 0; i < nums.size(); i++) {
            int acc = num * 10 + nums.get(i);
            List<Integer> remainNums = new ArrayList<>(nums);
            remainNums.remove(i);
            primes.addAll(getPrimes(acc, remainNums));
        }

        return primes;
    }
}