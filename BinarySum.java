public class BinarySum {


    public static void main(String[] args) {

        int A[] = {1,1,0,1,1,0,1,1};
        int B[] = {1,1,1,1,1,0,0,0};

        System.out.println(Arrays.toString(binarySum(A,B)));

    }


    public static int [] binarySum(int A[] , int B[]){

        int R[] = new int[A.length+1];
        int sum   = 0;
        int carry = 0;
        for (int i = A.length-1; i >= 0; i--) {

            sum = A[i]+B[i]+carry;
            carry = sum/2;
            sum = sum%2;
            R[i+1] = sum;

        }
        R[0] = carry;
        return R;
    }

}