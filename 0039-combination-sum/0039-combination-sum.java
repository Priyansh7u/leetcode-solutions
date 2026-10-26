import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> result;
    private int[] nums;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        this.nums = candidates;
        backtrack(target, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int target, int start, List<Integer> currentList) {
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                break; // Early pruning: sorted array prevents further checks
            }
            
            currentList.add(nums[i]);
            backtrack(target - nums[i], i, currentList);
            currentList.remove(currentList.size() - 1); // Backtrack
        }
    }
}