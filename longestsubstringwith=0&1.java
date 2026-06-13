import java.util.*;

class Dp_Longest_Substring_Equal_0s_1s {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string of 0's and 1's: ");
        String s = sc.nextLine();

        int n = s.length();

        // DP array to store prefix sum
        int[] dp = new int[n];

        // HashMap to store first occurrence of prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case
        map.put(0, -1);

        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            // Convert '1' to +1 and '0' to -1
            int value = (s.charAt(i) == '1') ? 1 : -1;

            // Build prefix sum using DP
            if (i == 0) {
                dp[i] = value;
            } else {
                dp[i] = dp[i - 1] + value;
            }

            // If prefix sum already exists
            if (map.containsKey(dp[i])) {

                int len = i - map.get(dp[i]);
                maxLen = Math.max(maxLen, len);

            } else {

                // Store first occurrence
                map.put(dp[i], i);
            }
        }

        System.out.println("Maximum substring length = " + maxLen);

        sc.close();
    }
}