import java.util.Arrays;


public class SquareMatrixMultiply {

    
    
    public static void main(String[] args) {
        
        int A[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int B[][] = {{1,2,3},{4,5,6},{7,8,9}};
        
        for (int i = 0; i < A.length; i++) {
            System.out.println(Arrays.toString(A[i]));
        }
        System.out.println("");
        
        SquareMatrixMultiply(A, B);
        
    }
    
    
    public static int [][] squareMatrixMultiply(int A[][],int B[][]){
        
        int C [][] = new int[A.length][A.length];
        
        for (int i = 0; i <= A.length-1; i++) {
            
            for (int j = 0; j <= A.length-1; j++) {
                C[i][j] = 0;
                for (int k = 0; k <= A.length-1; k++) {
                    
                    
                    C[i][j] = C[i][j] + (A[i][k]* B[k][j]);
                    
                }
                
                
            }
            
        }
        
        return C;
    }
    
}
