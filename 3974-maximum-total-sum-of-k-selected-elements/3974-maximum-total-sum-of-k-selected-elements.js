var maxSum = function(nums, k, mul) {
    nums.sort((a, b) => b - a);
    let sum = 0;
    for (let i = 0; i < k; i++) {
        sum += nums[i] * Math.max(1, mul - i);
    }
    return sum;
};