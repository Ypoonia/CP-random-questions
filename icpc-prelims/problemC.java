import java.util.*;

public class problemC {
    static final int MAX_N = 2000000;
    static boolean[] isPrime = new boolean[MAX_N];
    static List<Integer> primes = new ArrayList<>();

    static void solve(int n, int k) {
        if (k > (long) n * (n - 1) / 2) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ptr = primes.size() - 1;
        while (n > 0) {
            if (k >= n - 1) {
                sb.append(primes.get(ptr--)).append(" ");
                k -= n - 1;
            } else {
                sb.append(2).append(" ");
            }
            n--;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < MAX_N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX_N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < MAX_N; i++) {
            if (isPrime[i]) primes.add(i);
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            solve(n, k);
        }
    }
}
