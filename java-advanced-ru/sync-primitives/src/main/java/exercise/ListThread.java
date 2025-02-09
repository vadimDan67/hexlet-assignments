package exercise;

// BEGIN
public class ListThread extends Thread {
    private SafetyList list;
    ListThread (SafetyList myList) {
         this.list = myList;
    } 
    
    
    @Override
    public void run() {
        // В цикле начинаем с первой ячейки
        for (int i = 1; i < 1001; i++) {
           try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван");
            }
            list.add(i);  
        }
       
    }
     
}
// END
