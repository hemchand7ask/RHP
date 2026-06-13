import java.util.*;

public class Coffee_Coverage_Query {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input values
        System.out.print("Enter number of intervals (n): ");
        int n = sc.nextInt();

        System.out.print("Enter minimum coverage value (k): ");
        int k = sc.nextInt();

        System.out.print("Enter number of queries (q): ");
        int q = sc.nextInt();

        int MAX = 200000;

        // Difference array
        int[] diff = new int[MAX + 2];

        // Input intervals
        System.out.println("Enter interval ranges (l r):");
        for (int i = 0; i < n; i++) {

            int l = sc.nextInt();
            int r = sc.nextInt();

            diff[l]++;
            diff[r + 1]--;
        }

        // Prefix sum array
        int[] pref = new int[MAX + 1];

        int cover = 0;

        // Build coverage prefix array
        for (int i = 1; i <= MAX; i++) {

            cover += diff[i];

            if (cover >= k) {
                pref[i] = pref[i - 1] + 1;
            } else {
                pref[i] = pref[i - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        // Process queries
        System.out.println("Enter query ranges (a b):");

        while (q-- > 0) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            int result = pref[b] - pref[a - 1];

            sb.append(result).append("\n");
        }

        // Print all results
        System.out.println("Query Results:");
        System.out.print(sb);

        sc.close();
    }
}