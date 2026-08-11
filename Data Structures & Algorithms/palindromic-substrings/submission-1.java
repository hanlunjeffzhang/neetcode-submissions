class Solution {
    public int countSubstrings(String s) {
        String ps = padString(s);
        int[] radius = new int[ps.length()];
        
        int center = 0;
        int right = 0;
        int count = 0;

        for (int i = 1; i < ps.length() - 1; i++) {
            int mirror = center - (i - center);
            if (i < right) {
                radius[i] = Math.min(radius[mirror], right - i);
            }

            while (ps.charAt(i + radius[i] + 1) == ps.charAt(i - radius[i] - 1)) {
                radius[i]++;
            }

            if (radius[i] + i > right) {
                right = radius[i] + i;
                center = i;
            }

            count += Math.ceilDiv(radius[i], 2);
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
