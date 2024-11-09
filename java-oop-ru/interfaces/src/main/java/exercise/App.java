package exercise;


import java.util.List;

// BEGIN
import java.util.ArrayList;
import  java.util.Comparator;
public class App {
    public static List<String> buildApartmentsList(List<Home> builds, Integer quantity) {
        if (builds.isEmpty()) {
            return new ArrayList<String>();
        }
        var buildsSort = builds.stream()
                        .sorted(Comparator.comparingDouble(Home::getArea))
                        .toList();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            result.add(buildsSort.get(i).toString());
        }
        return result;
    }
}
// END
