import java.util.*;

public class problemA{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            solve(in, sb);
        }

        System.out.print(sb);
    }

    private static void solve(Scanner in, StringBuilder sb) {
        int n = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        List<Integer> ans = new ArrayList<>();
        int cur = (1 << 30) - 1;

        for (int i = 0; i < n; i++) {
            if ((arr[i] & k) == k) {
                ans.add(i + 1);
                cur &= arr[i];
            }
        }

        if (cur == k) {
            sb.append("YES\n");
            sb.append(ans.size()).append('\n');
            for (int index : ans) {
                sb.append(index).append(' ');
            }
            sb.append('\n');
        } else {
            sb.append("NO\n");
        }
    }
}
