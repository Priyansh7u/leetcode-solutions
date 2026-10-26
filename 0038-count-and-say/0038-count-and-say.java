class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        
        String result = "1";
        
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int length = result.length();
            int count = 1;
            
            for (int j = 1; j < length; j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(result.charAt(j - 1));
                    count = 1; // Reset count for the new digit
                }
            }
            // Append the final group
            sb.append(count).append(result.charAt(length - 1));
            result = sb.toString();
        }
        
        return result;
    }
}