class Solution {
    public int reverse(int x) {

        // Use long so rev has enough space while we build the reversed number.
        // The final answer still needs to be an int.
        long rev = 0;

        while (x != 0) {

            // x % 10 → extracts the last digit of x
            // rev * 10 → shifts existing digits one place to the left
            // + x % 10 → adds the extracted digit
            //
            // Example:
            // x = 123
            // rev = 0 → 3 → 32 → 321
            rev = rev * 10 + x % 10;

            // Removes the last digit from x.
            // Example: 123 → 12 → 1 → 0
            x = x / 10;
        }

        // Java int range:
        // -2,147,483,648 to 2,147,483,647
        //
        // If the reversed number is outside this range,
        // LeetCode wants us to return 0.
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }

        // rev is now guaranteed to fit inside an int,
        // so converting long → int is safe.
        return (int) rev;
    }
}