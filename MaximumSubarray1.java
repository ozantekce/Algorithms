
import java.util.Arrays;

public class MaximumSubarray1 {

    public static void main(String[] args) {


        int A [] = {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};


        int B[] = fillB(A);
        System.out.println(Arrays.toString(B));
        System.out.println(maxSubarray(B,0,B.length-1));

    }

    public static int [] fillB(int A[]){

        int B[] = new int[A.length-1];

        for (int i = 0; i < A.length-1; i++) {
            B[i] = A[i+1]-A[i];
        }

        return B;

    }


    public static int maxSubarray(int A[],int p,int r){


        if(p==r){
            return A[p];
        }
        int q = (p+r)/2;
        int L = maxSubarray(A, p, q);
        int R = maxSubarray(A, q+1, r);
        int C = maxCrossSubarray(A, p, q, r);
        return Math.max(C, Math.max(R, L));


    }



    public static int maxCrossSubarray(int A[],int p,int q,int r){

        int leftMax=Integer.MIN_VALUE;
        int rightMax=Integer.MIN_VALUE;

        int currentSum=0;
        for (int i = q; i >= p; i--) {
            currentSum+=A[i];
            if(currentSum>leftMax){
                leftMax = currentSum;
            }
        }

        currentSum = 0;
        for (int i = q+1; i <= r; i++) {
            currentSum+=A[i];
            if(currentSum>rightMax){
                rightMax = currentSum;
            }
        }

        if (leftMax == Integer.MIN_VALUE) {
            leftMax =0;
        }
        if (rightMax == Integer.MIN_VALUE) {
            rightMax =0;
        }


        return rightMax+leftMax;

    }


}
