package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");
    // BEGIN
    public static Map<String, Integer> getMinMax(int[] myArray) {
        var threadMax = new MaxThread(myArray);
        var threadMin = new MinThread(myArray);
        
        
        
        // Запускаем поток
        threadMax.start();
        threadMin.start();
        

        // Прежде, чем выводить результаты вычислений
        // нужно дождаться окончания выполнения потока thread
        // Метод join() приостановит выполнение потока main до тех пор,
        // пока поток thread не завершит работу

        try {
            threadMax.join();
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }
         try {
            threadMin.join();
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }
        return Map.of("min",threadMin.getMin(), "max", threadMax.getMax());
        
    }
    // END
}
