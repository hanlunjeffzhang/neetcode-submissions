class Solution {
    public int countSubstrings(String s) {
        int[] radius = new int[s.length() * 2 + 3];
        String str = padString(s);

        int count = 0;
        int center = 0;
        int right = 0;

        for (int i = 1; i < radius.length - 1; i++) {
            int mirror = center - (i - center);
            if (i < right) {
                radius[i] = Math.min(right - i, radius[mirror]);
            }

            while (str.charAt(i + radius[i] + 1) == str.charAt(i - radius[i] - 1)) {
                radius[i]++;
            }

            if (i + radius[i] > right) {
                right = i + radius[i];
                center = i;
            }
            count += Math.ceilDiv(radius[i], 2);
        }
        return count;
    }

    private String padString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }
}
