package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String tag, Map<String, String> attrs) {
        super(tag, attrs);
    }
    @Override
    public String toString() {
        var str = String.format("<%s", this.getTag());
        for (Map.Entry<String, String> attr: this.getAttrs().entrySet()) {
            str = str + String.format(" %s=\"%s\"", attr.getKey(), attr.getValue());
        }
        str = str + ">";
        return str;
    }
}
// END
