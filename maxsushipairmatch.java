import java.util.*;

class Sushi_Matching {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of Shari and Neta
        System.out.print("Enter number of Shari: ");
        int n = sc.nextInt();

        System.out.print("Enter number of Neta: ");
        int m = sc.nextInt();

        // Arrays for weights
        int[] shari = new int[n];
        int[] neta = new int[m];

        // Input Shari weights
        System.out.println("Enter weights of Shari:");
        for (int i = 0; i < n; i++) {
            shari[i] = sc.nextInt();
        }

        // Input Neta weights
        System.out.println("Enter weights of Neta:");
        for (int i = 0; i < m; i++) {
            neta[i] = sc.nextInt();
        }

        // Sort both arrays
        Arrays.sort(shari);
        Arrays.sort(neta);

        int count = 0;

        int i = m - 1; // Pointer for neta
        int j = n - 1; // Pointer for shari

        // Match sushi based on condition
        while (i >= 0 && j >= 0) {

            if (neta[i] <= (2 * shari[j])) {
                count++;
                i--;
                j--;
            } else {
                i--;
            }
        }

        // Output result
        System.out.println("Total number of sushi pairs is: " + count);

        sc.close();
    }
}