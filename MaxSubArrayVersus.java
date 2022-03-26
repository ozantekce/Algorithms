import java.util.Arrays;
import java.util.Random;

public class MaxSubArrayVersus {

    public static void main(String[] args) {

        int A[];

        long start;
        long finish;
        long timeElapsedBruteForce;
        long timeElapsedRecursive;
        long timeElapsedMixed;
        long timeElapsedLinear;

        for (int i = 3; i < Integer.MAX_VALUE - 1; i++) {

            int bruteForceResult, recursiveResult, mixedResult, linearResult;

            A = createArray(i);
            start = System.nanoTime();
            bruteForceResult = FindMaximunSubarrayBruteForce(A, 0, A.length - 1);
            finish = System.nanoTime();
            timeElapsedBruteForce = finish - start;

            start = System.nanoTime();
            recursiveResult = FindMaximunSubarray(A, 0, A.length - 1);
            finish = System.nanoTime();
            timeElapsedRecursive = finish - start;

            start = System.nanoTime();
            mixedResult = FindMaximunSubarrayMixed(A, 0, A.length - 1);
            finish = System.nanoTime();
            timeElapsedMixed = finish - start;

            start = System.nanoTime();
            linearResult = FindMaximunSubarrayLinear(A, 0, A.length - 1);
            finish = System.nanoTime();
            timeElapsedLinear = finish - start;

            if (bruteForceResult == recursiveResult && recursiveResult == mixedResult && mixedResult == linearResult) {

            } else {
                System.out.println(Arrays.toString(A));
                System.out.println("bruteForceResult : " + bruteForceResult);
                System.out.println("recursiveResult : " + recursiveResult);
                System.out.println("mixedResult : " + mixedResult);
                System.out.println("linearResult : " + linearResult);
                System.out.println("error");
                break;
            }

            System.out.println("timeElapsedBruteForce : " + timeElapsedBruteForce);
            System.out.println("timeElapsedRecursive : " + timeElapsedRecursive);
            System.out.println("timeElapsedMixed : " + timeElapsedMixed);
            System.out.println("timeElapsedLinear : " + timeElapsedLinear);

            long min = Math.min(timeElapsedBruteForce,
                     Math.min(timeElapsedMixed,
                             Math.min(timeElapsedRecursive, timeElapsedLinear)));

            if (min == timeElapsedRecursive) {

                System.out.println(i + ". try Recursive win");
            } else if (min == timeElapsedBruteForce) {

                System.out.println(i + ". Brute-force win");
            } else if (min == timeElapsedLinear) {

                System.out.println(i + ". Linear win");

            } else {
                System.out.println(i + ". Mixed win");
            }

        }

    }

    
    public static int[] createArray(int n) {

        int array[] = new int[n];
        Random r = new Random();
        array = r.ints(n, -10000, 10000).toArray();

        return array;
    }
    
    public static int FindMaximunSubarrayLinear(int A[],int low ,int high){
        
        
        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;
        
        for (int i = low; i <= high; i++) {
            
            currentSum = Math.max(0, currentSum+A[i]);
            maxSum = Math.max(currentSum, maxSum);
            
        }
        
        return maxSum;
        
    }
    

    public static int FindMaximunSubarrayBruteForce(int A[], int low, int high) {

        int max = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            int sum = 0;
            for (int j = i; j <= high; j++) {
                sum += A[j];
                if (sum > max) {
                    max = sum;
                }
            }

        }

        return max;

    }

    public static int FindMaximunSubarray(int A[], int p, int r) {

        if (p == r) {
            return A[p];
        }
        int q = (p + r) / 2;
        int L = FindMaximunSubarray(A, p, q);
        int R = FindMaximunSubarray(A, q + 1, r);
        int C = maxCrossSubarray(A, p, q, r);
        return Math.max(C, Math.max(R, L));

    }

    public static int FindMaximunSubarrayMixed(int A[], int p, int r) {

        if (p == r) {
            return FindMaximunSubarrayBruteForce(A, p, r);
        }
        int q = (p + r) / 2;
        int L = FindMaximunSubarray(A, p, q);
        int R = FindMaximunSubarray(A, q + 1, r);
        int C = maxCrossSubarray(A, p, q, r);
        return Math.max(C, Math.max(R, L));

    }

    public static int maxCrossSubarray(int A[], int p, int q, int r) {

        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        int currentSum = 0;
        for (int i = q; i >= p; i--) {
            currentSum += A[i];
            if (currentSum > leftMax) {
                leftMax = currentSum;
            }
        }

        currentSum = 0;
        for (int i = q + 1; i <= r; i++) {
            currentSum += A[i];
            if (currentSum > rightMax) {
                rightMax = currentSum;
            }
        }

        if (leftMax == Integer.MIN_VALUE) {
            leftMax = 0;
        }
        if (rightMax == Integer.MIN_VALUE) {
            rightMax = 0;
        }

        return rightMax + leftMax;

    }


}