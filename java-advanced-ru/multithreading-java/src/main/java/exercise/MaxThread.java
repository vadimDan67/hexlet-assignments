package exercise;

// BEGIN
public class MaxThread extends Thread {
    private static int max;
    private int[] myArray;
    // В классе нужно переопределить метод run()
    // В методе содержится логика, которую поток будет выполнять
    MaxThread(int[] myArray) {
         this.myArray = myArray;
    } 
    
    
    @Override
    public void run() {
        max = myArray[0];
        // В цикле начинаем с первой ячейки
        for (int i = 1; i < myArray.length; i++) {
            if (myArray[i] > max) {
                max = myArray[i];
            }
        }
       
    }
    
    
    
    public static Integer getMax() {
        return max;
    }
}
// END
