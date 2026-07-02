/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    if (s.length < 2) return s;

    let start = 0;
    let maxLen = 1;

    function expand(left, right) {
        while (
            left >= 0 &&
            right < s.length &&
            s[left] === s[right]
        ) {
            left--;
            right++;
        }

        const len = right - left - 1;

        if (len > maxLen) {
            maxLen = len;
            start = left + 1;
        }
    }

    for (let i = 0; i < s.length; i++) {
        // Odd-length palindrome
        expand(i, i);

        // Even-length palindrome
        expand(i, i + 1);
    }

    return s.substring(start, start + maxLen);
};