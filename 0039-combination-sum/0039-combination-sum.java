import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to enable early pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> currentList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentList)); // Only copy when a valid combination is found
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break; // Stop iteration since elements are sorted and will exceed target
            }
            
            currentList.add(candidates[i]);
            // Pass 'i' instead of 'i + 1' to allow reusing the same element
            backtrack(candidates, target - candidates[i], i, currentList, result);
            currentList.remove(currentList.size() - 1); // Backtrack
        }
    }
}