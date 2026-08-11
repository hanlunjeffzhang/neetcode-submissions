class Solution {
    public String longestPalindrome(String s) {
        String ps = padString(s);
        int[] radius = new int[ps.length()];

        int center = 0;
        int right = 0;
        int maxRadius = 0;
        int centerAtMax = 0;

        for (int i = 1; i < ps.length() - 1; i++) {
            int mirror = center - (i - center);

            if (i < right) {
                radius[i] = Math.min(right - i, radius[mirror]);
            }

            while (ps.charAt(i + radius[i] + 1) == ps.charAt(i - radius[i] - 1)) {
                radius[i]++;
            }

            if (i + radius[i] > right) {
                center = i;
                right = radius[i] + i;
            }

            if (radius[i] > maxRadius) {
                centerAtMax = i;
                maxRadius = radius[i];
            }
        }

        int start = (centerAtMax - maxRadius) / 2;
        return s.substring(start, start + maxRadius);
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
