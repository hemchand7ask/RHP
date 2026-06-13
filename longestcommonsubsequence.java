import java.util.*;

class LongestCommonSubsequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input strings
        System.out.println("Enter the first string:");
        String str1 = sc.nextLine();

        System.out.println("Enter the second string:");
        String str2 = sc.nextLine();

        int n = str1.length();
        int m = str2.length();

        // DP Table
        int[][] dp = new int[n + 1][m + 1];

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If characters match
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                // Take maximum of left or top
                else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }

        // Reconstruct Longest Common Subsequence
        int i = n, j = m;
        StringBuilder result = new StringBuilder();

        while (i > 0 && j > 0) {

            // Character matched
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.append(str1.charAt(i - 1));
                i--;
                j--;
            }

            // Move in direction of larger value
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // Reverse because constructed backwards
        result.reverse();

        // Print DP table
        System.out.println("\nDP Table:");
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // Output
        System.out.println("\nLength of Longest Common Subsequence: "
                + dp[n][m]);

        System.out.println("Longest Common Subsequence: "
                + result);

        sc.close();
    }
}