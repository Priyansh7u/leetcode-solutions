var myAtoi = function(s) {
    let i = 0, n = s.length, sign = 1, res = 0;
    while (s[i] === " ") i++;
    if (s[i] === "+" || s[i] === "-") sign = s[i++] === "-" ? -1 : 1;
    while (i < n && s[i] >= "0" && s[i] <= "9") {
        res = res * 10 + (s[i++] - "0");
        if (sign * res <= -(2 ** 31)) return -(2 ** 31);
        if (sign * res >= 2 ** 31 - 1) return 2 ** 31 - 1;
    }
    return sign * res;
};