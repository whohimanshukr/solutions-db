class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        
        return result;
    }
}
// Problem

// LeetCode #412 — Fizz Buzz

// Pattern

// Simulation / Basic iteration + conditionals

// Core idea

// Go through 1 → n once and decide what string belongs to each number.

// Important variables
// i      → current number we're processing
// result → list containing all answers
// Key decision
// if divisible by 3 AND 5 → "FizzBuzz"
// if divisible by 3       → "Fizz"
// if divisible by 5       → "Buzz"
// otherwise               → number as String
// Complexity
// Time:  O(n)
// Space: O(n)
// What I should remember

// Check the most specific condition first.
// For FizzBuzz, that means 3 AND 5 before checking 3 or 5 individually.

// And one Java takeaway from today:

// String.valueOf(i)

// converts an int into a String, while i.toString() doesn't work because int is a primitive.