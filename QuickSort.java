import java.util.Random;

public class Quicksort {


    //
    //    QUICKSORT_H (A, p, r)
    //      if p < r then
    //          q = H-PARTITION(A, p, r)
    //          QUICKSORT(A, p, q)
    //          QUICKSORT(A, q +1, r)
    //
    //    QUICKSORT_L (A, p, r)
    //      if p < r then
    //          q = H-PARTITION(A, p, r)
    //          QUICKSORT(A, p, q-1)
    //          QUICKSORT(A, q +1, r)
    //
    //    H-PARTITION (A, p, r)
    //      pivot = A[p]
    //      i = p - 1
    //      j = r + 1
    //      while true do
    //          repeat j = j - 1 until A[j] <= pivot
    //          repeat i = i + 1 until A[i] >= pivot
    //          if i < j then exchange A[i] , A[j]
    //          else return j
    //
    //
    //    L-PARTITION (A, p, r)
    //      pivot = A[r]
    //      i = p - 1
    //      for j = p to r - 1 do
    //          if A[j] <= pivot then
    //              i = i + 1
    //              exchange A[i] , A[j]
    //      exchange A[i + 1] , A[r]
    //      return i + 1
    //
    //
    //
    //      RANDOM
    //
    //    R-QUICKSORT_H(A,p,r)
    //      if(p<r)
    //          q = R-PARTITION_H(A,p,r)
    //          R-QUICKSORT_H(A,p,q)
    //          R-QUICKSORT_H(A,q+1,r)
    //
    //    R-PARTITION_H(A,p,r)
    //          s= RANDOM(p,r)
    //          exchange A[p], A[s]
    //          return H-PARTITION
    //
    //
    //    R-QUICKSORT_L(A,p,r)
    //      if(p<r)
    //          q = R-PARTITION_L(A,p,r)
    //          R-QUICKSORT_L(A,p,q-1)
    //          R-QUICKSORT_L(A,q+1,r)
    //
    //    R-PARTITION_L(A,p,r)
    //          s= RANDOM(p,r)
    //          exchange A[r], A[s]
    //          return L-PARTITION
    //
    //
    //



    public static void QuickSort_H(int A[],int p, int r){
        System.out.println(A[p]);
        if(p<r){

            int q = hoaresPartition(A,p,r);
            //System.out.println(q+1);
            QuickSort_H(A,p,q);
            QuickSort_H(A,q+1,r);

        }
        //System.out.println(Arrays.toString(A));
    }


    public static void QuickSort_L(int A[],int p, int r){

        if(p<r){

            int q = lomutosPartition(A,p,r);
            QuickSort_L(A,p,q-1);
            QuickSort_L(A,q+1,r);

        }

    }


    public static void R_QuickSort_L(int A[],int p, int r){

        if(p<r){

            int q = R_Partition_L(A,p,r);
            R_QuickSort_H(A,p,q-1);
            R_QuickSort_H(A,q+1,r);
        }


    }

    private static int R_Partition_L(int[] A, int p, int r) {
        Random random = new Random();

        int s = random.nextInt(p,r+1);
        int holder = A[s];
        A[s] = A[r];
        A[r] = holder;

        return lomutosPartition(A,p,r);

    }



    public static int hoaresPartition(int A[], int p, int r){

        int pivot = A[p];
        int i = p-1;
        int j = r+1;
        while (true){

            while (true){
                j=j-1;
                if(A[j]<=pivot)
                    break;
            }
            while (true){
                i=i+1;
                if(A[i]>=pivot)
                    break;
            }
            if(i<j){
                int holder = A[i];
                A[i] = A[j];
                A[j] = holder;
            }else{
                return j;
            }

        }

    }



    public static int lomutosPartition(int A[],int p, int r){

        int pivot = A[r];
        int i = p-1;
        for (int j = p; j <= r-1; j++) {

            if(A[j]<=pivot){
                i=i+1;
                int holder = A[i];
                A[i] = A[j];
                A[j] = holder;
            }
        }
        int holder = A[i+1];
        A[i+1] = A[r];
        A[r] = holder;
        return i+1;
    }



    public static void R_QuickSort_H(int A[],int p, int r){

        if(p<r){

            int q = R_Partition_H(A,p,r);
            R_QuickSort_H(A,p,q);
            R_QuickSort_H(A,q+1,r);
        }


    }

    private static int R_Partition_H(int[] A, int p, int r) {
        Random random = new Random();

        int s = random.nextInt(p,r+1);
        int holder = A[s];
        A[s] = A[p];
        A[p] = holder;

        return hoaresPartition(A,p,r);

    }




}
