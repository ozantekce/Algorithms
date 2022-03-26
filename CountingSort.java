public class CountingSort {


    public static void main(String[] args) {

        int A[] = {4,1,3,4,3};

        A = countingSort(A,4);

        System.out.println(Arrays.toString(A));

    }



    public static int [] countingSort(int A[],int k){

        int B [] = new int[A.length+1];
        int C [] = new int[k+1];
        for (int i = 0; i < A.length; i++) {
            C[A[i]] = C[A[i]]+1;
        }

        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i-1];
        }

        for (int i = A.length-1; i >= 0; i--) {
            B[C[A[i]]] = A[i];
            C[A[i]] = C[A[i]]-1;
        }

        return B;
    }





}
