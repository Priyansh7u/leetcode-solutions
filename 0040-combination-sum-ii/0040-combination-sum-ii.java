import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates and enable pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> currentList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentList)); // Add a copy of the valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicate elements at the same depth to prevent duplicate combinations
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // Early pruning: since array is sorted, if current number exceeds target, stop
            if (candidates[i] > target) {
                break;
            }

            currentList.add(candidates[i]);
            // Use i + 1 because each element can be used only once
            backtrack(candidates, target - candidates[i], i + 1, currentList, result);
            currentList.remove(currentList.size() - 1); // Backtrack
        }
    }
}