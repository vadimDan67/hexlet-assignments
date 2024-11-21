package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> tags;
    public PairedTag(String tag, Map<String, String> attrs, String body, List<Tag> tags) {
        super(tag, attrs);
        this.body = body;
        this.tags = tags;
    }
    @Override
    public String toString() {
        var singleTag = new SingleTag(this.getTag(), this.getAttrs());
        var str = singleTag.toString();
        str = str + this.body;
        for (var tag : tags) {
            str = str + tag.toString();
        }
        str = str + String.format("</%s>", this.getTag());
        return str;
    }
}
// END
