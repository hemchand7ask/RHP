import java.util.*;
public class Disjointset {
    static int find(int[] ldr, int i) {
        if (ldr[i] != i) {
            ldr[i] = find(ldr, ldr[i]);
        }
        return ldr[i];
    }
    static void join(int[] ldr, int l, int r) {
        int x = find(ldr, l);
        int y = find(ldr, r);
        ldr[y] = x;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ldr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ldr[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            join(ldr, l, r);
        }
        Set<Integer> s = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            s.add(find(ldr, i));
        }
        System.out.println(s.size());
        sc.close();
    }
}
