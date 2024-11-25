package icpc-prelims;

import java.util.*;

public class problemB {
    public static void solve(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        List<int[]> constraints = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int left = in.nextInt();
            int right = in.nextInt();
            int value = in.nextInt();
            constraints.add(new int[]{value, left, right});
        }

        constraints.sort(Comparator.comparingInt(x -> x[0]));
       List<Integer> result = new ArrayList<>(Collections.nCopies(n + 1, 1));

        for (int[] constraint : constraints) {
            int value = constraint[0];
            int left = constraint[1];
            int right = constraint[2];
            int minValue = Integer.MAX_VALUE;

            for (int i = left; i <= right; i++) {
                minValue = Math.min(minValue, result.get(i));
            }

            if (minValue == value) {
                for (int i = left; i <= right; i++) {
                    if (result.get(i) < n && result.get(i) == value) {
                        result.set(i, result.get(i) + 1);
                    }
                }
            }
        }

        for (int[] constraint : constraints) {
            int value = constraint[0];
            int left = constraint[1];
            int right = constraint[2];
            int minValue = Integer.MAX_VALUE;

            for (int i = left; i <= right; i++) {
                minValue = Math.min(minValue, result.get(i));
            }

            if (minValue == value) {
                System.out.println("-1");
                return;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {
            solve(in);
        }
    }
}

