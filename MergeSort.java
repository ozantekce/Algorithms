public class MergeSort {


    public static int [] mergeSort(int A[],int p, int r){

        if(p<r){
            int q = (p+r)/2;
            mergeSort(A,p,q);
            mergeSort(A,q+1,r);
            merge(A,p,q,r);
        }

        return A;
    }

    private static void merge(int[] A, int p, int q, int r) {

        int n1 = q-p+1;
        int n2 = r-q;   //r-(q+1)+1

        int L[] = new int[n1+1];
        int R[] = new int[n2+1];

        for (int i = 0; i <n1; i++) {
            L[i] = A[p+i];
        }
        for (int i = 0; i <n2; i++) {
            R[i] = A[q+1+i];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i=0;
        int j=0;
        for (int k = p; k <= r; k++) {

            if(L[i]<=R[j]){
                A[k] = L[i];
                i = i+1;
            }else{
                A[k] = R[j];
                j = j+1;
            }

        }

    }




}
