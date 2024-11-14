package exercise;

import java.util.Map;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage base) {
        for (Map.Entry<String, String> str : base.toMap().entrySet()) {
            base.unset(str.getKey());
            base.set(str.getValue(), str.getKey());
        }
    }
}
// END
