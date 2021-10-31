package Github;

public class BinarySearch {

    
    public static int BinarySearch(int A[],int p,int r,int v){

        if(r<p)
            return -1;
        int q = (p+r)/2;
        if(A[q]==v)
            return q;
        else if(A[q]>v)
            return BinarySearch(A,p,q-1,v);
        else
            return BinarySearch(A,q+1,r,v);

    }

}
