class Solution {
    public int[] solution(long n) {
        StringBuffer sb = new StringBuffer();

        String[] split = String.valueOf(n).split("");
        for (String s : split)
            sb.append(s);

        return sb.reverse().toString().chars().map(num -> Character.getNumericValue(num)).toArray();
    }
}