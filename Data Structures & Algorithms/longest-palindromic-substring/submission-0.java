class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder("^");
        int len = s.length();
        for (int i = 0; i < len; i++) {
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#$");
        String ns = sb.toString();
        System.out.println(ns);

        int[] radius = new int[ns.length()];
        int currCenter = 0;
        int currRight = 0;
        int centerAtMax = 0;
        int maxRadius = 0;

        for (int i = 1; i < ns.length() - 1; i++) {
            int mirror = currCenter - (i - currCenter);
            if (i < currRight) {
                radius[i] = Math.min(currRight - i, radius[mirror]);
            }

            while (ns.charAt(i + radius[i] + 1) == ns.charAt(i - radius[i] - 1)) {
                radius[i]++;
            }

            if (i + radius[i] > currRight) {
                currCenter = i;
                currRight = i + radius[i];
            }

            if (radius[i] > maxRadius) {
                maxRadius = radius[i];
                centerAtMax = i;
            }
        }

        int start = (centerAtMax - maxRadius) / 2;
        return s.substring(start, start + maxRadius);
    }
}
