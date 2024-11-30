package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        try {
            //Path createdFilePath = Files.createFile(path);
            Path file = Files.writeString(path, car.serialize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Car extract(Path path) {
        try {
            String json = Files.readString(path);
            return Car.deserialize(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
// END
