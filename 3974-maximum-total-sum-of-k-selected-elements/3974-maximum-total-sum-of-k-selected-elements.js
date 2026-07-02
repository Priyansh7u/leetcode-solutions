var maxSum = function(nums, k, mul) {
    nums.sort((a, b) => b - a);
    let sum = 0;
    for (let i = 0; i < k; i++) {
        if (mul - i > 1) {
            sum += nums[i] * (mul - i);
        } else {
            sum += nums[i];
        }
    }
    return sum;
};