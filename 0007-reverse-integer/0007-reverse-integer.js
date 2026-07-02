var reverse = function(x) {
    let s = x < 0 ? -1 : 1;
    let n = Math.abs(x), r = 0;
    while (n) {
        r = r * 10 + n % 10;
        n = Math.floor(n / 10);
    }
    r *= s;
    return r < -(2 ** 31) || r > 2 ** 31 - 1 ? 0 : r;
};