public class SomeArrayOperations {


    
    //Initializing arrays with input values
    public static Object[] Method1(Object[] myList){
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter " + myList.length + " values: ");
        for (int i = 0; i < myList.length; i++) 
            myList[i] = input.nextDouble();
        return myList;
    }
    
    
    //Initializing arrays with random values
    public static Object[] Method2(Object[] myList){
        for (int i = 0; i < myList.length; i++) {
            myList[i] = Math.random() * 100;
        }

        return myList;
    }
    
    
    
    //Printing arrays
    public static Object[] Method3(Object[] myList){
        for (int i = 0; i < myList.length; i++) {
            System.out.print(myList[i] + " ");
        }

        return myList;
    }
    
    
    //Summing all elements
    public static double Method4(double [] myList){
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        return total;
    }
    
    
    
    //Finding the largest element
    public static double Method5(double [] myList){
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) max = myList[i];
        }

        return max;
    }
    
    
    //Random shuffling
    public static Object[] Method6(Object myList[]){
        
        
        for (int i = myList.length-1; i > 0; i--) {
            
            int j = (int)(Math.random()*(i+1));
            
            Object temp= myList[i];
            myList[i]=myList[j];
            myList[j]=temp;
            
            
        }

        return myList;
    }
    
    
    //Shifting Elements
    public static Object[] Method7(Object myList[]){
        
        Object temp = myList[0];
        
        for (int i = 1; i < myList.length; i++) {
            myList[i-1] = myList[i];
        }
        myList[myList.length-1]=temp;
        
        return myList;
    }
    
    
    
    
    
}
