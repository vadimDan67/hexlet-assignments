package exercise;

// BEGIN
public class MinThread extends Thread {
    private static int min;
    private int[] myArray;
    
    MinThread(int[] myArray) {
        this.myArray = myArray;
    }
    
    @Override
    public void run() {
        min = myArray[0];
        // В цикле начинаем с первой ячейки
        for (int i = 1; i < myArray.length; i++) {
            if (myArray[i] < min) {
                min = myArray[i];
            }
        }
       
    }
    
    

    public static Integer getMin() {
        return min;
    }
}
// END
