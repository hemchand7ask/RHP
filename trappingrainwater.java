import java.util.*;

public class Rain_Water_Trap {

    // Function to calculate trapped rain water
    public static int trap(int[] height) {

        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int max = 0;

        // Find left maximum for each index
        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }

        max = 0;

        // Find right maximum for each index
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }

        int water = 0;

        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }

        return water;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of inputs: ");
        int n = sc.nextInt();

        int[] height = new int[n];

        System.out.println("Enter the height levels:");

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int result = trap(height);

        System.out.println("The amount of water trapped is: " + result);

        sc.close();
    }
}