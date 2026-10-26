class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        // If needle is longer than haystack, it cannot be contained within it
        if (m > n) {
            return -1;
        }
        
        // Slide the window over the haystack
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            // Check characters match for the current window
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            // If we matched the entire needle, return the starting index
            if (j == m) {
                return i;
            }
        }
        
        return -1;
    }
}