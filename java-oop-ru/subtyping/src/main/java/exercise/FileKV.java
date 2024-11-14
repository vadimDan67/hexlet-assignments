package exercise;

// BEGIN
import java.util.Map;
import java.util.HashMap;

public class FileKV implements KeyValueStorage {
    private String path;
    public FileKV(String path, Map<String, String> base) {
        this.path = path;
        Utils.writeFile(path, Utils.serialize(base));
    }
    public void set(String key, String value) {
        var str = Utils.readFile(this.path);
        var base = new HashMap<>(Utils.deserialize(str));
        base.put(key, value);
        Utils.writeFile(this.path, Utils.serialize(base));
    }
    public void unset(String key) {
        var str = Utils.readFile(this.path);
        var base = new HashMap<>(Utils.deserialize(str));
        base.remove(key);
        Utils.writeFile(this.path, Utils.serialize(base));
    }
    public String get(String key, String defaultValue) {
        var str = Utils.readFile(this.path);
        var base = new HashMap<>(Utils.deserialize(str));
        return base.getOrDefault(key, defaultValue);
    }
    public Map<String, String> toMap() {
        var str = Utils.readFile(this.path);
        var base = new HashMap<>(Utils.deserialize(str));
        return new HashMap<>(base);
    }
}
// END
