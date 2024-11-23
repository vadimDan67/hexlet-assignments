package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            System.out.println(String.format("%s", Math.round(circle.getSquare())));
        } catch (NegativeRadiusException exeption) {
            System.out.println(exeption.getError());
        } finally {
            System.out.println("Вычисление окончено");
        }

    }
}
// END
