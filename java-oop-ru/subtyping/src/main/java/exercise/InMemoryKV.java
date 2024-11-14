package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> base;
    public InMemoryKV(Map<String, String> base) {
        this.base = new HashMap<>(base);
    }
    public void set(String key, String value) {
        base.put(key, value);
    }
    public void unset(String key) {
        base.remove(key);
    }
    public String get(String key, String defaultValue) {
        return base.getOrDefault(key, defaultValue);
    }
    public Map<String, String> toMap() {
        return new HashMap<>(base);
    }
}
// END
