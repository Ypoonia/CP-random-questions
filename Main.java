import java.awt.event.MouseAdapter;
import java.io.*;
import java.lang.reflect.Array;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.math.BigDecimal;


// हर हर महादेव
// हरे कृष्णा
public class Main {
    static Scanner sc = new Scanner(System.in);
    static FastReader in = new FastReader();

    static class FastReader { //I don't understand how this works lmao
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int[] nextIntArray(int n) {
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) ar[i] = Integer.parseInt(next());
            return ar;
        }

        long[] nextlongArray(int n) {
            long ar[] = new long[n];
            for (int i = 0; i < n; i++) ar[i] = Long.parseLong(next());
            return ar;
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static long powerOfTwo(int n) {
        long result = 1;
        long a = 2;
        for (int i = 0; i < n; i++) {
            result = (result * a) % MOD;
        }
        return result;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // public static int lowerBound(int[] a, long x) {
    //     int low = 0;
    //     int high = a.length - 1;
    //     int ans = a.length;
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         if (a[mid] >= x) {
    //             ans = mid;
    //             high = mid - 1;
    //         } else low = mid + 1;
    //     }
    //     return ans;
    // }

    // public static int upperBound(int[] a, int x) {
    //     // Write your code here
    //     int low = 0;
    //     int high = a.length - 1;
    //     int ans = a.length;
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         if (a[mid] > x) {
    //             ans = mid;
    //             high = mid - 1;
    //         } else low = mid + 1;
    //     }
    //     return ans;
    //}

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    private static void addMap(HashMap<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }


    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }


    public static int findMaximum(int[] array) { // tell max element in the array
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static boolean Prime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }


    private static int getParent(int curr) {
        return curr / 2; // Example parent calculation
    }

    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            // Swap the elements
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            // Move the pointers
            start++;
            end--;
        }
    }
    public static int[] integerToArray(int number) {
        boolean isNegative = number < 0;
        number = Math.abs(number);

        String numberStr = Long.toString(number);
        char[] charArray = numberStr.toCharArray();

        int[] digitArray = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            digitArray[i] = Character.getNumericValue(charArray[i]);
        }

        if (isNegative) {
            digitArray[0] = -digitArray[0];
        }

        return digitArray;
    }

    public static long lcm(long a, long b) {
        long max;
        if (a > b) {
            max = a;
        } else {
            max = b;
        }
        while (true) {
            if (max % a == 0 && max % b == 0) {
                break;
            }
            max++;
        }
        return max;
    }

    public static boolean isPrime(long n) {
        // Corner cases
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean allSame(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[0]) {
                return false;
            }
        }
        return true;
    }
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = 1;
      //  int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }

    }

    static final int MOD = 1000000007; // 1e9 + 7
    static final long SPECIAL_CASE = 999966000289L;

    // may the force be with me
    // A<3
    public static void solve() throws Exception {
          int n = in.nextInt();
          int a[] = in.nextIntArray(n);
          int lower = in.nextInt();
          int upper = in.nextInt();
         long ans =  countFairPairs(a,lower,upper);
         System.out.println(ans);
        }


        static public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int low = lowerBound(nums, i + 1, nums.length, lower - nums[i]);
            int up = upperBound(nums, i + 1, nums.length, upper - nums[i]);
            ans += up - low;
        }
        return ans;
    }
    private int lowerBound(int[] a, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    private int upperBound(int[] a, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] > target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}
  

    









/*

 */








