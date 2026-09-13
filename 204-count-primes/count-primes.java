import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        // Edge Case: 0, 1, and negative numbers are not prime.
        // There are zero primes strictly less than 2.
        if (n <= 2) {
            return 0;
        }

        // isPrime[x] represents whether integer x is prime.
        // Allocated to size n so valid indices run from 0 to n - 1.
        boolean[] isPrime = new boolean[n];

        // Java booleans default to false; initialize candidate range to true.
        Arrays.fill(isPrime, true);

        // 0 and 1 are explicitly non-prime.
        isPrime[0] = false;
        isPrime[1] = false;

        // Outer loop: Only need to check candidates up to sqrt(n).
        // If a number has a factor larger than sqrt(n), its counterpart is below sqrt(n).
        for (int i = 2; i * i < n; i++) {
            // If isPrime[i] is true, i is prime; eliminate all of its multiples.
            if (isPrime[i]) {
                // Start marking at i * i because all smaller multiples (2*i, 3*i, ...)
                // have already been eliminated by earlier prime factors.
                // Increment by i each step to jump directly to the next multiple.
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false; // Mark composite
                }
            }
        }

        // Tally pass: Count every index that survived the sieve.
        // Start at 2 since indices 0 and 1 are already confirmed false.
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
/**
 * Problem:          LeetCode #204 — Count Primes
 * Pattern:          Sieve of Eratosthenes
 * 
 * Core Idea:
 * Instead of checking divisibility for every number one-by-one, assume all
 * numbers are prime, identify primes in order, and cross out (sieve) their
 * multiples in bulk.
 * 
 * Important Variables:
 * - isPrime[] : Tracks the status of each integer; true = prime, false = composite.
 * - i         : The current prime candidate being checked.
 * - j         : Pointer iterating over the multiples of i to mark them false.
 * - count     : Accumulator tallying all verified prime numbers strictly less than n.
 * 
 * Key Decisions:
 * - if (n <= 2) return 0    -> 0 and 1 are non-prime; count strictly below 2 is zero.
 * - i * i < n               -> Factor pairs mirror after sqrt(n); stop outer loop there.
 * - j = i * i               -> Multiples smaller than i^2 were already crossed out by 
 *                              smaller primes (e.g., for 5: 10, 15, 20 eliminated by 2 & 3).
 * - j += i                  -> Step size equals i to land directly on consecutive multiples.
 * 
 * Complexity:
 * - Time Complexity:  O(n log log n) -> Prime harmonic series sum of multiples.
 * - Space Complexity: O(n)           -> Auxiliary boolean array of length n.
 * 
 * What to Remember:
 * Bulk range primality calls for a boolean sieve, not individual trial division.
 * ============================================================================
 */