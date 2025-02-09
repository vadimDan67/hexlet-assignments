package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        SafetyList list = new SafetyList();

        // Создадим два потока, которые будут менять разделяемый ресурс
        ListThread thread1 = new ListThread(list);
        ListThread thread2 = new ListThread(list);

        // Запускаем потоки
        thread1.start();
        thread2.start();

        // Дожидаемся окончания выполнения потоков
        try {

            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Проверяем результат
        System.out.println("Size: " + list.getSize());
        // END
    }
}

