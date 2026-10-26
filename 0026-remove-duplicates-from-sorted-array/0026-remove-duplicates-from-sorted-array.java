class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int slow = 0; // Points to the last unique element
        
        for (int fast = 1; fast < nums.length; fast++) {
            // If a new unique element is found
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        
        // Return the count of unique elements
        return slow + 1;
    }
}