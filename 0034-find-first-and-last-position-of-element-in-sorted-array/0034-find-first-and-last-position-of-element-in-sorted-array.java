class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        
        // Find the starting position
        result[0] = findBound(nums, target, true);
        
        // If the starting position is -1, the target doesn't exist, so we can skip finding the last position
        if (result[0] != -1) {
            result[1] = findBound(nums, target, false);
        }
        
        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    right = mid - 1; // Search towards the left for the first occurrence
                } else {
                    left = mid + 1;  // Search towards the right for the last occurrence
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bound;
    }
}