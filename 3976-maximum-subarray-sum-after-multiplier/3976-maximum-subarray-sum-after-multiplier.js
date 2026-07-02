var maxSubarraySum = function(nums, k) {
    let solve = (isDivide) => {
        let dp0 = -Infinity, dp1 = -Infinity, dp2 = -Infinity;
        let maxAns = -Infinity;
        for (let x of nums) {
            let alt = isDivide ? (x > 0 ? Math.floor(x / k) : Math.ceil(x / k)) : x * k;
            dp2 = Math.max(x, dp2 + x, dp1 + x);
            dp1 = Math.max(alt, dp1 + alt, dp0 + alt);
            dp0 = Math.max(x, dp0 + x);
            maxAns = Math.max(maxAns, dp0, dp1, dp2);
        }
        return maxAns;
    };
    return Math.max(solve(false), solve(true));
};