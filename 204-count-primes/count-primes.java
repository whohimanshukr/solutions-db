class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        // Java booleans default to false (false = prime, true = composite).
        // This removes the heavy Arrays.fill() overhead entirely.
        boolean[] isComposite = new boolean[n];

        // Start with count = 1 to account for 2 (the only even prime).
        int count = 1;

        // Loop only through odd numbers (3, 5, 7, ...).
        for (int i = 3; i < n; i += 2) {
            if (!isComposite[i]) {
                count++; // Count directly in the same pass (no second loop needed)

                // Only sieve multiples if i * i < n
                // Cast to long to prevent integer overflow for large i
                if ((long) i * i < n) {
                    // Step by 2 * i to skip even multiples:
                    // (odd * odd = odd; odd + odd = even; odd + 2*odd = next odd multiple)
                    for (int j = i * i; j < n; j += 2 * i) {
                        isComposite[j] = true;
                    }
                }
            }
        }

        return count;
    }
}