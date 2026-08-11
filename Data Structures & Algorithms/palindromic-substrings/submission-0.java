class Solution {
    public int countSubstrings(String s) {
        String ps = padString(s);
        int count = 0;

        int[] maxAtIndex = new int[ps.length()];
        int center = 0;
        int right = 0;

        for (int i = 1; i < ps.length() - 1; i++) {
            int mirror = center - (i - center);
            if (i < right) {
                maxAtIndex[i] = Math.min(right - i, maxAtIndex[mirror]);
            }

            while (ps.charAt(i + maxAtIndex[i] + 1) == ps.charAt(i - maxAtIndex[i] - 1)) {
                maxAtIndex[i]++;
            }

            if (i + maxAtIndex[i] > right) {
                center = i;
                right = i + maxAtIndex[i];
            }
            count += Math.ceilDiv(maxAtIndex[i], 2);
        }

        return count;
    }

    private String padString(String s) {
        StringBuilder sb = new StringBuilder("^");
        for (int i = 0; i < s.length(); i++) {
            sb.append('#').append(s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }
}
