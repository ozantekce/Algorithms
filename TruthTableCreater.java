public class TruthTableCreater {

    
    
    public static void main(String[] args) {
        
        int inputBit = 6;
        
        int rows = (int) Math.pow(2, inputBit);
        
        
        boolean [][] inputs = new boolean[rows][inputBit];
        
        
        for (int i = 0; i < rows; i++) {
            
            for (int j = inputBit-1; j >=0; j--) {
                
                try {
                    inputs[i][j] = strtoBool(decimaltoBinaryNBit(i,inputBit))[j];
                } catch (Exception e) {
                    inputs[i][j] = false;
                }
            }
        }
        
    
        for (int i = 0; i < rows; i++) {
            
            for (int j = 0; j < inputBit; j++) {
                
                System.out.print(inputs[i][j]);
                System.out.print(" ");
                
            }
            System.out.println("");
        }
        
        
        
        
            
    }
    
    public static boolean [][]createTruthTable(int inputBit){
        
        
        int rows = (int) Math.pow(2, inputBit);
        
        
        boolean [][] inputs = new boolean[rows][inputBit];
        
        
        for (int i = 0; i < rows; i++) {
            
            for (int j = inputBit-1; j >=0; j--) {
                
                try {
                    inputs[i][j] = strtoBool(decimaltoBinaryNBit(i,inputBit))[j];
                } catch (Exception e) {
                    inputs[i][j] = false;
                }
            }
        }
        
        return inputs;
        
    }
    
    
    
    
    public static boolean [] strtoBool(String s){
        
        boolean rtn [] = new boolean[s.length()];
        
        for (int i = 0; i < rtn.length; i++) {
            if(s.charAt(i)=='1')
                rtn[i] = true;
            else if (s.charAt(i)=='0')
                rtn[i] = false;
            else
                throw new IllegalArgumentException("String can contain only 1 and 0 ");
        }
        
        return rtn;
        
    }
    
    public static String decimaltoBinaryNBit(int x, int n){
        
        String temp ="";
        temp+=Integer.toBinaryString(x);
        
        if(temp.length()>n)throw new IllegalArgumentException("incorrect n");
        
        while (temp.length()!=n) {            
            
            temp = "0"+temp;
            
        }
        
        return temp;
    }
    
    
    
    
    
    
}
