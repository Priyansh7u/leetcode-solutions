var letterCombinations = function(digits) {
    if (!digits) return [];
    const map = {
        '2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
        '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'
    };
    const res = [];
    function dfs(i, str) {
        if (i === digits.length) {
            res.push(str);
            return;
        }
        for (const char of map[digits[i]]) {
            dfs(i + 1, str + char);
        }
    }
    dfs(0, "");
    return res;
};