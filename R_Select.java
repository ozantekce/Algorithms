import java.util.Arrays;
import java.util.Random;

public class R_Select {


    public static void main(String[] args) {

        int A[] = {7,10,8,6,4,2,1,9,5,3};

        System.out.println(Select(A,0,A.length-1,1));
        System.out.println(Arrays.toString(A));


    }

    public static int Select(int A[],int p,int r,int i){


        if(p==r){
            return A[p];
        }

        int q = R_PartitionH(A,p,r);
        int k = q-p+1;

        if(i<=k)
            return Select(A,p,q,i);
        else
            return Select(A,q+1,r,i-k);


    }

    public static Random random = new Random();
    public static int R_PartitionH(int A[],int p, int r){


        int s = random.nextInt(p,r+1);
        int holder = A[p];
        A[p] = A[s];
        A[s] = holder;
        return H_Partition(A,p,r);

    }

    private static int H_Partition(int[] A, int p, int r) {

        int pivot = A[p] ;
        int i=p-1;
        int j=r+1;

        while (true){

            while (true){
                j = j-1;
                if(A[j]<=pivot)
                    break;
            }

            while (true){
                i = i +1;
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


}