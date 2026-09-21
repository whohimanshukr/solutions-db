/*
 * ============================================================================
 * MEMORY CARD
 * ============================================================================
 * Problem: LeetCode #78 — Subsets
 * Pattern: Backtracking (Pick / Don't Pick Decision Tree)
 * 
 * Core Idea:
 * For every element, make two distinct recursive decisions: either include 
 * the element in the current subset or exclude it. When the index reaches the 
 * end of the array, record a snapshot of the subset.
 * 
 * Important Variables:
 * - index   -> Current element in nums being evaluated (0 to nums.length).
 * - current -> Dynamic list maintaining the current subset state.
 * - result  -> Master list storing snapshots of all valid subsets.
 * 
 * Key Decisions:
 * - if (index == nums.length)            -> Base case: add new ArrayList<>(current) to result.
 * - current.add(nums[index])             -> Pick branch: include element and advance (index + 1).
 * - current.remove(current.size() - 1)   -> Backtrack: undo the choice to explore Don't Pick.
 * 
 * Complexity:
 * - Time:  O(N * 2^N) -> 2^N total subsets, and each subset takes up to O(N) to copy.
 * - Space: O(N)       -> Auxiliary space for call stack depth and current subset buffer.
 * 
 * What I should remember:
 * When adding mutable objects (like ArrayList) to a result list during recursion, 
 * always pass a deep copy (new ArrayList<>(current)), otherwise future mutations 
 * and backtracking will overwrite the recorded answer.
 * ============================================================================
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, current, result);

        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Base case: All elements have been evaluated
        if (index == nums.length) {
            // Save a snapshot of the current subset
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Include nums[index] (Pick)
        current.add(nums[index]);
        backtrack(index + 1, nums, current, result);

        // Undo choice: Backtrack
        current.remove(current.size() - 1);

        // Choice 2: Exclude nums[index] (Don't Pick)
        backtrack(index + 1, nums, current, result);
    }
}