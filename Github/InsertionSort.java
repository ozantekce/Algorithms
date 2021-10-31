package Github;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int A[] = {9,9,5,4,3,2,1,0,88,8};
        insertionSortRecursive(A, A.length-1);
        System.out.println(Arrays.toString(A));

    }

    public static int [] insertionSort(int A[],int n){


        for (int j = 1; j <= n; j++) {

            int key = A[j];
            int i = j-1;
            while (i>=0 && A[i]>key){
                A[i+1] = A[i];
                i=i-1;
            }
            A[i+1] = key;
        }

        return A;
    }


    public static int [] insertionSortRecursive(int A[] ,int n){

        if(n!=0){
            insertionSortRecursive(A, n-1);
            System.out.println(n);
            sort(A, n);
        }
        return A;
    }

    public static int [] sort(int A[],int p){

        int key = A[p];
        int i = p-1;
        while (i>=0 && A[i]>key){
            A[i+1] = A[i];
            i=i-1;
        }
        A[i+1] = key;

        return A;
    }



}
