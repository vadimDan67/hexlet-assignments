package exercise;

import java.util.Map;

// BEGIN
public class Tag {
    private String tag;
    private Map<String, String> attrs;
    public Tag(String tag, Map<String, String> attrs) {
        this.tag = tag;
        this.attrs = attrs;
    }
    public String getTag() {
        return this.tag;
    }
    public Map<String, String> getAttrs() {
        return this.attrs;
    }
}
// END
