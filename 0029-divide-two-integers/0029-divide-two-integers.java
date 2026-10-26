class Solution {
    public int divide(int dividend, int divisor) {
        // Handle special overflow case: Integer.MIN_VALUE / -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine the sign of the final quotient
        boolean negative = (dividend < 0) ^ (divisor < 0);
        
        // Convert to long to prevent overflow during absolute value conversion
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        
        int quotient = 0;
        
        // Subtract divisor multiplied by powers of 2 from dividend
        while (dvd >= dvs) {
            long temp = dvs;
            long multiple = 1;
            
            // Double the divisor and the multiple as long as it fits into the remaining dividend
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            
            dvd -= temp;
            quotient += multiple;
        }
        
        return negative ? -quotient : quotient;
    }
}